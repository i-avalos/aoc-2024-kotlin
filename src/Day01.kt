import kotlin.math.abs

fun main() {
    fun parseLists(input: List<String>) =
        input
            .map {
                val (first, second) = it.split("   ").map { n -> n.toInt() }
                first to second
            }.unzip()

    fun part1(
        firstList: List<Int>,
        secondList: List<Int>,
    ): Int = firstList.sorted().zip(secondList.sorted()).fold(0) { acc, (a, b) -> acc + abs(a - b) }

    fun part2(
        firstList: List<Int>,
        secondList: List<Int>,
    ): Int = firstList.fold(0) { acc, a -> acc + a * secondList.count { it == a } }

    val testInput = readInput("Day01_test")
    val (firstListTest, secondListTest) = parseLists(testInput)

    check(part1(firstListTest, secondListTest) == 11)

    val input = readInput("Day01")
    val (firstList, secondList) = parseLists(input)
    part1(firstList, secondList).println()
    part2(firstList, secondList).println()
}
