package com.wcc.whatdoilearn.data

import com.wcc.whatdoilearn.R
import com.wcc.whatdoilearn.entities.UnderstandingLevel
import org.junit.Assert.assertEquals
import org.junit.Test

class ConvertersTest {

    @Test
    fun `Given purple500 color id, when converted, should be medium understanding level`() {
        val purpleColor = R.color.purple_500

        val result = Converters().intToLevel(purpleColor)

        assertEquals(UnderstandingLevel.MEDIUM, result)
    }

    @Test
    fun `Given medium understanding level, when converted to color id, then should be as purple_500 color id`() {
        val mediumUnderstandingLevel = UnderstandingLevel.MEDIUM

        val result = Converters().levelToInt(mediumUnderstandingLevel)

        assertEquals(R.color.purple_500, result)
    }
}