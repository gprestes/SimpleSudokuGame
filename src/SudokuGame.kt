import java.io.File

/**
 * The Sudoku logic.
 */
class SudokuGame {

    // This property holds a 2D array of integers with the initial Sudoku board.
    val sudokuBoard = readSudokuBoard()

    // This property holds a 2D array of booleans. It is used to show or hide a value from our Sudoku board.
    val visibleElements = initVisibleElements()

    private fun randomName(): String {
        val randomNumber = (1..10).random()
        println("res/sudoku_$randomNumber")
        return "res/sudoku_$randomNumber"
    }

    // ## STEP_5 ## We need to make some more changes to the body of this function as we're planning to package the app
    // in a jar. When doing this the files cannot be accessed in the same way. They can only be retrieved by using input streams.
    private fun readSudokuBoard(): Array<IntArray> {
        val sudokuFile = File("./src/${randomName()}")

        val sudokuArray = Array(9) { IntArray(9) }
        sudokuFile.readLines().forEachIndexed { index, line ->
            sudokuArray[index] = line.split(" ").map { it.toInt() }.toIntArray()
        }

        return sudokuArray
    }

    private fun initVisibleElements(): Array<BooleanArray> {
        return Array(9) { index ->
            BooleanArray(9) { elementIndex -> sudokuBoard[index][elementIndex] != 0 }
        }
    }

    fun isUserInputCorrect(userInput: Int, row: Int, col: Int): Boolean {
        // check number is between 1 and 9
        if (userInput < 0 || userInput > 9) {
            return false
        }

        // check number is not used yet in sudoku board row
        if (sudokuBoard[row].contains(userInput)) {
            return false
        }

        // check number is not used yet in sudoku board column
        (0 until 9)
                .filter { sudokuBoard[it][col] == userInput }
                .forEach { return false }

        // check number is not used yet in sudoku board 3x3 area
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