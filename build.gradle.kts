import org.jetbrains.kotlin.gradle.dsl.KotlinCommonProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.30"
    //    val build = "0.6.4"
    //    id("kx.kotlin.11") version build
    //    id("kx.dokka") version build
    //    id("kx.jitpack") version build
    `java-library`
    `maven-publish`
}

group = "kotlin.graphics"
version = "3.3.1"

repositories {
    mavenCentral()
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))

    testImplementation("io.kotest:kotest-runner-junit5:4.4.1")
    testImplementation("io.kotest:kotest-assertions-core:4.4.1")
}

val jdk11 = sourceSets.main.get()

val jdk8 = sourceSets.create("jdk8") {
    java.setSrcDirs(emptySet<File>())
    kotlin.setSrcDirs(emptySet<File>())
    java.setSrcDirs(jdk11.java.srcDirs)
    kotlin.setSrcDirs(jdk11.kotlin.srcDirs)
    java.setExcludes(listOf("module-info.java"))
    kotlin.setExcludes(listOf("module-info.java"))
}

//println(jdk11.java.srcDirs)
//println(jdk11.java.files)
//println(jdk11.kotlin.srcDirs)
//println(jdk11.kotlin.files)
//println()
//println(jdk8.java.srcDirs)
//println(jdk8.java.files)
//println(jdk8.kotlin.srcDirs)
//println(jdk8.kotlin.files)

java.registerFeature("jdk8") {
    usingSourceSet(jdk8)
    //    capability(project.group.toString(), project.name, project.version.toString())
    capability("group", "name", "0.1")
}

configureCompileVersion(jdk8, 8)
configureCompileVersion(jdk11, 11)

val moduleName = "$group.$name"

fun configureCompileVersion(set: SourceSet, jdkVersion: Int) {
    val compiler = project.javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }.get()
    val target = if (jdkVersion == 8) "1.8" else jdkVersion.toString()
    kotlin {
        jvmToolchain {
            (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of(jdkVersion))
        }
    }
    tasks {
        named<KotlinCompile>(set.compileKotlinTaskName) {
            kotlinOptions.jvmTarget = target
            source = sourceSets.main.get().kotlin
        }
        named<JavaCompile>(set.compileJavaTaskName) {
            println("configureCompileVersion $set $jdkVersion")
            targetCompatibility = target
            sourceCompatibility = target
            modularity.inferModulePath.set(jdkVersion >= 9)
            javaCompiler.set(compiler)
            source = set.allJava
            //            println(source.files)
            if (jdkVersion >= 9)
                options.compilerArgs = listOf("--patch-module", "$moduleName=${set.output.asPath}")
        }
    }
}

val SourceSet.compileKotlinTaskName: String
    get() = getCompileTaskName("kotlin")

val SourceSet.kotlin: SourceDirectorySet
        get() = project.extensions.getByType<KotlinJvmProjectExtension>().sourceSets.getByName(name).kotlin

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "org.gradle.sample"
            artifactId = "library"
            version = "1.1"

            from(components["java"])
        }
    }
    repositories.maven {
        name = "prova"
        url = uri("repo")
    }
}