import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val lists = input.map { it.split(" ") }
        var failures = 0

        for (list in lists) {
            for (i in list.indices) {
                val value = list[i].toInt()
                val next = list.getOrNull(i + 1)?.toInt()
                val previous = list.getOrNull(i - 1)?.toInt()

                if (previous != null && next != null) {
                    if ((previous > value && next > value) || (previous < value && next < value)) {
                        failures++
                        break
                    }
                }

                if (next != null && (abs(value - next) > 3 || abs(value - next) == 0)) {
                    failures++
                    break
                }
            }
        }

        return input.size - failures
    }

    fun part2(input: List<String>): Int {
        val lists = input.map { it.split(" ") }
        var successes = 0

        for (list in lists) {
            outer@ for (i in list.indices) {
                val modifiedList = list.toMutableList().apply { removeAt(i) }

                for (j in modifiedList.indices) {
                    val value = modifiedList[j].toInt()
                    val next = modifiedList.getOrNull(j + 1)?.toInt()
                    val previous = modifiedList.getOrNull(j - 1)?.toInt()

                    if (previous != null && next != null) {
                        if ((previous > value && next > value) || (previous < value && next < value)) {
                            continue@outer
                        }
                    }

                    if (next != null && (abs(value - next) > 3 || abs(value - next) == 0)) {
                        continue@outer
                    }
                }
                successes++
                break@outer
            }
        }

        return successes
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
