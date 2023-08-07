package com.example.tiptime


import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTest {

    @Test
    fun caculateTip_20PercentNoRoundUp(){
        val amount = 10.0
        val tipPercent = 20.0

        var expectedTip = NumberFormat.getCurrencyInstance().format(2)
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, false)
        assertEquals(expectedTip, actualTip)
    }
}