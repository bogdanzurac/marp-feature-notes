package dev.bogdanzurac.marp.feature.notes.ui

import dev.bogdanzurac.marp.core.auth.AuthManager
import dev.bogdanzurac.marp.core.combineResult
import dev.bogdanzurac.marp.core.foldResult
import dev.bogdanzurac.marp.core.logger
import dev.bogdanzurac.marp.core.onFailure
import dev.bogdanzurac.marp.core.prompts.DialogManager
import dev.bogdanzurac.marp.core.ui.BaseViewModel
import dev.bogdanzurac.marp.core.ui.Tracker
import dev.bogdanzurac.marp.core.ui.UiState
import dev.bogdanzurac.marp.core.ui.getGenericErrorDialogFor
import dev.bogdanzurac.marp.feature.notes.domain.Note
import dev.bogdanzurac.marp.feature.notes.domain.ObserveNotesUseCase
import dev.bogdanzurac.marp.feature.notes.domain.ObserveUserNotesUseCase
import dev.bogdanzurac.marp.feature.notes.ui.NotesListViewModel.NotesListUiState
import dev.bogdanzurac.marp.feature.notes.ui.NotesListViewModel.NotesListUiState.*
import kotlinx.coroutines.flow.*
import org.koin.core.annotation.Factory
import kotlin.Result.Companion.success

@Factory
internal class NotesListViewModel(
    private val dialogManager: DialogManager,
    private val featureCallbacks: NotesCallbacks,
    private val notesNavigator: NotesNavigator,
    private val tracker: Tracker,
    private val observeNotesUseCase: ObserveNotesUseCase,
    private val observeUserNotesUseCase: ObserveUserNotesUseCase,
    authManager: AuthManager,
) : BaseViewModel<NotesListUiState>(), NotesListUiEvents {

    private fun observeNotes(): Flow<Result<List<Note>>> =
        if (featureCallbacks.shouldShowAllNotes()) observeNotesUseCase()
        else observeUserNotesUseCase()

    override val uiState: StateFlow<NotesListUiState> =
        authManager.observeAuthenticatedState()
            .flatMapLatest { isAuthenticated ->
                if (!isAuthenticated) flowOf(success(Pair(emptyList(), isAuthenticated)))
                else observeNotes().combineResult(flowOf(success(isAuthenticated)))
            }
            .onStart { tracker.trackScreen(NOTES_LIST_SCREEN) }
            .onFailure {
                logger.e("Could not get notes list", it)
                dialogManager.showDialog(getGenericErrorDialogFor(it))
            }
            .foldResult({ (notes, isAuthenticated) ->
                when {
                    !isAuthenticated -> NotLoggedIn
                    else -> Success(
                        notes.filter { it.cryptoId.isNullOrBlank() },
                        notes.filter { it.cryptoId?.isNotBlank() == true },
                        !featureCallbacks.shouldShowAllNotes()
                    )
                }
            }, { Error(it) })
            .asState(Loading)

    internal sealed class NotesListUiState : UiState {
        class Error(val exception: Throwable) : NotesListUiState()
        class Success(
            val personalNotes: List<Note>,
            val cryptoNotes: List<Note>,
            val showAddNoteButton: Boolean,
        ) : NotesListUiState()

        object Loading : NotesListUiState()
        object NotLoggedIn : NotesListUiState()
    }

    override fun onAddNoteClicked() {
        notesNavigator.navigateToAddNote()
    }

    override fun onNoteClicked(id: String) {
        notesNavigator.navigateToNoteDetails(id)
    }

    override fun onLoginClicked() {
        notesNavigator.navigateToLogin()
    }
}

internal interface NotesListUiEvents {
    fun onAddNoteClicked()
    fun onNoteClicked(id: String)
    fun onLoginClicked()
}