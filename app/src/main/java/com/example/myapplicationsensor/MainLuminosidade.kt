package com.example.myapplicationsensor

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.hardware.SensorManager.SENSOR_DELAY_NORMAL
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main_luminosidade.*

class MainLuminosidade : AppCompatActivity(), SensorEventListener {

    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_giroscopio)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager



        manager.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), SENSOR_DELAY_NORMAL)

        buttonVoltarLumi.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }


        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
            ("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onSensorChanged(event: SensorEvent?) {
            var valor = event!!.values[0]

            luminosidade.text = ("Luminosidaade" + valor)
        }

        override fun onResume(){
            super.onResume()
            manager!!.registerListener(this, manager.getDefaultSensor(Sensor.TYPE_LIGHT), SENSOR_DELAY_NORMAL)
        }

        override fun onPause() {
            super.onPause()
            manager!!.unregisterListener(this)
        }


}



