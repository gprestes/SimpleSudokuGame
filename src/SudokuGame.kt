import java.io.File

/**
 * The Sudoku logic.
 */
class SudokuGame {

    // ## STEP_8 ##
    // Create a test to check the validation rules added in "isUserInputCorrect" function.

    // This property holds a 2D array of integers with the Sudoku game solution.
    val sudokuBoard = readSudokuBoard()

    // This property holds a 2D array of booleans. It is used to show or hide a value from our Sudoku board.
    val visibleElements = initVisibleElements()

    private fun readSudokuBoard(): Array<IntArray> {
        val sudokuFile = File("./src/sudoku_1")

        val sudokuArray = Array(9) { IntArray(9) }

        sudokuFile.readLines().forEachIndexed { index, line ->
            sudokuArray[index] = line.split(" ").map { it.toInt() }.toIntArray()
        }

        return sudokuArray
    }

    private fun initVisibleElements(): Array<BooleanArray> {

        return Array(9) { indexRow ->
            BooleanArray(9) { indexCol ->
                sudokuBoard[indexRow][indexCol] != 0
            }
        }
    }

    // The user input is correct if the number entered was not used before on row / column / 3 x 3 area.
    fun isUserInputCorrect(userInput: Int, row: Int, col: Int): Boolean {
        val startRow = row / 3 * 3
        val startColumn = col / 3 * 3
        (startRow until startRow + 3).forEach { i ->
            (startColumn until startColumn + 3)
                    .filter { j -> sudokuBoard[i][j] == userInput }
                    .forEach { return false }
        }
        return true
    }

    fun isSolved(): Boolean {
        visibleElements.forEach { array ->
            array.forEach { element ->
                if (!element) {
                    return false
                }
            }
        }
        return true
    }
}