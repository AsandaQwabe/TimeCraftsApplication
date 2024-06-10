package com.example.timecrafts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun openSignIn(view: View) {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

    fun openRegister(view: View) {
        val intent = Intent(this, Registration::class.java)
        startActivity(intent)
    }
}