import org.gradle.api.attributes.java.TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.4.30"
    `maven-publish` // Jitpack
    id("org.jetbrains.dokka") version "1.4.20"
    id("docs")
}

val group = "com.github.kotlin_graphics"
val moduleName = "$group.kotlin_unsigned"
val kotestVersion = "4.3.2"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
}

java.modularity.inferModulePath.set(true)

tasks {

    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "11"
            freeCompilerArgs += listOf("-Xinline-classes", "-Xopt-in=kotlin.RequiresOptIn")
        }
        sourceCompatibility = "11"
    }

    compileJava { // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
        options.compilerArgs = listOf("--patch-module", "$moduleName=${sourceSets.main.get().output.asPath}")
    }

    withType<Test> { useJUnitPlatform() }
}

publishing.publications.register("mavenJava", MavenPublication::class) {
    from(components["java"])
}

configurations.all { attributes.attribute(TARGET_JVM_VERSION_ATTRIBUTE, 11) }

java.withSourcesJar()