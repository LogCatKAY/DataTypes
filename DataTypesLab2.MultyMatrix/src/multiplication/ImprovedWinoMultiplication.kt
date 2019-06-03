package multiplication

fun improvedWinogradMult(A: Array<Array<Int>>, B: Array<Array<Int>>)
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
            var buf = - MulH[i] - MulV[j]
            for (k in 1 until N step 2) {
                buf += (A[i][k - 1] + B[k][j]) * (A[i][k] + B[k - 1][j])
            }
            if ((N % 2) != 0) {
                buf += A[i][N - 1] * B[N - 1][j]
            }
            answer[i][j] = buf
        }
    }

    return answer
}