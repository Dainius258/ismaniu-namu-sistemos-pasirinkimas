package com.example.ismaniu_namu_sistemu_pasirinkimas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.ImageView

class SystemInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_info)

        val backButton = findViewById<ImageView>(R.id.NyptukasAtgal)
        backButton.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}