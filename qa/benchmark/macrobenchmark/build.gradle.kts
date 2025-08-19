plugins {
    id("com.android.test")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.editium.benchmark"
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
            java.srcDirs("src/androidTest/kotlin") // Include androidTest sources in main
        }
    }

    defaultConfig { minSdk = libs.versions.minSdk.get().toInt() }
    targetProjectPath = ":app"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
