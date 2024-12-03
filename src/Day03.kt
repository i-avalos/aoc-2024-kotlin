fun main() {
    fun part1(input: List<String>): Int {
        val mergedInput = input.joinToString()
        val regex = Regex("""mul\((\d+,\d+)\)""")

        return regex
            .findAll(mergedInput)
            .map { it.groupValues[1].split(",") }
            .sumOf { sublist ->
                sublist.map { it.toInt() }.reduce { acc, a -> acc * a }
            }
    }

    fun part2(input: List<String>): Int {
        val mergedInput = input.joinToString()
        val regex = Regex("""mul\((\d+,\d+)\)""")
        val dontSplitFirst = mergedInput.split("don't()")[0]

        val droppedDonts =
            dontSplitFirst.plus(
                mergedInput
                    .split("don't()")
                    .map { it.split("do()").drop(1) }
                    .joinToString(),
            )

        return regex
            .findAll(droppedDonts)
            .map { it.groupValues[1].split(",") }
            .sumOf { sublist ->
                sublist.map { it.toInt() }.reduce { acc, a -> acc * a }
            }
    }

    val testInput = readInput("Day03_test")
    check(part2(testInput) == 48)

    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
