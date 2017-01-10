group = "groupId"
version = "1.0-SNAPSHOT"

buildscript {

    repositories {
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
        mavenCentral()
        gradleScriptKotlin()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

plugins {
    application
}

apply {
    plugin("kotlin")
}

//configure<ApplicationPluginConvention> {
//    mainClassName = "samples.HelloWorldKt"
//}

repositories {
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
    gradleScriptKotlin()
}

dependencies {
    compile(kotlinModule("stdlib"))
    testCompile("io.kotlintest:kotlintest:1.3.5")
}