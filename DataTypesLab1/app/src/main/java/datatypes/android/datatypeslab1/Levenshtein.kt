package datatypes.android.datatypeslab1

import android.widget.TextView

class Levenshtein(val word1: String, val word2: String) {
    private var matrix: Array<IntArray>? = null

    init {
        initMatrix()
    }

    fun calculate(): Int {

        for (i in 1 until matrix!!.size) {
            for (j in 1 until matrix!![0].size) {
                if (word1[i-1] != word2[j-1]) {
                    matrix!![i][j] = minOf(
                        matrix!![i-1][j]+1,
                        matrix!![i][j-1]+1,
                        matrix!![i-1][j-1]+1
                    )
                } else {
                    matrix!![i][j] = minOf(
                        matrix!![i-1][j]+1,
                        matrix!![i][j-1]+1,
                        matrix!![i-1][j-1]
                    )
                }
            }
        }

        return matrix!![matrix!!.size-1].last()
    }

    fun calculateModified(): Int {

        for (i in 1 until matrix!!.size) {
            for (j in 1 until matrix!![0].size) {

                var temp = 0

                if (i > 1 && j > 1) {
                    if (word1[i-1] != word2[j-1]) {
                        temp = matrix!![i-2][j-2] + 1
                        matrix!![i][j] = minOf(
                            matrix!![i-1][j]+1,
                            matrix!![i][j-1]+1,
                            matrix!![i-1][j-1]+1
                        )
                        if(temp < matrix!![i][j]) {
                            matrix!![i][j] = temp
                        }
                    } else {
                        temp = matrix!![i-2][j-2] + 1
                        matrix!![i][j] = minOf(
                            matrix!![i-1][j]+1,
                            matrix!![i][j-1]+1,
                            matrix!![i-1][j-1]
                        )
                        if(temp < matrix!![i][j]) {
                            matrix!![i][j] = temp
                        }
                    }
                } else {
                    if (word1[i-1] != word2[j-1]) {
                        matrix!![i][j] = minOf(
                            matrix!![i-1][j]+1,
                            matrix!![i][j-1]+1,
                            matrix!![i-1][j-1]+1
                        )
                    } else {
                        matrix!![i][j] = minOf(
                            matrix!![i-1][j]+1,
                            matrix!![i][j-1]+1,
                            matrix!![i-1][j-1]
                        )
                    }
                }
            }
        }

        return matrix!![matrix!!.size-1].last()
    }

    private fun initMatrix() {
        matrix = Array(word1.length + 1) { IntArray(word2.length + 1) }

        //fill first column
        for (i in matrix!!.indices) {
            matrix!![i][0] = i
        }

        //fill first row
        for (i in 0 until matrix!![0].size) {
            matrix!![0][i] = i
        }
    }

    fun printMatrix() {
        for (i in matrix!!.indices) {
            for (j in 0 until matrix!![0].size) {
                print(matrix!![i][j])
                if (j == matrix!![0].size - 1) print("\n")
            }
        }
    }

    fun printMatrix(textView: TextView) {

        textView.append("\t\t$word2\n")
        for (i in 0 until matrix!!.size) {
            for (j in 0 until matrix!![0].size) {
                if (j==0 && i > 0) textView.append(word1[i-1].toString())
                textView.append("\t" + matrix!![i][j].toString())
                if (j == matrix!![0].size - 1) textView.append("\n")
            }
        }
    }
}