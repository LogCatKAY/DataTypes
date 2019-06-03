package datatypes.android.datatypeslab1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var levenshtein: Levenshtein

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        btn_calculate.setOnClickListener {
            if (et_word1.text.isNullOrBlank() || et_word2.text.isNullOrBlank()) {
                toast("Заполните поля!")
            } else {
                tv_print1.text = ""
                tv_print2.text = ""
                levenshtein = Levenshtein(et_word1.text.toString(), et_word2.text.toString())
                tv_result1.text = levenshtein.calculate().toString()
                levenshtein.printMatrix(tv_print1)

                tv_result2.text = levenshtein.calculateModified().toString()
                levenshtein.printMatrix(tv_print2)
            }
        }

    }
}
