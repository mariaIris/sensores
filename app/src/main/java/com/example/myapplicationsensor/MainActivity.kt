package com.example.myapplicationsensor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonProx.setOnClickListener{
            startActivity(Intent(this,MainProximidadeActivity::class.java))
        }

        buttonAcel.setOnClickListener {
            startActivity(Intent(this,MainAcelerometro::class.java))
        }

        buttonLuz.setOnClickListener {
            startActivity(Intent(this,MainLuminosidade::class.java))
        }

        buttonGiro.setOnClickListener {
            startActivity(Intent(this,MainGiroscopio::class.java))
        }
    }
}
