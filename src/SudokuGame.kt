/**
 * The Sudoku logic
 */
class SudokuGame {
    //This property holds a 2D array of integers with the Sudoku game solution.
    val solution = createSolution()

    //This property holds a 2D array of booleans. It is used to show or hide a value from our Sudoku board.
    val visibleElements = initVisibleElements()

    private fun createSolution(): Array<IntArray> {
        return arrayOf(
                intArrayOf(3, 5, 9, 6, 1, 8, 4, 2, 7),
                intArrayOf(7, 4, 2, 5, 3, 9, 8, 6, 1),
                intArrayOf(1, 6, 8, 4, 7, 2, 9, 5, 3),
                intArrayOf(4, 2, 3, 8, 9, 5, 7, 1, 6),
                intArrayOf(5, 8, 7, 1, 6, 4, 3, 9, 2),
                intArrayOf(6, 9, 1, 7, 2, 3, 5, 8, 4),
                intArrayOf(2, 7, 5, 9, 4, 6, 1, 3, 8),
                intArrayOf(8, 3, 4, 2, 5, 1, 6, 7, 9),
                intArrayOf(9, 1, 6, 3, 8, 7, 2, 4, 5)
        )
    }

    private fun initVisibleElements(): Array<BooleanArray> {
        return arrayOf(
                booleanArrayOf(false, true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, false),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true),
                booleanArrayOf(true,  true, true, true, true, true, true, true, true)
        )
    }

    fun isUserInputCorrect(userInput: Int, row: Int, column: Int): Boolean {
        return userInput == solution[row][column]
    }

    fun isSolved(): Boolean {
        visibleElements.forEach {
            it.forEach {
                if (!it) {
                    return false
                }
            }
        }
        return true
    }
}