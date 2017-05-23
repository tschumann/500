package util

import org.junit.Test

import org.junit.Assert.*

class UtilTest {

    @Test
    fun testRandom() {
        val rand = Util.random(0, 0);
        assertEquals(0, rand);
    }
}