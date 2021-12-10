package days

import kotlin.math.absoluteValue

/**
 * https://adventofcode.com/2021/day/7
 */
class Day7 : Day(7) {

    private val crabSubmarines: Map<Int, Int> = inputString.split(",").map { it.toInt() }.groupingBy { it }.eachCount()

    override fun partOne(): Int = solve { it }

    override fun partTwo(): Int = solve { summation(it) }

    private fun solve(fuelCost: (Int) -> Int): Int =
        crabSubmarines.keys.asRange().minOf { target ->
            crabSubmarines
                .map { (crab, crabCount) -> fuelCost((target - crab).absoluteValue) * crabCount }
                .sum()
        }

    private fun Set<Int>.asRange(): IntRange =
        this.minOf { it }..this.maxOf { it }

    private fun summation(distance: Int) = (distance * (distance + 1)) / 2

}