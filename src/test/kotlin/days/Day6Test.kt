package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test
import java.math.BigInteger

class Day6Test {

    private val day = Day6()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(BigInteger.valueOf(5934)))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(BigInteger.valueOf(26984457539)))
    }

}
