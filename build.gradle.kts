plugins {
    fun kx(plugin: String) = id("io.github.kotlin-graphics.$plugin") version "latest.release"
    kx("base")
    //    id("kx.dokka") version build
    kx("publish")
    kx("utils")
}