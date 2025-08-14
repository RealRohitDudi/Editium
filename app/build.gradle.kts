plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.editium.app"
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets {
        getByName("main") { java.srcDirs("src/main/kotlin") }
        getByName("test") { java.srcDirs("src/test/kotlin") }
        getByName("androidTest") { java.srcDirs("src/androidTest/kotlin") }
    }

    defaultConfig {
        applicationId = "com.editium"
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                file("${rootDir}/config/proguard/proguard-android-optimize.pro"),
                file("${rootDir}/config/proguard/proguard-ffmpeg.pro")
            )
        }
        debug { isMinifyEnabled = false }
    }

    buildFeatures {
        buildConfig = true
    }
    packaging {
        resources.excludes += listOf("META-INF/**")
    }
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":core-data"))
    implementation(project(":core-video"))
    implementation(project(":core-audio"))
    implementation(project(":feature-timeline"))
    implementation(project(":feature-effects"))
    implementation(project(":feature-export"))
    implementation(project(":feature-project"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}
