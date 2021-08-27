rootProject.name = "unsigned"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
}

gradle.rootProject {
    version = "3.3.1"
}

includeBuild("../build-logic")
includeBuild("../magik")