plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.kapt)
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
        // Temporarily disable native build for debugging
        // externalNativeBuild { cmake {} }
        // ndk { abiFilters += listOf("arm64-v8a", "armeabi-v7a") }
    }

    // Temporarily disable native build for debugging
    // externalNativeBuild {
    //     cmake {
    //         path = file("src/main/cpp/CMakeLists.txt")
    //         version = "3.22.1"
    //     }
    // }
    buildFeatures {
        buildConfig = false
        // Temporarily disable for debugging
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":core-data"))
    implementation(libs.androidx.media3.exoplayer)
    // Temporarily comment out the decoder dependency as it's not available
    // implementation(libs.androidx.media3.decoder)
    implementation(libs.kotlinx.coroutines.android)
    // Temporarily comment out the opengl dependency as it's not available
    // implementation(libs.androidx.opengl)
    // Temporarily comment out the vulkan dependency as it's not available
    // implementation(libs.androidx.vulkan)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    implementation(libs.timber)
}
