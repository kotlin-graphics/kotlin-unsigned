//import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {

    repositories {
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0-rc-91"))
//        classpath("com.github.jengelman.gradle.plugins:shadow:1.2.3")
    }
}

apply {
    plugin("kotlin")
    plugin("maven")
//    plugin("com.github.johnrengelman.shadow")
}

repositories {
    gradleScriptKotlin()
    mavenCentral()
}

dependencies {
    compile(kotlinModule("stdlib", "1.1.0-rc-91"))
    testCompile("io.kotlintest:kotlintest:1.3.6")
}

//val shadowJar: ShadowJar by tasks
//shadowJar.apply {
//    manifest.attributes.apply {
//        put("Implementation-Title", "Gradle Jar File Example")
//        put("Implementation-Version" version)
//        put("Main-Class", "com.mkyong.DateUtils")
//    }
//
//    baseName = project.name + "-all"
//}