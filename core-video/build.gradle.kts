plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.editium.core.video"
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets {
        getByName("main") { java.srcDirs("src/main/kotlin") }
        getByName("test") { java.srcDirs("src/test/kotlin") }
        getByName("androidTest") { java.srcDirs("src/androidTest/kotlin") }
    }

    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
        consumerProguardFiles("${rootDir}/config/proguard/proguard-consumer-rules.pro")
        externalNativeBuild { cmake {} }
        ndk { abiFilters += listOf("arm64-v8a", "armeabi-v7a") }
    }

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    buildFeatures { buildConfig = true }
}

dependencies {
    implementation(project(":core-data"))
    implementation(libs.androidx.media3.exoplayer)
    implementation(libs.androidx.media3.decoder)
    implementation(libs.kotlinx.coroutines.android)
}
