package becerra.paul.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    // enum class for operations
    enum class Operation {
        ADDITION, SUBTRACTION,MULTIPLICATION,DIVISION, NOTHING,EQUALS
    }

    var op: Operation = Operation.NOTHING
    var number1: Double = 0.0
    lateinit var textViewInput: TextView
    lateinit var textViewOutput: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewInput = findViewById(R.id.textViewInput)
        textViewOutput = findViewById(R.id.textViewOutput)
        val btnClear: Button = findViewById(R.id.btnClear)
        val btnEquals: Button = findViewById(R.id.btnResult)

        btnEquals.setOnClickListener {
            // validate operation
            if (op == Operation.NOTHING || op == Operation.EQUALS) return@setOnClickListener

            val input = textViewInput.text.toString()
            var number2: Double = if (input == "") 0.0 else input.toDouble()

            var response: Double = when (op) {
                Operation.ADDITION -> number1 + number2
                Operation.SUBTRACTION -> number1 - number2
                Operation.MULTIPLICATION -> number1 * number2
                Operation.DIVISION -> if (number2 == 0.0) 0.0 else number1 / number2
                else -> 0.0
            }
            val responseText = if (response == 0.0 && op == Operation.DIVISION)
                                    "can't divide by zero"
                                    else response.toString()
            textViewInput.setText(responseText)
            textViewOutput.setText("")
            op = Operation.EQUALS
        }

        btnClear.setOnClickListener{
            textViewOutput.setText("")
            textViewInput.setText("")
            number1 = 0.0
            op = Operation.NOTHING
        }
    }


    fun addNumberInputListener(view: View){
        // validate input after execute operation
        if (op == Operation.EQUALS) {
            textViewInput.setText("")
            op = Operation.NOTHING
        }

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

    fun setOperationListener(view: View){
        var inputNumber = textViewInput.text.toString()
        if (inputNumber.isNullOrEmpty()) return
        number1 = inputNumber.toDouble()
        textViewInput.setText("")
        when(view.id){
            R.id.btnAdd -> {
                textViewOutput.setText(inputNumber + " +")
                op = Operation.ADDITION
            }
            R.id.btnSub -> {
                textViewOutput.setText(inputNumber + " -")
                op = Operation.SUBTRACTION
            }
            R.id.btnMulti -> {
                textViewOutput.setText(inputNumber + " *")
                op = Operation.MULTIPLICATION
            }
            R.id.btnDivision -> {
                textViewOutput.setText(inputNumber + " ÷")
                op = Operation.DIVISION
            }
        }
    }
}