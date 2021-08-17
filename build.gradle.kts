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


val jdk8 = sourceSets.create("jdk8") {
    java.srcDir("src/main/java")
    kotlin.srcDir("src/main/kotlin")
}

val jdk11 = sourceSets["main"].apply {
    java.srcDir("src/jpms/java")
}

//println(jdk11.java.srcDirs)
//println(jdk11.kotlin.srcDirs)
//println(jdk8.java.srcDirs)
//println(jdk8.kotlin.srcDirs)

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
    val target = if (jdkVersion == 8) "1.8" else jdkVersion.toString()
    tasks {
        named<KotlinCompile>(set.compileKotlinTaskName) {
            kotlinOptions {
                jvmTarget = target
                jdkHome = compiler.metadata.installationPath.asFile.absolutePath
            }
            source = sourceSets.main.get().kotlin
        }
        named<JavaCompile>(set.compileJavaTaskName) {
            targetCompatibility = target
            sourceCompatibility = target
            modularity.inferModulePath.set(jdkVersion >= 9)
            javaCompiler.set(compiler)
            source = sourceSets.main.get().allJava + set.allJava
            if (jdkVersion >= 9)
                options.compilerArgs = listOf("--patch-module", "kotlin.graphics.unsigned=${set.output.asPath}")
        }
    }
}

val SourceSet.compileKotlinTaskName: String
    get() = getCompileTaskName("kotlin")

val SourceSet.kotlin: SourceDirectorySet
    get() = withConvention(KotlinSourceSet::class) { kotlin }

val moduleName = "$group.$name"

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