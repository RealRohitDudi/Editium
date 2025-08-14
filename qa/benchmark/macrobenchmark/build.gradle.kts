plugins {
    id("com.android.test")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.editium.benchmark"
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets {
        getByName("androidTest") { java.srcDirs("src/androidTest/kotlin") }
    }

    defaultConfig { minSdk = libs.versions.minSdk.get().toInt() }
    targetProjectPath = ":app"
}

dependencies {
    implementation(libs.androidx.core.ktx)
}
