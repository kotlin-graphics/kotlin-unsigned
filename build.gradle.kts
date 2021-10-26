plugins {
    fun kx(vararg p: Pair<String, String>) = p.forEach { id("io.github.kotlin-graphics.${it.first}") version it.second }
    kx("base" to "0.0.4",
       "publish" to "0.0.2",
       "utils" to "0.0.2")
}