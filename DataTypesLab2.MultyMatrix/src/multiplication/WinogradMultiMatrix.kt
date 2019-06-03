package multiplication

fun winogradMultiplication(A: Array<Array<Int>>, B: Array<Array<Int>>)
        : Array<Array<Int>>? {

//    remove for tests and speed
//    if (B.size != A[0].size) {
//        print("Wrong sizes of matrics")
//        return null
//    }

    val M = A.size
    val N = B.size
    val Q = B[0].size

    val answer : Array<Array<Int>> = Array(M, {Array(Q, {0})})

    val d : Int = N / 2
    val MulH = Array(M, {0})
    val MulV = Array(Q, {0})

    for (i in 0 until M) {
        for (j in 0 until d) {
            MulH[i] += A[i][2 * j] * A[i][2 * j + 1]
        }
    }

    for (i in 0 until Q) {
        for (j in 0 until d) {
            MulV[i] += B[2 * j][i] * B[2 * j + 1][i]
        }
    }

    for (i in 0 until M) {
        for (j in 0 until Q) {
            answer[i][j] += - MulH[i] - MulV[j]
            for (k in 0 until d) {
                answer[i][j] += ((A[i][2 * k] + B[2 * k + 1][j]) * (A[i][2 * k + 1] + B[2 * k][j]))
            }
        }
    }

    if ((N % 2) != 0) {
        for (i in 0 until M) {
            for (j in 0 until Q) {
                answer[i][j] += A[i][N - 1] * B[N - 1][j]
            }
        }
    }

    return answer
}