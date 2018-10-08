package ie.moses.cantor

import org.junit.Assert.assertEquals
import org.junit.Test

class CantorFunctionsTest {

    @Test
    fun testPairingDepairingIsValidForAllAllowedIntegers() {
        for (a in 0..Cantor.MAX_INTEGER) {
            for (b in 0..Cantor.MAX_INTEGER) {
                val pairedInteger = Cantor.pair(a, b, false)
                val depairedInteger = Cantor.depair(pairedInteger)
                assertEquals(a, depairedInteger.first)
                assertEquals(b, depairedInteger.second)
            }
        }
    }

}