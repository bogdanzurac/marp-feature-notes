package dev.bogdanzurac.marp.feature.notes

object projects {
    const val featureNotesDomain = ":feature-notes-domain"
    const val featureNotesUiCommon = ":feature-notes-ui-common"
}

val useArtifacts: Boolean
    get() = System.getProperty("useArtifacts").toBoolean()