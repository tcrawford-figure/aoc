package days

import kotlin.math.absoluteValue
import kotlin.math.sign

// Taken with advice from: https://todd.ginsberg.com/post/advent-of-code/2021/day5/
class Day5 : Day(5) {

    private data class Point(val x: Int, val y: Int) {
        infix fun sharesAxisWith(that: Point): Boolean = x == that.x || y == that.y

        // Builds list of coordinates along a line from point a to b
        infix fun lineTo(that: Point): List<Point> {
            val dx = that.x - x
            val dy = that.y - y

            val dxSign = dx.sign
            val dySign = dy.sign

            val steps = maxOf(dx.absoluteValue, dy.absoluteValue)
            return (1..steps).scan(this) { last, _ -> Point(last.x + dxSign, last.y + dySign) }
        }
    }

    private val instructions = inputList.map { parseLine(it) }

    override fun partOne(): Int = solve { it.first sharesAxisWith it.second }

    override fun partTwo(): Int = solve { true }

    private fun solve(lineFilter: (Pair<Point, Point>) -> Boolean) =
        instructions
            .filter { lineFilter(it) }
            .flatMap { it.first lineTo it.second } // Creates a flat list of "highlighted"/"selected" coordinates
            .groupingBy { it } // Creates a map of coordinates associated to a count
            .eachCount()
            .count { it.value > 1 }

    private fun parseLine(line: String): Pair<Point, Point> =
        Pair(
            line.substringBefore(" ").split(",").map { it.toInt() }.let { Point(it.first(), it.last()) },
            line.substringAfterLast(" ").split(",").map { it.toInt() }.let { Point(it.first(), it.last()) }
        )

}