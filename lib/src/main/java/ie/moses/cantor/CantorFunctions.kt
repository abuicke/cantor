package ie.moses.cantor

import android.support.annotation.IntRange
import android.support.annotation.VisibleForTesting
import ie.moses.cantor.util.isNaturalNumber

object Cantor {
    const val MAX_INTEGER = 11584

    fun pair(@IntRange(from = 0, to = MAX_INTEGER.toLong()) a: Int,
             @IntRange(from = 0, to = MAX_INTEGER.toLong()) b: Int): Int {
        return pair(a, b, true)
    }

    @VisibleForTesting
    fun pair(@IntRange(from = 0, to = MAX_INTEGER.toLong()) a: Int,
             @IntRange(from = 0, to = MAX_INTEGER.toLong()) b: Int,
             strictModeEnabled: Boolean): Int {
        if (!a.isNaturalNumber()) {
            throw IllegalArgumentException("$a is not a natural number, " +
                    "only values between 0 and $MAX_INTEGER can be used.")
        }

        if (!b.isNaturalNumber()) {
            throw IllegalArgumentException("$b is not a natural number, " +
                    "only values between 0 and $MAX_INTEGER can be used.")
        }

        if (strictModeEnabled && (a > MAX_INTEGER || b > MAX_INTEGER))
            throw IllegalArgumentException("neither value can exceed $MAX_INTEGER")

        return (0.5 * (a + b).toDouble() * (a + b + 1).toDouble() + b).toInt()
    }

    fun depair(z: Int): Pair<Int, Int> {
        val t = Math.floor((Math.sqrt((8 * z + 1).toDouble()) - 1) / 2).toInt()
        val x = t * (t + 3) / 2 - z
        val y = z - t * (t + 1) / 2
        return Pair(x, y)
    }
}