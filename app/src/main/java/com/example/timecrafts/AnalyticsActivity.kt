package com.example.timecrafts

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AnalyticsActivity : AppCompatActivity() {

    private lateinit var textViewProjects: TextView
    private lateinit var textViewHours: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_analytics)

        textViewProjects = findViewById(R.id.textViewProjects)
        textViewHours = findViewById(R.id.textViewHours)

        displayAnalytics()
    }

    private fun displayAnalytics() {
        val projects = mapOf(
            "Project A" to "Completed",
            "Project B" to "In Progress",
            "Project C" to "To Be Completed"
        )

        val hoursSpent = mapOf(
            "Project A" to 40,
            "Project B" to 20,
            "Project C" to 0
        )

        val projectsText = projects.entries.joinToString("\n") { "${it.key}: ${it.value}" }
        val hoursText = hoursSpent.entries.joinToString("\n") { "${it.key}: ${it.value} hours" }

        textViewProjects.text = "Projects:\n$projectsText"
        textViewHours.text = "Hours Spent:\n$hoursText"
    }
}
