package multiplication

fun classicMultiplication(A: Array<Array<Int>>, B: Array<Array<Int>>)
        : Array<Array<Int>>? {

//    remove for tests and speed
//    if (B.size != A[0].size) {
//        print("Wrong sizes of matrices")
//        return null
//    }

    val M = A.size
    val Q = A[0].size
    val N = B[0].size

    val answer : Array<Array<Int>> = Array(M, {Array(N, {0})})

    for (i in 0 until M) {
        for (j in 0 until Q) {
            for (k in 0 until N) {
                answer[i][k] += A[i][j] * B[j][k]
            }
        }
    }

    return answer
}