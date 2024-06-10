package com.example.timecrafts

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.Calendar
import java.util.Date

class GraphActivity : AppCompatActivity() {

    private lateinit var graphView: GraphView
    private lateinit var buttonSelectDate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_graph)

        graphView = findViewById(R.id.graphView)
        buttonSelectDate = findViewById(R.id.buttonSelectDate)

        buttonSelectDate.setOnClickListener {
            showDateRangePicker()
        }

        setupGraph()
    }

    private fun showDateRangePicker() {
        val calendar = Calendar.getInstance()
        val startDatePicker = DatePickerDialog(
            this,
            { _, startYear: Int, startMonth: Int, startDay: Int ->
                val startDate = Calendar.getInstance().apply {
                    set(startYear, startMonth, startDay)
                }

                val endDatePicker = DatePickerDialog(
                    this,
                    { _, endYear: Int, endMonth: Int, endDay: Int ->
                        val endDate = Calendar.getInstance().apply {
                            set(endYear, endMonth, endDay)
                        }
                        updateGraph(startDate.time, endDate.time)
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                )
                endDatePicker.show()
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        startDatePicker.show()
    }

    private fun setupGraph() {
        val data = listOf(4f, 8f, 6f, 5f, 9f, 7f)
        val minGoal = 3f
        val maxGoal = 10f
        graphView.setData(data, minGoal, maxGoal)
    }

    private fun updateGraph(startDate: Date, endDate: Date) {
        // Fetch data based on the selected date range
        val data = fetchDataForDateRange(startDate, endDate)

        // Assume minGoal and maxGoal can be fetched or calculated similarly
        val minGoal = 3f
        val maxGoal = 10f

        graphView.setData(data, minGoal, maxGoal)
    }

    private fun fetchDataForDateRange(startDate: Date, endDate: Date): List<Float> {
        // Mock data for illustration purposes
        // Replace this with actual data fetching logic
        return listOf(4f, 8f, 6f, 5f, 9f, 7f)
    }
}



