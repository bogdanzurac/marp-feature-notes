package dev.bogdanzurac.marp.app.notes

import dev.bogdanzurac.marp.core.auth.CoreAuthModule
import dev.bogdanzurac.marp.core.data.CoreDataModule
import dev.bogdanzurac.marp.core.ui.CoreUiModule
import dev.bogdanzurac.marp.feature.auth.ui.FeatureAuthUiModule
import dev.bogdanzurac.marp.feature.notes.data.FeatureNotesDataModule
import dev.bogdanzurac.marp.feature.notes.domain.FeatureNotesDomainModule
import dev.bogdanzurac.marp.feature.notes.ui.FeatureNotesUiModule
import dev.bogdanzurac.marp.lib.db.firebase.LibDbFirebaseModule
import dev.bogdanzurac.marp.lib.flagging.firebase.LibFlaggingFirebaseModule
import dev.bogdanzurac.marp.lib.tracking.firebase.LibTrackingFirebaseModule
import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Module
import org.koin.ksp.generated.module

internal val koinModules = listOf(
    NotesAppModule().module,
    CoreAuthModule().module,
    CoreDataModule().module,
    CoreUiModule().module,
    FeatureAuthUiModule().module,
    FeatureNotesDataModule().module,
    FeatureNotesDomainModule().module,
    FeatureNotesUiModule().module,
    LibDbFirebaseModule().module,
    LibFlaggingFirebaseModule().module,
    LibTrackingFirebaseModule().module,
)

@Module
@ComponentScan
class NotesAppModule
