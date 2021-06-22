import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
    //    val build = "0.6.4"
    //    id("kx.kotlin.11") version build
    //    id("kx.dokka") version build
    //    id("kx.jitpack") version build
    java
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

val jdk11 = sourceSets.create("jpms") {
    java.srcDir("src/main/java")
}

java.registerFeature("jdk8") {
    usingSourceSet(jdk8)
    capability(project.group.toString(), project.name, project.version.toString())
}

jdk8 configureCompileVersion 8
jdk11 configureCompileVersion 11

infix fun SourceSet.configureCompileVersion(jdkVersion: Int) {
    //    println("sourceset: ${this@configureCompileVersion.compileJavaTaskName}")
    //    println("sourceset: ${this@configureCompileVersion.compileKotlinTaskName}")
    //        tasks.withType<KotlinJvmCompile> {
    //            println(this.name)
    //        }
    //    tasks.withType<JavaCompile> { println(this.name) }
    //    tasks.withType<KotlinJvmCompile> { println(this.name) }
    //    tasks.named<KotlinJvmCompile>("compileKotlin") {
    //        println(kotlinOptions.jdkHome)
    //    }
    //    tasks.forEach { println("[${it.name}]:${it.javaClass}") }
    //    tasks.named<KotlinJvmCompile>(compileKotlinTaskName) {
    //        val compiler = javaToolchains.compilerFor {
    //            languageVersion.set(JavaLanguageVersion.of(javaVersion))
    //        }.get()
    //        kotlinOptions.jdkHome = compiler.metadata.installationPath.asFile.absolutePath
    //    }
    tasks {
        named<KotlinCompile>(compileKotlinTaskName) {
            val compiler = project.javaToolchains.compilerFor {
                languageVersion.set(JavaLanguageVersion.of(jdkVersion))
            }.get()
            kotlinOptions.jdkHome = compiler.metadata.installationPath.asFile.absolutePath
            source = sourceSets.main.get().kotlin
        }
        named<JavaCompile>(compileJavaTaskName) {
            javaCompiler.set(project.javaToolchains.compilerFor {
                languageVersion.set(JavaLanguageVersion.of(jdkVersion))
            })
            source = sourceSets.main.get().java + java
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