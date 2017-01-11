import org.gradle.api.JavaVersion

group = "groupId"
version = "1.0-SNAPSHOT"

buildscript {

    repositories {
        gradleScriptKotlin()
        maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
        mavenCentral()
    }

    dependencies {
        classpath(kotlinModule("gradle-plugin"))
    }
}

apply {
    plugin("kotlin")
}

//configure<ApplicationPluginConvention> {
//    mainClassName = "samples.HelloWorldKt"
//}

//configure<JavaPluginConvention> {
//    sourceCompatibility = JavaVersion.VERSION_1_7
//    targetCompatibility = JavaVersion.VERSION_1_7
//}

repositories {
    gradleScriptKotlin()
    maven { setUrl("http://dl.bintray.com/kotlin/kotlin-eap-1.1") }
}

dependencies {
    compile(kotlinModule("stdlib"))
    testCompile("io.kotlintest:kotlintest:1.3.5")
}