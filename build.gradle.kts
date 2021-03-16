
plugins {
    val build = "0.7.0+27"
    id("kx.kotlin.11") version build
    id("kx.dokka") version build
    id("kx.publish") version "0.1.5"
    `java-library`
}

version = "3.2.9+18"

//publishing {
////     default in java-library
////        publications.create<MavenPublication>("maven") {
////            from(components["java"])
////        }
////    repositories {
////        maven {
////            url = uri("$rootDir/../mary")
////        }
////    }
//}