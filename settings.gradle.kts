rootProject.name = "unsigned"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
}


includeBuild("../build-logic")
includeBuild("../magik")