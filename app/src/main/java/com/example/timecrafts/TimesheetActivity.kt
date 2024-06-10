package  com.example.timecrafts

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.timecrafts.EntryListActivity

class TimesheetActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timesheet)

        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val etName = findViewById<EditText>(R.id.et_Name)
        val etCategory = findViewById<EditText>(R.id.et_category)
        val etDescription = findViewById<EditText>(R.id.et_description)
        val etDate = findViewById<EditText>(R.id.et_date)
        val etStartTime = findViewById<EditText>(R.id.et_start_times)
        val etEndTime = findViewById<EditText>(R.id.et_end_times)
        val btnSave = findViewById<Button>(R.id.btn_send)

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val category = etCategory.text.toString()
            val description = etDescription.text.toString()
            val date = etDate.text.toString()
            val startTime = etStartTime.text.toString()
            val endTime = etEndTime.text.toString()

            saveData(name, category, description, date, startTime, endTime)

            val intent = Intent(this, EntryListActivity::class.java)
            startActivity(intent)




        }
    }

    private fun saveData(name: String, category: String, description: String, date: String, startTime: String, endTime: String) {
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("category", category)
        editor.putString("description", description)
        editor.putString("date", date)
        editor.putString("startTime", startTime)
        editor.putString("endTime", endTime)
        editor.apply()
    }

}