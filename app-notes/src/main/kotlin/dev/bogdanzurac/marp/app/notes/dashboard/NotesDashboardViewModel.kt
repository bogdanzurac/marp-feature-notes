package dev.bogdanzurac.marp.app.notes.dashboard

import dev.bogdanzurac.marp.core.auth.AuthManager
import dev.bogdanzurac.marp.core.feature.FeatureManager
import dev.bogdanzurac.marp.core.navigation.AppNavigator
import dev.bogdanzurac.marp.feature.dashboard.ui.BottomNavigationItem
import dev.bogdanzurac.marp.feature.dashboard.ui.DashboardViewModel
import org.koin.core.annotation.Factory

@Factory
class NotesDashboardViewModel(
    appNavigator: AppNavigator,
    authManager: AuthManager,
    featureManager: FeatureManager
) : DashboardViewModel(appNavigator, authManager, featureManager) {

    override val bottomNavigationItems: List<BottomNavigationItem> = emptyList()
}