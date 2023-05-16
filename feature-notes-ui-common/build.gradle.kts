import dev.bogdanzurac.marp.feature.notes.projects
import dev.bogdanzurac.marp.feature.notes.useArtifacts

plugins {
    alias(libs.plugins.marp.feature.ui)
    alias(libs.plugins.marp.publishing)
}

project.ext {
    group = "dev.bogdanzurac.marp"
    version = "0.0.1"
}

android {
    namespace = "dev.bogdanzurac.marp.feature.notes.ui.common"
}

dependencies {
    implementation(
        if (useArtifacts) libs.marp.feature.notes.domain
        else project(projects.featureNotesDomain)
    )
}