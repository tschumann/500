package util

import org.junit.Assert.assertEquals
import org.junit.Test

class UtilTest {

    @Test
    fun testRandom() {
        val rand = Util.random(1, 1);
        assertEquals(1, rand);
    }

    @Test
    fun testMax() {
        val max = Util.maxIndex(intArrayOf(1, 2, 3, 4));
        assertEquals(3, max);
    }
}
