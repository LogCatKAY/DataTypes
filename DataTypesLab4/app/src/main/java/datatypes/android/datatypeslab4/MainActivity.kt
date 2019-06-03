package datatypes.android.datatypeslab4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {

    private lateinit var rpNotation: RPNotation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_1.setOnClickListener {
            et_formula.append("1")
        }
        btn_2.setOnClickListener {
            et_formula.append("2")
        }
        btn_3.setOnClickListener {
            et_formula.append("3")
        }
        btn_4.setOnClickListener {
            et_formula.append("4")
        }
        btn_5.setOnClickListener {
            et_formula.append("5")
        }
        btn_6.setOnClickListener {
            et_formula.append("6")
        }
        btn_7.setOnClickListener {
            et_formula.append("7")
        }
        btn_8.setOnClickListener {
            et_formula.append("8")
        }
        btn_9.setOnClickListener {
            et_formula.append("9")
        }
        btn_0.setOnClickListener {
            et_formula.append("0")
        }
        btn_skob_1.setOnClickListener {
            et_formula.append("(")
        }
        btn_skob_2.setOnClickListener {
            et_formula.append(")")
        }
        btn_x.setOnClickListener {
            et_formula.append("x")
        }
        btn_plus.setOnClickListener {
            et_formula.append("+")
        }
        btn_minus.setOnClickListener {
            et_formula.append("-")
        }
        btn_div.setOnClickListener {
            et_formula.append("/")
        }
        btn_mult.setOnClickListener {
            et_formula.append("*")
        }
        btn_pow.setOnClickListener {
            et_formula.append("^")
        }
        btn_delete.setOnClickListener {
            var text = et_formula.text.toString()
            if (text.isNotEmpty()) {
                text = text.substring(0, text.lastIndex)
                et_formula.setText(text)
            }
        }
        btn_result.setOnClickListener {
            if (et_formula.text.isNotBlank()) {
                tv_result.text = ""
                val inputString = et_formula.text.toString()
                if (inputString.contains("x", true)) {
                    if (
                        et_x1.text.isBlank() &&
                        et_x2.text.isBlank() &&
                        et_step_h.text.isBlank()
                    ) {
                        Toast.makeText(
                            this,
                            "В формуле есть x, но диапазон или шаг не заполнены",
                            Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    } else {
                        val h = et_step_h.text.toString().toInt()
                        var x1 = et_x1.text.toString().toInt()
                        val x2 = et_x2.text.toString().toInt()

                        if (x1 > x2) {
                            Toast.makeText(
                                this,
                                "Начальная точка $x1 больше, чем конечная $x2",
                                Toast.LENGTH_LONG).show()
                            return@setOnClickListener
                        }

                        while (x1 < x2) {
                            val input = inputString.replace("""x""".toRegex(), x1.toString())
                            calculate(input)
                            x1 += h
                        }
                        val input = inputString.replace("""x""".toRegex(), x2.toString())
                        calculate(input)
                    }
                } else {
                    // иначе это просто пример
                    calculate(inputString)
                }
            }
        }


    }

    private fun calculate(inputStr: String) {
        rpNotation = RPNotation(inputStr)
        val rpString = rpNotation.convertToRP()
        tv_rp_string.text = rpString.toString()
        val result = try {
            rpNotation.calculateFromRP(rpString)
        } catch (aex: ArithmeticException) {
            val toast = Toast.makeText(
                this,
                aex.localizedMessage,
                Toast.LENGTH_LONG)
            toast.setGravity(Gravity.TOP, 0, 100)
            toast.show()
            0.0
        }
        tv_result.append("${result.toString()}\n")
    }
}
