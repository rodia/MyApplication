package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayCalculateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_calculate)

        // Get the Intent that started this activity and extract the string
        val imc = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.resultText).apply {
            text = imc
        }

        val description = getDescription(imc)

        findViewById<TextView>(R.id.IMC).apply {
            text = description
        }
    }

    private fun getDescription(message: String): String {
        val imc = message.toFloatOrNull()
        var result = ""
        if (imc != null && imc < 18.50) {
            result = "Bajo peso"
        } else if (imc != null && imc <= 24.99)  {
            result = "Normal"
        } else if (imc != null && imc <= 29.99) {
            result = "Sobrepeso"
        } else if (imc != null && imc >= 30) {
            result = "Obesidad"
        }

        return result
    }
}
