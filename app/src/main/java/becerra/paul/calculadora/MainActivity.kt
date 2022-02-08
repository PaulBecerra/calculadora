package becerra.paul.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun addNumberInputListener(view: View){
        val textViewInput: TextView = findViewById(R.id.textViewInput)
        var numberInput: String = textViewInput.text.toString()

        when(view.id){
            R.id.btn0 -> textViewInput.setText(numberInput + "0")
            R.id.btn1 -> textViewInput.setText(numberInput + "1")
            R.id.btn2 -> textViewInput.setText(numberInput + "2")
            R.id.btn3 -> textViewInput.setText(numberInput + "3")
            R.id.btn4 -> textViewInput.setText(numberInput + "4")
            R.id.btn5 -> textViewInput.setText(numberInput + "5")
            R.id.btn6 -> textViewInput.setText(numberInput + "6")
            R.id.btn7 -> textViewInput.setText(numberInput + "7")
            R.id.btn8 -> textViewInput.setText(numberInput + "8")
            R.id.btn9 -> textViewInput.setText(numberInput + "9")
            R.id.btnDot -> {
                // validate one dot in input
                if ("." in numberInput) return
                textViewInput.setText(numberInput + ".")
            }

        }
    }
}