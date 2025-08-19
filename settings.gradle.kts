pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        // Add additional repositories for missing dependencies
        maven { url = uri("https://repo1.maven.org/maven2") }
        maven { url = uri("https://jcenter.bintray.com") }
    }
    versionCatalogs {
        create("libs") {
            from(files("versions/libs.versions.toml"))
        }
    }
}
rootProject.name = "Editium"
include(
    ":app",
    ":core-video",
    ":core-audio",
    ":core-ui",
    ":core-data",
    ":feature-timeline",
    ":feature-effects",
    ":feature-export",
    ":feature-project",
    ":qa:benchmark:macrobenchmark"
)
