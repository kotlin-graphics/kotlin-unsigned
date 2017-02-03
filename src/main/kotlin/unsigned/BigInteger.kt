/**
 * Created by GBarbieri on 03.02.2017.
 */

package unsigned

import java.math.BigInteger


infix fun BigInteger.ushr(bitCount: Int) = shiftRight(bitCount)