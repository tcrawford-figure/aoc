package days

/**
 * https://adventofcode.com/2021/day/1
 */
class Day1 : Day(1) {

    override fun partOne() = inputList
        .map { it.toInt() }
        .zipWithNext { a, b -> b - a }
        .count { it > 0 }

    override fun partTwo(): Int = inputList
        .asSequence()
        .map { it.toInt() }
        .windowed(3)
        .map { it.sum() }
        .zipWithNext { a, b -> b - a }
        .count { it > 0 }

}
