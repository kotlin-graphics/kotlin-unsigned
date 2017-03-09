//import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

buildscript {
    repositories {
        gradleScriptKotlin()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", "1.1.0"))
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
    compile(kotlinModule("stdlib", "1.1.0"))
    testCompile("com.github.elect86:kotlintest:d8878d6da0944ec6bcbcdad6a1540bba021d768d")
}

repositories {
    maven { setUrl("https://jitpack.io") }
}

//val shadowJar: ShadowJar by tasks
//shadowJar.apply {
//    manifest.attributes.apply {
//        put("Implementation-Title", "Kotlin Unsigned")
//        put("Implementation-Version" "v2.0")
//        put("Main-Class", "com.mkyong.DateUtils")
//    }
//
//    baseName = project.name + "-all"
//}