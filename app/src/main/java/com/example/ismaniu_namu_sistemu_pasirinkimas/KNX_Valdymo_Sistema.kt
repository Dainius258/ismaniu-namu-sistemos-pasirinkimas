package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class KNX_Valdymo_Sistema : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knx_valdymo_sistema)
        val backButton: ImageView = findViewById(R.id.tvAtgalKnx)

        backButton.setOnClickListener {
            val intent = Intent(this, SystemInfo::class.java)
            startActivity(intent)
        }
    }
}