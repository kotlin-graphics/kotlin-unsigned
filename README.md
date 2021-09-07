# kotlin-unsigned

[![Build Status](https://github.com/kotlin-graphics/kotlin-unsigned/workflows/build/badge.svg)](https://github.com/kotlin-graphics/kotlin-unsigned/actions?workflow=build)
[![license](https://img.shields.io/badge/License-MIT-orange.svg)](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/LICENSE) 
[![Release](https://jitpack.io/v/kotlin-graphics/kotlin-unsigned.svg)](https://jitpack.io/#kotlin-graphics/kotlin-unsigned) 
![Size](https://github-size-badge.herokuapp.com/kotlin-graphics/kotlin-unsigned.svg)
[![Github All Releases](https://img.shields.io/github/downloads/kotlin-graphics/kotlin-unsigned/total.svg)]()

[comment]: <> ([![Contributor Covenant]&#40;https://img.shields.io/badge/Contributor%20Covenant-v2.0%20adopted-ff69b4.svg&#41;]&#40;code_of_conduct.md&#41; )

[comment]: <> ([![Netlify Status]&#40;https://api.netlify.com/api/v1/badges/c75db044-f985-47a3-84a1-73ad33401596/deploy-status&#41;]&#40;https://app.netlify.com/sites/unsigned/deploys&#41;)

[<img src="https://unsigned.netlify.app/images/docs_logo.svg">](https://unsigned.netlify.app)

Unsigned operators and boxed types (`Ubyte`, `Uint`, `Ulong` and `Ushort`) for unsigned support.

To have a quick idea what this library offers, take a look at the [tests](https://github.com/kotlin-graphics/kotlin-unsigned/blob/master/src/test/kotlin/unsigned/test.kt)

### Differences with kotlin stdlib: 

- this project uses classes instead inline classes. To address this in critical scenarios where allocations may have a sensitive impact, primitive variable holding the utype value is a `var`, so you can re-use the same istance over and over again
- utypes extend `Number` abstract class
- automatic conversions
- it is possible to string format by calling the corresponding `format()` method, eg: `ubyte.format("%08x")`
- all the utypes implement all the function, including `shl` and `shr` for `Ubyte` and `Ushort`
- if you add an `Ushort` to another `Ushort` you get an `Ushort` (and not an `Uint`)

### Install:

First you need to [add mary](https://github.com/kotlin-graphics/mary#packages) to your repository, then:

```kotlin
dependencies {
    implementation("kotlin.graphics:unsigned:3.3.1")
}
```



You can find all the instructions by [mary](https://github.com/kotlin-graphics/mary)

### Contributions:

Don't hesitate to contribute to the project by submitting [issues](https://github.com/kotlin-graphics/kotlin-unsigned/issues) or [pull requests](https://github.com/kotlin-graphics/kotlin-unsigned/pulls) for bugs and features. Any feedback is welcome at [elect86@gmail.com](mailto://elect86@gmail.com).


### Credits:

- inspired by [jOOU](https://github.com/jOOQ/jOOU)


 <a href="https://www.netlify.com">
    <img src="https://www.netlify.com/img/global/badges/netlify-color-bg.svg" alt="Deploys by Netlify" />
 </a>
