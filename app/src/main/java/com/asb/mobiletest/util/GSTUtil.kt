package com.asb.mobiletest.util

object GSTUtil {
    fun calculateGST(gstAmount: Double): Double {
        return if(gstAmount > 0) (gstAmount * .15) else 0.0
    }
}