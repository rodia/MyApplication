package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

const val EXTRA_MESSAGE = "com.example.myapplication.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun sendCalculate(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.editText2)
        val mass = editText.text.toString().toFloatOrNull()
        val heigh = editText2.text.toString().toFloatOrNull()
        var imc = ""
        if (heigh != null && mass != null) {
            imc = "${mass/(heigh*heigh)}"

        } else {
            imc = "Valores no calculables"
        }

        val intent = Intent(this, DisplayCalculateActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, imc)
        }
        startActivity(intent)
    }
}
