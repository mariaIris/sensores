package com.example.myapplicationsensor

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_proximidade.*


abstract class MainProximidadeActivity : AppCompatActivity(), SensorEventListener {

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        var valor = event!!.values[0]

        proximidade.text = ("proximidade"+valor)
    }

    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_proximidade)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        buttonVoltarProx.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onResume(){
        super.onResume()
        manager!!.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT),
            SensorManager.SENSOR_DELAY_NORMAL
        )
    }

    override fun onPause() {
        super.onPause()
        manager!!.unregisterListener(this)
    }
}
