package dev.bogdanzurac.marp.feature.notes.domain

import dev.bogdanzurac.marp.core.mapResultCatching
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import org.koin.core.annotation.Factory

@Factory
class ObserveNoteUseCase(
    private val observeNotesUseCase: ObserveNotesUseCase,
) {

    operator fun invoke(id: String): Flow<Result<Note>> =
        observeNotesUseCase()
            .mapResultCatching { notes ->
                notes.first { it.id == id }
            }
            .distinctUntilChanged()
}