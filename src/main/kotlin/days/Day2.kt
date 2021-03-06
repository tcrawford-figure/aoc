package days

/**
 * https://adventofcode.com/2021/day/2
 */
class Day2 : Day(2) {

    private val directionAndUnits = getDirectionAndUnits()

    override fun partOne(): Any {
        var (horizontal, depth) = Pair(0, 0)

        return directionAndUnits
            .forEach { (direction, units) ->
                when (direction) {
                    "down" -> depth += units
                    "up" -> depth -= units
                    "forward" -> horizontal += units
                }
            }.let { horizontal * depth }
    }

    override fun partTwo(): Any {
        var (horizontal, depth, aim) = listOf(0, 0, 0)

        return directionAndUnits
            .forEach { (direction, units) ->
                when (direction) {
                    "down" -> aim += units
                    "up" -> aim -= units
                    "forward" -> {
                        horizontal += units
                        depth += (aim * units)
                    }
                }
            }.let { horizontal * depth }
    }

    private fun getDirectionAndUnits(): List<Pair<String, Int>> {
        return inputList
            .map { it.split(" ") }
            .map { Pair(it[0], it[1].toInt()) }
    }

}