import java.io.File

/**
 * The Sudoku logic.
 */
class SudokuGame {

    // ## STEP_8 ##
    // Create a test to check the validation rules added in "isUserInputCorrect" function.

    // This property holds a 2D array of integers with the Sudoku game solution.
    // ## STEP_5 ##
    // Rename the property below to "sudokuBoard" as now we don't hold here anymore the solution of the game. Make sure you rename it in "GameFrame.kt" also.
    val solution = readSudokuBoard()

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

    // ## STEP_6 ##
    // Update the body of this function so that all numbers in "sudokuBoard" that are not 0 are visible.
    // Debug and check the result is as expected (as the old one). Notice that now we cannot check the game again as we don't know the solution anymore.
    private fun initVisibleElements(): Array<BooleanArray> {
        return arrayOf(
                booleanArrayOf(false, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, false),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true),
                booleanArrayOf(true, true, true, true, true, true, true, true, true)
        )
    }

    // ## STEP_7 ##
    // Update the body of this function to apply validation rules.
    // The user input is correct if the number entered was not used before on row / column / 3 x 3 area.
    fun isUserInputCorrect(userInput: Int, row: Int, col: Int): Boolean {
        return solution[row][col] == userInput
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