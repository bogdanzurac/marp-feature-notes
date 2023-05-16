package dev.bogdanzurac.marp.app.notes.dashboard

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import dev.bogdanzurac.marp.app.notes.theme.ElgoogTheme
import dev.bogdanzurac.marp.core.navigation.AppRoute
import dev.bogdanzurac.marp.feature.auth.ui.authNavGraph
import dev.bogdanzurac.marp.feature.dashboard.ui.DashboardActivity
import dev.bogdanzurac.marp.feature.notes.ui.Notes
import dev.bogdanzurac.marp.feature.notes.ui.notesNavGraph
import java.util.*

class NotesDashboardActivity : DashboardActivity() {

    @Composable
    override fun AppTheme(content: @Composable () -> Unit) {
        ElgoogTheme { content() }
    }

    override val navGraphBuilder: NavGraphBuilder.() -> Unit = {
        authNavGraph()
        notesNavGraph()
    }

    override val startRoute: AppRoute = Notes

    override val locale: Locale = Locale.ENGLISH
}
