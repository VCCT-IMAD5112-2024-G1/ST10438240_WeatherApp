package com.example.weatherapp11

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ThirdScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_third_screen)
    }

    val finalView: TextView = findViewById(R.id.finalView)
    val lastBack: Button = findViewById(R.id.lastBack)

    val temperatures= intent.getSerializableExtra("temperatures") as Array<Int?>
    val days = arrayOf("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday")

        }

