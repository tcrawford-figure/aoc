package days

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class Day5 : Day(5) {

    private data class Point(val x: Int, val y: Int)

    private data class Line(val p1: Point, val p2: Point) {
        fun pointRange(): List<Point> {
            val points = mutableListOf<Point>()
            val width = abs(p2.x - p1.x)
            val height = abs(p2.y - p1.y)

            val xMin = min(p1.x, p2.x)
            val yMin = min(p1.y, p2.y)

            val xMax = max(p1.x, p2.x)
            val yMax = max(p1.y, p2.y)

            if (width != 0) {
                points.addAll((0..width).map { i -> Point(xMin + i, yMin) })
            } else if (height != 0) {
                points.addAll((0..height).map { i -> Point(xMin, yMin + i) })
            } else {
                for (i in xMin until xMax) {
                    for (j in yMin until yMax) {
                        points.add(Point(i, j))
                    }
                }
            }
            return points
        }
    }

    override fun partOne(): Any {
        var max = 0

        val lines = inputList
            .map { line ->
                // Might be able to be replaced with something like line.replace(" -> ", ",").windowed(2)
                val (xy, x1y1) = line.split(" -> ")
                val (x, y) = xy.split(",").map { it.toInt() }
                val (x1, y1) = x1y1.split(",").map { it.toInt() }

                val subMax = listOf(x, y, x1, y1).maxOrNull()
                if (subMax!! > max) {
                    max = subMax
                }

                Line(Point(x, y), Point(x1, y1))
            }.filter { it.p1.x == it.p2.x || it.p1.y == it.p2.y }

        val matrix = matrixOf(max)
        lines.forEach { line ->
            line.pointRange().forEach { point ->
                matrix[point.y][point.x]++
            }
        }

        return matrix
            .flatten()
            .count { it > 1 }
    }

    override fun partTwo(): Any {
        return -1
    }

    private fun matrixOf(size: Int): MutableList<MutableList<Int>> {
        val matrix = mutableListOf<MutableList<Int>>()
        for (i in 0..size) {
            val row = mutableListOf<Int>()
            for (j in 0..size) {
                row.add(0)
            }
            matrix.add(row)
        }
        return matrix
    }

    fun printMatrix(matrix: List<List<Int>>) {
        for (line in matrix) {
            println(line)
        }
    }

}