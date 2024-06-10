package com.example.timecrafts

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class EntryListActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var listViewEntries: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry_list)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        listViewEntries = findViewById(R.id.listViewEntries)

        displayData()
    }

    private fun displayData() {
        val entries = mutableListOf<String>()

        val name = sharedPreferences.getString("name", "")
        val category = sharedPreferences.getString("category", "")
        val description = sharedPreferences.getString("description", "")
        val date = sharedPreferences.getString("date", "")
        val startTime = sharedPreferences.getString("startTime", "")
        val endTime = sharedPreferences.getString("endTime", "")

        entries.add("Name: $name")
        entries.add("Category: $category")
        entries.add("Description: $description")
        entries.add("Date: $date")
        entries.add("Start Time: $startTime")
        entries.add("End Time: $endTime")

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, entries)
        listViewEntries.adapter = adapter
    }
}
