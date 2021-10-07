rootProject.name = "unsigned"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://raw.githubusercontent.com/kotlin-graphics/mary/master")
//        mavenLocal()
    }

//    includeBuild("../build-logic")
}

gradle.rootProject {
    group = "kotlin.graphics"
    version = "3.3.1+3"
}

//includeBuild("../magik")