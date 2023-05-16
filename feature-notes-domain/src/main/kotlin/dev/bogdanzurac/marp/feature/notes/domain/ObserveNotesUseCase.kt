package dev.bogdanzurac.marp.feature.notes.domain

import dev.bogdanzurac.marp.core.mapResult
import dev.bogdanzurac.marp.feature.crypto.domain.CryptoRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Singleton

@Singleton
class ObserveNotesUseCase(
    private val cryptoRepository: CryptoRepository,
    private val notesRepository: NotesRepository,
) {

    operator fun invoke(): Flow<Result<List<Note>>> =
        notesRepository.observeNotes()
            .mapResult { notes ->
                notes.map { note ->
                    note.cryptoId?.let {
                        return@map note.copy(
                            cryptoAsset = cryptoRepository.getCryptoAsset(it).getOrNull()
                        )
                    } ?: note
                }
            }
}