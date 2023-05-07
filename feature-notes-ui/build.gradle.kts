plugins {
    alias(libs.plugins.marp.feature.ui)
    alias(libs.plugins.marp.publishing)
}

project.ext {
    group = "dev.bogdanzurac.marp"
    version = "0.0.1"
}

android {
    namespace = "dev.bogdanzurac.marp.feature.notes.ui"
}

dependencies {
    implementation(libs.marp.core.auth)
    implementation(libs.marp.feature.crypto.ui.common)
    implementation(libs.marp.feature.notes.domain)
    implementation(libs.marp.feature.notes.ui.common)
}
