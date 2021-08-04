import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
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

val jdk8 = sourceSets["main"] // default is fine

//val jdk8 = sourceSets.create("mai") {
//    java.srcDir("src/main/java")
//    kotlin.srcDir("src/main/kotlin")
//}

//configurations.create("mai") {
//    isCanBeResolved = false
//    isCanBeConsumed = true
//    extendsFrom(configurations.findByName("runtimeElements"))
//    attributes {
//        attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 8)
//    }
//}

//val jdk11 = sourceSets["main"]
val jdk11 = sourceSets.create("jpms") {
    println(java.srcDirs)
    println(kotlin.srcDirs)
    java.srcDir(jdk8.java)
    println()
    println(java.srcDirs)
    println(kotlin.srcDirs)
//    kotlin.srcDir("src/main/kotlin")
//    println()
//    println(java.srcDirs)
//    println(kotlin.srcDirs)
}

//configurations.create("jpms") {
//    isCanBeResolved = false
//    isCanBeConsumed = true
//    extendsFrom(configurations.findByName("runtimeElements"))
//    attributes {
//        attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 11)
//    }
//}

java.registerFeature("jdk8") {
    usingSourceSet(jdk8)
    //    capability(project.group.toString(), project.name, project.version.toString())
    capability("group", "name", "0.1")
}

configureCompileVersion(jdk8, 8)
configureCompileVersion(jdk11, 11)

fun configureCompileVersion(set: SourceSet, jdkVersion: Int) {
    val compiler = project.javaToolchains.compilerFor {
        languageVersion.set(JavaLanguageVersion.of(jdkVersion))
    }.get()
    tasks {
        named<KotlinCompile>(set.compileKotlinTaskName) {
            kotlinOptions {
                jvmTarget = if(jdkVersion == 8) "1.8" else jdkVersion.toString()
                jdkHome = compiler.metadata.installationPath.asFile.absolutePath
            }
            source = sourceSets.main.get().kotlin
        }
        named<JavaCompile>(set.compileJavaTaskName) {
            javaCompiler.set(compiler)
            source = sourceSets.main.get().allJava + set.allJava
        }
    }
}

val SourceSet.compileKotlinTaskName: String
    get() = getCompileTaskName("kotlin")

val SourceSet.kotlin: SourceDirectorySet
    get() = withConvention(KotlinSourceSet::class) { kotlin }

val moduleName = "$group.$name"

tasks.compileJava {
    // this is needed because we have a separate compile step in this example with the 'module-info.java' is in 'main/java' and the Kotlin code is in 'main/kotlin'
    options.compilerArgs = listOf("--patch-module", "org.module.kotlin=${sourceSets.main.get().output.asPath}")
}

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