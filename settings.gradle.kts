rootProject.name = "unsigned"

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
    }
}

gradle.rootProject {
    group = "kotlin.graphics"
    version = "3.3.1+5"
}

//includeBuild("../magik")