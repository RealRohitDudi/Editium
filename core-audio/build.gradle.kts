plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.editium.core.audio"
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets {
        getByName("main") { java.srcDirs("src/main/kotlin") }
        getByName("test") { java.srcDirs("src/test/kotlin") }
        getByName("androidTest") { java.srcDirs("src/androidTest/kotlin") }
    }

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("${rootDir}/config/proguard/proguard-consumer-rules.pro")
    }
    buildFeatures { buildConfig = true }
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
}
