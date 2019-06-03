package datatypes.android.datatypeslab1

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun printMatrixTest() {
        val levenshtein = Levenshtein("постой", "стол")
        levenshtein.printMatrix()
        println()
        levenshtein.calculate()
        levenshtein.printMatrix()
    }
}
