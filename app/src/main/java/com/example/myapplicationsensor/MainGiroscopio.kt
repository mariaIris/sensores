package com.example.myapplicationsensor

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_giroscopio.*

class MainGiroscopio : AppCompatActivity(), SensorEventListener {

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onSensorChanged(event: SensorEvent?) {
        gA.text = "a=${event!!.values[0]}\n"
        gB.text = "b=${event.values[1]}\n"
        gC.text = "c=${event.values[2]}"
    }

    lateinit var manager: SensorManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_giroscopio)

        manager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        manager.registerListener(
            this,
            manager.getDefaultSensor(Sensor.TYPE_GYROSCOPE),
            SensorManager.SENSOR_DELAY_NORMAL
        )

        buttonVoltarGiro.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
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
