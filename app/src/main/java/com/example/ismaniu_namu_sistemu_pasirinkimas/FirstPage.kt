package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ismaniu_namu_sistemu_pasirinkimas.databinding.ActivityFirstPageBinding

class FirstPage : AppCompatActivity() {
    private lateinit var binding: ActivityFirstPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Assuming your button ID is "backButton"
        binding.SystemInfoNyptukas.setOnClickListener {
            // Create Intent to go back to the MainActivity
            val intent = Intent(this, SystemInfo::class.java)
            startActivity(intent)
        }

        binding.KlausimynoNyptukas.setOnClickListener {
            val intent = Intent(this, KlausimynoPuslapis::class.java)
            startActivity(intent)
        }
    }
}