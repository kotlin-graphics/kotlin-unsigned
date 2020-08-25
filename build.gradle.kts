import org.gradle.api.attributes.java.TargetJvmVersion.*
import org.jetbrains.dokka.gradle.DokkaTask

plugins {
    java
    kotlin("jvm") version "1.4.0"
//    maven
    id("org.jetbrains.dokka") version "1.4.0-rc"
}

val group = "com.github.kotlin_graphics"
val moduleName = "$group.kotlin_unsigned"
val kotestVersion = "4.2.0"

repositories {
    mavenCentral()
    jcenter()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
}

configurations.all {
    attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 8)
}

tasks {

    dokkaHtml {
        dokkaSourceSets {
            configureEach {
                sourceLink {
                    // Unix based directory relative path to the root of the project (where you execute gradle respectively).
                    path = "src/main/kotlin"
                    // URL showing where the source code can be accessed through the web browser
                    url = "https://github.com/kotlin-graphics/kotlin-unsigned/tree/master/src/main/kotlin"
                    // Suffix which is used to append the line number to the URL. Use #L for GitHub
                    lineSuffix = "#L"
                }
            }
        }
    }

    compileKotlin {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-XXLanguage:+InlineClasses")
        }
        sourceCompatibility = "1.8"
    }

    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
        sourceCompatibility = "1.8"
    }

    withType<Test> { useJUnitPlatform() }
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().getOutputDirectoryAsFile())
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.get().getOutputDirectoryAsFile())
    archiveClassifier.set("html-doc")
}

val sourceJar = task("sourceJar", Jar::class) {
    dependsOn(tasks["classes"])
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}

artifacts {
    archives(dokkaJavadocJar)
    archives(dokkaHtmlJar)
    archives(sourceJar)
}