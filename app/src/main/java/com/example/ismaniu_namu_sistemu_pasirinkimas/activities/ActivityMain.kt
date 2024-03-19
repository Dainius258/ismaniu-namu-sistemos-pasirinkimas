package com.example.ismaniu_namu_sistemu_pasirinkimas.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.ismaniu_namu_sistemu_pasirinkimas.databinding.ActivityFirstPageBinding

class ActivityMain : AppCompatActivity() {
    private lateinit var binding: ActivityFirstPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO) // panaikina dark  mode
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Assuming your button ID is "backButton"
        binding.SystemInfoNyptukas.setOnClickListener {
            // Create Intent to go back to the MainActivity
            val intent = Intent(this, ActivitySystemInfo::class.java)
            startActivity(intent)
        }

        binding.KlausimynoNyptukas.setOnClickListener {
            val intent = Intent(this, ActivityKlausimynoPuslapis::class.java)
            startActivity(intent)
        }
    }
}