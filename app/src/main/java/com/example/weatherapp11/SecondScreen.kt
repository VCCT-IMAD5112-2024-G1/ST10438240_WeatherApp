package com.example.weatherapp11

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondScreen : AppCompatActivity() {

    //declaring variables
    private lateinit var provideTemp: EditText
    private lateinit var averageTemp: TextView
    private lateinit var temperature: Array<Int?>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)

        // intitializing UI
        provideTemp = findViewById(R.id.provideTemp)
        averageTemp =findViewById(R.id.averageTemp)
        val clearButton:Button = findViewById(R.id.clearButton)
        val secondExitButton:Button = findViewById(R.id.secondExitButton)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val nextButton:Button = findViewById(R.id.nextButton)

        //initializing arrays
        temperature = arrayOfNulls(7)

        calculateButton.setOnClickListener {
            val calculateAverageTemp = Unit
            calculateAverageTemp
        }

        //setting onclicklistner on the clear button
        clearButton.setOnClickListener {
            provideTemp.text.clear()
            averageTemp.text ="Average Temperature"
        }

        //setting onclicklistener to on the next button
        nextButton.setOnClickListener {
            val intent = Intent(this, ThirdScreen::class.java)
            intent.putExtra("temperature", temperature)
            startActivity(intent)
        }

        //onclick listener to exit
        secondExitButton.setOnClickListener {
            finish()
        }

        fun calculateAverageTemp() {
            val input = provideTemp.text.toString()
            val temperatureStrings = input.split(",").map { it.trim() }

            if (temperatureStrings.size != 7) {
                averageTemp.text = "Please input 7 temperatures."
                return
            }

            var total = 0
            try {
                for (i in temperatureStrings.indices) {
                    temperature[i] = temperatureStrings[i].toInt()
                    total += temperature[i]!!
                }
                //calculates average
                val average = total / 7.0
                averageTemp.text = "Average Temperature: %.2f".format(average)
            }catch (e: NumberFormatException){
                averageTemp.text = "Input valid numbers with commas."
            }
            }
        }
    }