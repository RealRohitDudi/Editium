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
