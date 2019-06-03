package datatypes.android.datatypeslab4

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun convertToRP() {
        var rpNotation = RPNotation("25+8*70-6/2")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        print(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        println()
        assertEquals(582.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("25+8*70")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        print(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        println()
        assertEquals(585.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("1248*950/12")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(98800.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("2^10")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(1024.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("(2^10-24)/100")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(10.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("-1+1")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(0.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)

        rpNotation = RPNotation("100-100*(101-1)-(5-2-1)")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(-9902.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)
    }

    @Test
    fun checkOperation(){
        val rpNotation = RPNotation("100-100*(101-1)-(5-2-1)")
        println(rpNotation.inputString)
        print(rpNotation.convertToRP())
        println()
        println(rpNotation.calculateFromRP(rpNotation.convertToRP()))
        assertEquals(-9902.0, rpNotation.calculateFromRP(rpNotation.convertToRP()), 0.001)
    }
}
