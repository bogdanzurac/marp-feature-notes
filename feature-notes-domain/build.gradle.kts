plugins {
    alias(libs.plugins.marp.feature.domain)
    alias(libs.plugins.marp.publishing)
}

project.ext {
    group = "dev.bogdanzurac.marp"
    version = "0.0.1"
}

android {
    namespace = "dev.bogdanzurac.marp.feature.notes.domain"
}

dependencies {
    implementation(libs.marp.core.auth)
    api(libs.marp.feature.crypto.domain)
}
