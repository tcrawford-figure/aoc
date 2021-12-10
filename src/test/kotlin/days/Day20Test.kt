package days

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.Is.`is`
import org.junit.jupiter.api.Test

class Day20Test {

    private val day = Day20()

    @Test
    fun testPartOne() {
        assertThat(day.partOne(), `is`(-1))
    }

    @Test
    fun testPartTwo() {
        assertThat(day.partTwo(), `is`(-1))
    }

}
