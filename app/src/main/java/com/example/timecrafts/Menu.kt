package com.example.timecrafts

import android.content.Intent
import android.os.Bundle
import android.text.format.Time
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.logo)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btTimesheet).setOnClickListener {
            startActivity(Intent(this, TimesheetActivity::class.java))
        }

        findViewById<Button>(R.id.btCalendar).setOnClickListener {
            startActivity(Intent(this, CalendarActivity::class.java))


        }

        findViewById<Button>(R.id.btTimer).setOnClickListener {
            startActivity(Intent(this, TimerActivity::class.java))
        }

        findViewById<Button>(R.id.btEntryList).setOnClickListener {
            startActivity(Intent(this, EntryListActivity::class.java))
        }

        findViewById<Button>(R.id.btAnalytics).setOnClickListener {
            startActivity(Intent(this, AnalyticsActivity::class.java))
        }

        findViewById<Button>(R.id.btGraph).setOnClickListener {
            startActivity(Intent(this, GraphActivity::class.java))
        }
    }
}
