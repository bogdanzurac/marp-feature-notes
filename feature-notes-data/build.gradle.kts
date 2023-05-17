import dev.bogdanzurac.marp.feature.notes.projects
import dev.bogdanzurac.marp.feature.notes.useArtifacts

plugins {
    alias(libs.plugins.marp.feature.data)
    alias(libs.plugins.marp.publishing)
}

project.ext {
    group = "dev.bogdanzurac.marp"
    version = "0.0.2"
}

android {
    namespace = "dev.bogdanzurac.marp.feature.notes.data"
}

dependencies {
    implementation(libs.marp.core.auth)
    implementation(libs.marp.lib.db.firebase)
    implementation(
        if (useArtifacts) libs.marp.feature.notes.domain
        else project(projects.featureNotesDomain)
    )
}