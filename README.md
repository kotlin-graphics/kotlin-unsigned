# kotlin-unsigned

[![Build Status](https://travis-ci.org/kotlin-graphics/kotlin-unsigned.svg?branch=master)](https://travis-ci.org/kotlin-graphics/kotlin-unsigned) [![license](https://img.shields.io/github/license/mashape/apistatus.svg)](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/LICENSE) ![](https://reposs.herokuapp.com/?path=kotlin-graphics/kotlin-unsigned) [![Release](https://jitpack.io/v/kotlin-graphics/kotlin-unsigned.svg)](https://jitpack.io/#kotlin-graphics/kotlin-unsigned)

Unsigned operators and boxed types (`Ubyte`, `Uint`, `Ulong` and `Ushort`) for unsigned support.

To have a quick idea what this library offers, take a look at the [tests](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/src/test/kotlin/unsigned/test.kt)

### How to get it:

[Gradle](https://jitpack.io/#kotlin-graphics/kotlin-unsigned/v2.1)

- Add it in your root build.gradle at the end of repositories:

      allprojects {
          repositories {
              ...
              maven { url 'https://jitpack.io' } // should be the last entry
          }
      }

- Add the dependency

      dependencies {
          compile 'com.github.kotlin-graphics:kotlin-unsigned:v2.1'
      }

[Maven, Sbt, Leiningen](https://jitpack.io/#kotlin-graphics/kotlin-unsigned/v2.1)


### Hightlights:

Android compatible, sources compiled with java 1.7.

All unsigned methods available for `int`s and `long`s on java 1.8 have been reported here. 

These are offered directly on the corresponding [`Int`](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/src/main/kotlin/unsigned/java_1_7/int.kt) and [`Long`](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/src/main/kotlin/unsigned/java_1_7/long.kt) Kotlin primitives (with `infix` too)

### Contributions:

Don't hesitate to contribute to the project by submitting [issues](https://github.com/kotlin-graphics/kotlin-unsigned/issues) or [pull requests](https://github.com/kotlin-graphics/kotlin-unsigned/pulls) for bugs and features. Any feedback is welcome at [elect86@gmail.com](mailto://elect86@gmail.com).


### Credits:

- inspired by [jOOU](https://github.com/jOOQ/jOOU)
