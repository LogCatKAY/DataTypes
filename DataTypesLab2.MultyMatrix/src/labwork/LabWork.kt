package labwork

import multiplication.classicMultiplication
import multiplication.improvedWinogradMult
import multiplication.winogradMultiplication
import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.system.measureNanoTime

class LabWork {

    private lateinit var matrixA : Array<Array<Int>>
    private lateinit var matrixB : Array<Array<Int>>

    companion object {
        const val TIMES: Int = 10
        val RESULT_FILE: File = File("result_10.txt")
    }

    init {
        if (!RESULT_FILE.exists()) {
            RESULT_FILE.createNewFile()
        }
    }

    fun startLabWork() {

        val strFormat = "%16s | %16s | %16s | %16s\n"
        RESULT_FILE.writeText(strFormat.format("Size", "Classic", "Winograd","Imprv Wino"))

        for (size in 100..1000 step 100) {

            println("Multiplication of matrix $size X $size...")

            matrixA = generateMatrix(size)
            matrixB = generateMatrix(size)


            var bigT1: BigDecimal = BigDecimal(0)
            var bigT2: BigDecimal = BigDecimal(0)
            var bigT3: BigDecimal = BigDecimal(0)

            for (time in 1..TIMES) {
                var t1: Long = 0
                var t2: Long = 0
                var t3: Long = 0

                t1 = measureNanoTime {
                    classicMultiplication(matrixA, matrixB)
                }

                t2 = measureNanoTime {
                    winogradMultiplication(matrixA, matrixB)
                }

                t3 = measureNanoTime {
                    improvedWinogradMult(matrixA, matrixB)
                }

                bigT1 = bigT1.add(BigDecimal(t1))
                bigT2 = bigT2.add(BigDecimal(t2))
                bigT3 = bigT3.add(BigDecimal(t3))
            }

            //convert to microseconds
            bigT1 = bigT1.divide(BigDecimal(1000), 3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES), 3, RoundingMode.HALF_UP)
            bigT2 = bigT2.divide(BigDecimal(1000), 3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES), 3, RoundingMode.HALF_UP)
            bigT3 = bigT3.divide(BigDecimal(1000),3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES),3, RoundingMode.HALF_UP)

            RESULT_FILE.appendText(strFormat.format("$size x $size", bigT1, bigT2, bigT3))
        }


        for (size in 101..1001 step 100) {

            println("Multiplication of matrix $size X $size...")

            matrixA = generateMatrix(size)
            matrixB = generateMatrix(size)


            var bigT1: BigDecimal = BigDecimal(0)
            var bigT2: BigDecimal = BigDecimal(0)
            var bigT3: BigDecimal = BigDecimal(0)

            for (time in 1..TIMES) {
                var t1: Long = 0
                var t2: Long = 0
                var t3: Long = 0

                t1 = measureNanoTime {
                    classicMultiplication(matrixA, matrixB)
                }

                t2 = measureNanoTime {
                    winogradMultiplication(matrixA, matrixB)
                }

                t3 = measureNanoTime {
                    improvedWinogradMult(matrixA, matrixB)
                }

                bigT1 = bigT1.add(BigDecimal(t1))
                bigT2 = bigT2.add(BigDecimal(t2))
                bigT3 = bigT3.add(BigDecimal(t3))
            }

            //convert to microseconds
            bigT1 = bigT1.divide(BigDecimal(1000), 3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES), 3, RoundingMode.HALF_UP)
            bigT2 = bigT2.divide(BigDecimal(1000), 3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES), 3, RoundingMode.HALF_UP)
            bigT3 = bigT3.divide(BigDecimal(1000),3, RoundingMode.HALF_UP).divide(BigDecimal(TIMES),3, RoundingMode.HALF_UP)

            RESULT_FILE.appendText(strFormat.format("$size x $size", bigT1, bigT2, bigT3))
        }

        println("<<<End>>>")

    }





}