package days

import java.math.BigInteger

/**
 * https://adventofcode.com/2021/day/6
 */
class Day6 : Day(6) {

    override fun partOne(): BigInteger = simulateFish(80)

    override fun partTwo(): BigInteger = simulateFish(256)

    private fun simulateFish(days: Int): BigInteger {
        val fishPerDay = parseInput()
        repeat(days) {
            fishPerDay.rotateLeftInPlace()
            fishPerDay[6] += fishPerDay[8]
        }
        return fishPerDay.sumOf { it }
    }

    private fun <T> MutableList<T>.rotateLeftInPlace() {
        val leftMost = first()
        (1 until size).map { i -> this[i - 1] = this[i] }
        this[this.lastIndex] = leftMost
    }

    private fun parseInput(): MutableList<BigInteger> =
        MutableList<BigInteger>(9) { BigInteger.ZERO }.apply {
            inputString.split(",").map { it.toInt() }.forEach { this[it] += BigInteger.ONE }
        }

}