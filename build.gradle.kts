import java.io.ByteArrayOutputStream

plugins {
    val build = "0.7.0+79"
    id("kx.kotlin.11") version build
    id("kx.dokka") version build
    //    id("kx.publish") version build
    `maven-publish`
}

version = "3.2.9"

//val gitDescribe: String
//    get() = ByteArrayOutputStream().also { exec { commandLine("git", "describe", "--tags"); standardOutput = it; } }.toString().trim()
//
//val gitDistance: Int
//    get() = gitDescribe.substringBeforeLast("-g").substringAfterLast('-').toInt()
//
//val gitTag: String
//    get() = gitDescribe.substringBeforeLast('-').substringBeforeLast('-')
//
//val lastRelease: String
//    get() = if (gitTag[0] == 'v') gitTag.drop(1) else gitTag
//
//println("$lastRelease+$gitDistance")
//
//println(System.getProperty("VERSION"))

publishing {
    publications {
        create<MavenPublication>("main") {
//            artifactId = "$lastRelease-$gitDistance"
            from(components["java"])
        }
    }

    repositories {
        maven {
            name = "mary"
            url = uri("https://maven.pkg.github.com/kotlin-graphics/mary")
            credentials(PasswordCredentials::class)
        }
    }
}