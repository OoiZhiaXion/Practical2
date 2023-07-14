package com.example.practical2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declare Variable
        val editTextWeight:EditText = findViewById(R.id.editTextWeight)
        val editTextHeight:EditText = findViewById(R.id.editTextHeight)
        val textViewBMI: TextView = findViewById(R.id.textViewBmi)
        val textViewStatus: TextView = findViewById(R.id.textViewStatus)
        val btnCalculate : Button = findViewById(R.id.buttonCalculate)
        val btnReset: Button = findViewById(R.id.buttonReset)
        val img: ImageView = findViewById(R.id.imageView)

        btnCalculate.setOnClickListener {
            if (editTextWeight.text.isEmpty()) {
                editTextWeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution here
            }
            if (editTextHeight.text.isEmpty()) {
                editTextHeight.setError(getString(R.string.error_input))
                return@setOnClickListener //terminate program execution here
            }

            val weight: Float = editTextWeight.text.toString().toFloat()
            val height: Float = editTextHeight.text.toString().toFloat()
            val bmi= weight/(height/100).pow(2)

            if (bmi < 18.5) {
                textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
                textViewStatus.text = String.format("%s %s", getString(R.string.status),getString(R.string.under) )
                img.setImageResource(R.drawable.under)
            } else if (bmi < 24.9 && bmi > 18.5) {
                textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
                textViewStatus.text = String.format("%s %s", R.string.status, getString(R.string.normal))
                img.setImageResource(R.drawable.normal)
            } else{
            textViewBMI.text = String.format("%s %.2f", getString(R.string.bmi), bmi)
            textViewStatus.text = String.format("%s %s", getString(R.string.status),getString(R.string.over) )
            img.setImageResource(R.drawable.over)
        }

        }
        btnReset.setOnClickListener{
            editTextHeight.text.clear()
            editTextWeight.text.clear()
            textViewBMI.text = ""
            textViewStatus.text = ""
            img.setImageResource(R.drawable.empty)
        }
    }
}