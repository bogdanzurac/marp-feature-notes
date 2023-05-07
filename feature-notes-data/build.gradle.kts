plugins {
    alias(libs.plugins.marp.feature.data)
    alias(libs.plugins.marp.publishing)
}

project.ext {
    group = "dev.bogdanzurac.marp"
    version = "0.0.1"
}

android {
    namespace = "dev.bogdanzurac.marp.feature.notes.data"
}

dependencies {
    implementation(libs.marp.core.auth)
    implementation(libs.marp.lib.db.firebase)
    implementation(libs.marp.feature.notes.domain)
}