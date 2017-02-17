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
    testCompile("com.github.elect86:kotlintest:c4b7b397a0d182d1adaf61f71a9423c228dc0106")
}

allprojects {
    repositories {
        maven { setUrl("https://jitpack.io") }
    }
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