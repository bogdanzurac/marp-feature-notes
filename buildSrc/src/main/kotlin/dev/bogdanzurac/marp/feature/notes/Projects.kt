package dev.bogdanzurac.marp.feature.notes

object projects {
    const val featureNotesData = ":feature-notes-data"
    const val featureNotesDomain = ":feature-notes-domain"
    const val featureNotesUi = ":feature-notes-ui"
    const val featureNotesUiCommon = ":feature-notes-ui-common"
}

val useArtifacts: Boolean
    get() = System.getProperty("useArtifacts").toBoolean()