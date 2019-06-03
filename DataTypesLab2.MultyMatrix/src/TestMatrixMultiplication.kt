import labwork.generateMatrix
import multiplication.classicMultiplication
import multiplication.improvedWinogradMult
import multiplication.winogradMultiplication
import kotlin.system.measureNanoTime

/**
 * For debug and testing.
 * */
class TestMatrixMultiplication {
    private val A = arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(2, 3, 4, 5, 6),
        arrayOf(3, 4, 5, 6, 7)
    )

    private val B = arrayOf(
        arrayOf(1, 2, 3, 4, 5),
        arrayOf(2, 3, 4, 5, 6),
        arrayOf(3, 4, 5, 6, 7),
        arrayOf(4, 5, 6, 7, 8),
        arrayOf(4, 5, 6, 7, 8)
    )

    private fun printMatrix(matrix: Array<Array<Int>>?, message: String = "") {
        println(message)
        for (i in 0 until matrix!!.size) {
            for (j in 0 until matrix[0].size) {
                if (j == 0) print("{\t")
                print("${matrix[i][j]}\t")
                if (j == matrix[0].size - 1){ print("}"); println() }
            }
        }
        println()
    }

    fun runTest() {

        val t1 = measureNanoTime { classicMultiplication(A, B) }
        val t2 = measureNanoTime { winogradMultiplication(A, B) }
        val t3 = measureNanoTime { improvedWinogradMult(A, B) }
        val resultClassic = classicMultiplication(A, B)
        val resultWinograd = winogradMultiplication(A, B)
        val resultImprovedWinograd = improvedWinogradMult(A, B)
        printMatrix(resultClassic, "Result of Classic Multiplication")
        printMatrix(resultWinograd, "Result of Winograd Multiplication")
        printMatrix(resultImprovedWinograd,"Result of Improved Winograd Multiplication")

        println("$t1\t$t2\t$t3")
    }
}