package days

import util.toDecimal
import util.transpose

class Day3 : Day(3) {

    private val mat2 = inputAsMatrix()
    private val transposedMat2 = mat2.transpose()

    override fun partOne(): Any {
        val gamma = transposedMat2
            .joinToString("") { if (it.average() > 0.5) "1" else "0" }
            .toDecimal()

        val epsilon = transposedMat2
            .joinToString("") { if (it.average() < 0.5) "1" else "0" }
            .toDecimal()

        return gamma * epsilon
    }

    override fun partTwo(): Any {
        return o2() * co2()
    }

    private fun o2(): Int {
        val bitLength = mat2[0].size

        var matrix = mat2
        for (i in 0 until bitLength) {
            if (matrix.size > 1) {
                val mostCommonBit = if (matrix.transpose()[i].average() >= 0.5) 1 else 0
                matrix = matrix.filter { it[i] == mostCommonBit }
            }
        }

        return matrix[0].joinToString("").toDecimal()
    }

    private fun co2(): Int {
        val bitLength = mat2[0].size

        var matrix = mat2
        for (i in 0 until bitLength) {
            if (matrix.size > 1) {
                val leastCommonBit = if (matrix.transpose()[i].average() >= 0.5) 0 else 1
                matrix = matrix.filter { it[i] == leastCommonBit }
            }
        }

        return matrix[0].joinToString("").toDecimal()
    }

    private fun inputAsMatrix(): List<List<Int>> {
        return inputList.map { it.toList().map(Char::digitToInt) }
    }

}