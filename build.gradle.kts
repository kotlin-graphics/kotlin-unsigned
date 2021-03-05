
plugins {
    val build = "0.4.7"
    id("kx.kotlin.11") version build
    id("kx.dokka") version build
    java
    `maven-publish`
}

group = "com.github.kotlin.graphics"
version = "3.2.9"

repositories {
    maven("https://repo.repsy.io/mvn/elect/kx")
}

publishing {
    publications.create<MavenPublication>("mavenJava") {
        from(components["java"])
    }
}