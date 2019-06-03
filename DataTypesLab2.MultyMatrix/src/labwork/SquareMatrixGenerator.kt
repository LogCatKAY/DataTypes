package labwork

import kotlin.random.Random

fun generateMatrix(size: Int)
        : Array<Array<Int>> {
    var matrix : Array<Array<Int>> = Array(0, { Array(0, {0}) })
    if (size > 0) {
        matrix = Array(size, { Array(size, {0}) })

        for (i in 0 until matrix.size) {
            for (j in 0 until matrix[0].size) {
                matrix[i][j] = Random.nextInt(10, 99)
            }
        }
    }
    return matrix
}