fun main() {
    fun part1(input: List<String>): Int {
        val word = "XMAS"

        fun isWordInDir(
            x: Int,
            y: Int,
            rowD: Int,
            colD: Int,
        ): Boolean {
            for (i in word.indices) {
                val newRow = x + i * rowD
                val newCol = y + i * colD
                if (newRow !in input.indices || newCol !in input[0].indices || input[newRow][newCol] != word[i]) {
                    return false
                }
            }
            return true
        }

        var matches = 0
        for (row in input.indices) {
            for (col in input[0].indices) {
                if (input[row][col] == 'X') {
                    if (isWordInDir(row, col, 0, 1)) matches++
                    if (isWordInDir(row, col, 0, -1)) matches++
                    if (isWordInDir(row, col, 1, 0)) matches++
                    if (isWordInDir(row, col, -1, 0)) matches++
                    if (isWordInDir(row, col, 1, 1)) matches++
                    if (isWordInDir(row, col, 1, -1)) matches++
                    if (isWordInDir(row, col, -1, 1)) matches++
                    if (isWordInDir(row, col, -1, -1)) matches++
                }
            }
        }

        return matches
    }

    fun part2(input: List<String>): Int {
        var matches = 0
        for (row in input.indices) {
            for (col in input[0].indices) {
                if (input[row][col] == 'A') {
                    val firstDiag =
                        listOf(
                            input.getOrNull(row - 1)?.getOrNull(col - 1),
                            input[row][col],
                            input.getOrNull(row + 1)?.getOrNull(col + 1),
                        )
                    val secondDiag =
                        listOf(
                            input.getOrNull(row - 1)?.getOrNull(col + 1),
                            input[row][col],
                            input.getOrNull(row + 1)?.getOrNull(col - 1),
                        )

                    if (firstDiag.joinToString("") in listOf("MAS", "SAM") && secondDiag.joinToString("") in listOf("MAS", "SAM")) {
                        matches++
                    }
                }
            }
        }
        return matches
    }

    val testInput = readInput("Day04_test")
    check(part2(testInput) == 9)

    val input = readInput("Day04")
    part1(input).println()
    part2(input).println()
}
