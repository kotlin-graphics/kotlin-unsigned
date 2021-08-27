
version = "3.3.0"

plugins {
    val build = "0.7.0+79"
    id("kx.kotlin") version build
    //    id("kx.dokka") version build
    //    id("kx.publish") version build
    `maven-publish`
}


publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        suppressPomMetadataWarningsFor("runtimeElements")
    }
    repositories {
        maven {
            name = "repo"
            url = uri("$rootDir/repo")
        }
    }
}