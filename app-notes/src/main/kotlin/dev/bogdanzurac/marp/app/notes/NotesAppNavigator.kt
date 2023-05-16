package dev.bogdanzurac.marp.app.notes

import dev.bogdanzurac.marp.core.logger
import dev.bogdanzurac.marp.feature.auth.ui.Auth
import dev.bogdanzurac.marp.feature.auth.ui.AuthNavigator
import dev.bogdanzurac.marp.feature.notes.ui.Notes
import dev.bogdanzurac.marp.feature.notes.ui.NotesNavigator
import dev.bogdanzurac.marp.core.navigation.AppNavigator
import dev.bogdanzurac.marp.core.navigation.FeatureNavigator
import org.koin.core.annotation.Single

@Single
class NotesAppNavigator(
    private val authNavigator: AuthNavigator,
    private val notesNavigator: NotesNavigator,
) : AppNavigator() {

    override fun getFeatureNavigatorForRoute(route: String): FeatureNavigator {
        logger.d("Getting FeatureNavigator for route: $route")
        return when (route) {
            Auth.path -> authNavigator
            Notes.path -> notesNavigator
            else -> throw IllegalStateException("Current route '$route' is not associated with a FeatureNavigator")
        }
    }
}