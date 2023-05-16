import dev.bogdanzurac.marp.feature.notes.projects

plugins {
    alias(libs.plugins.marp.app)
}

android {
    namespace = "dev.bogdanzurac.marp.app.notes"

    defaultConfig {
        applicationId = "dev.bogdanzurac.marp.app.notes"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {
    implementation(libs.marp.feature.auth.ui)
    implementation(libs.marp.feature.dashboard.ui)
    implementation(project(projects.featureNotesData))
    implementation(project(projects.featureNotesDomain))
    implementation(project(projects.featureNotesUi))
    implementation(libs.marp.lib.db.firebase)
    implementation(libs.marp.lib.flagging.firebase)
    implementation(libs.marp.lib.tracking.firebase)
}
