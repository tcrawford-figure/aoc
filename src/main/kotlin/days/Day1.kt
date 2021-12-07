package days

class Day1 : Day(1) {

    override fun partOne(): Any {
        return inputList
            .map { it.toInt() }
            .zipWithNext { a, b -> b - a }
            .count { it > 0 }
    }

    override fun partTwo(): Any {
        return inputList
            .asSequence()
            .map { it.toInt() }
            .windowed(3)
            .map { it.sum() }
            .zipWithNext { a, b -> b - a }
            .count { it > 0 }
    }
}
