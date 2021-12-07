package util

fun <T> List<List<T>>.transpose(): MutableList<MutableList<T>> {
    val result = (first().indices).map { mutableListOf<T>() }.toMutableList()
    forEach { list -> result.zip(list).forEach { it.first.add(it.second) } }
    return result
}

fun String.toDecimal(): Int {
    return this.toInt(2)
}