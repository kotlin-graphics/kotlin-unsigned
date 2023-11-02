package unsigned

import kotlin.test.assertEquals

infix fun <T> T.`==`(other: T) = assertEquals(other, this)