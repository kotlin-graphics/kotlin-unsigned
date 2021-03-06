
plugins {
    val build = "0.4.8"
    id("kx.kotlin.11") version build
    id("kx.dokka") version build
    java
    `maven-publish`
}

group = "com.github.kotlin.graphics"
version = "3.3.0"

repositories {
    maven("https://repo.repsy.io/mvn/elect/kx")
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}