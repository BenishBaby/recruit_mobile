package com.asb.mobiletest

import com.asb.mobiletest.util.GSTUtil
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class GSTUtilTest {
    @Test
    fun calculateGSTTest() {
        var result = GSTUtil.calculateGST(0.0)
        assertEquals(0.0, result, 0.0)
        result = GSTUtil.calculateGST(100.0)
        assertEquals(15.0, result, 0.0)
        result = GSTUtil.calculateGST(-100.0)
        assertEquals(0.0, result, 0.0)
    }
}