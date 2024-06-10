package com.example.timecrafts

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.appcompat.app.AppCompatActivity

class TimerActivity : AppCompatActivity() {

    private lateinit var chronometer: Chronometer
    private lateinit var buttonStart: Button
    private lateinit var buttonStop: Button
    private lateinit var buttonReset: Button

    private var isTimerRunning = false
    private var elapsedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        chronometer = findViewById(R.id.chronometer)
        buttonStart = findViewById(R.id.buttonStart)
        buttonStop = findViewById(R.id.buttonStop)
        buttonReset = findViewById(R.id.buttonReset)

        buttonStart.setOnClickListener {
            startTimer()
        }

        buttonStop.setOnClickListener {
            stopTimer()
        }

        buttonReset.setOnClickListener {
            resetTimer()
        }
    }

    private fun startTimer() {
        if (!isTimerRunning) {
            chronometer.base = SystemClock.elapsedRealtime() - elapsedTime
            chronometer.start()
            isTimerRunning = true
        }
    }

    private fun stopTimer() {
        if (isTimerRunning) {
            chronometer.stop()
            elapsedTime = SystemClock.elapsedRealtime() - chronometer.base
            isTimerRunning = false
        }
    }

    private fun resetTimer() {
        chronometer.base = SystemClock.elapsedRealtime()
        elapsedTime = 0
        if (isTimerRunning) {
            chronometer.stop()
            isTimerRunning = false
        }
    }
}