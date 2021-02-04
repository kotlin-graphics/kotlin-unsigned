package uns

import java.net.URL

plugins {
    id("org.jetbrains.dokka")
    java
}

tasks {
    val netlifyBadge by registering {
        doLast {
            val index = dokkaHtml.get().outputDirectory.get().resolve("kotlin-unsigned" + File.separatorChar + "index.html")
            val text = index.readText()
            val ofs = text.lastIndexOf("</span>") + 7
            val badge = """                       
              <a href="https://www.netlify.com">
                <img src="https://www.netlify.com/img/global/badges/netlify-color-accent.svg" alt="Deploys by Netlify" style="vertical-align:middle;margin:10px 10px" />
              </a>
            """.trimIndent()
            index.writeText(text.replaceRange(ofs, ofs, badge))
        }
    }

    dokkaHtml {
//        val a = File("$rootDir/src/main/kotlin")
//        println(a)
        dokkaSourceSets.configureEach {
            sourceLink {
                localDirectory.set(File("$rootDir/src/main/kotlin"))
                remoteUrl.set(URL("https://github.com/kotlin-graphics/kotlin-unsigned/tree/master/src/main/kotlin"))
                remoteLineSuffix.set("#L")
            }
        }
//        finalizedBy(netlifyBadge)
    }
}

val dokkaJavadocJar by tasks.register<Jar>("dokkaJavadocJar") {
    dependsOn(tasks.dokkaJavadoc)
    from(tasks.dokkaJavadoc.get().outputDirectory.get())
    archiveClassifier.set("javadoc")
}

val dokkaHtmlJar by tasks.register<Jar>("dokkaHtmlJar") {
    dependsOn(tasks.dokkaHtml)
    from(tasks.dokkaHtml.get().outputDirectory.get())
    archiveClassifier.set("html-doc")
}

artifacts {
    archives(dokkaJavadocJar)
    archives(dokkaHtmlJar)
}