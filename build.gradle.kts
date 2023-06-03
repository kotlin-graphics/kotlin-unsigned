import magik.createGithubPublication
import magik.github
import org.jetbrains.kotlin.gradle.dsl.KotlinCompile

plugins {
    kotlin("jvm") version embeddedKotlinVersion
    id("elect86.magik") version "0.3.2"
    `maven-publish`
//    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories { mavenCentral() }

dependencies {
    testImplementation("io.kotest:kotest-runner-junit5:5.6.2")
    testImplementation("io.kotest:kotest-assertions-core:5.6.2")
}

kotlin.jvmToolchain { languageVersion.set(JavaLanguageVersion.of(8)) }

tasks {
    withType<KotlinCompile<*>>().all {
        kotlinOptions { freeCompilerArgs += listOf("-opt-in=kotlin.RequiresOptIn") }
    }
}

publishing {
    publications {
        createGithubPublication {
            from(components["java"])
            suppressAllPomMetadataWarnings()
        }
    }
    repositories { github { domain = "kotlin-graphics/mary" } }
}

java.withSourcesJar()
