package com.example.ismaniu_namu_sistemu_pasirinkimas.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ismaniu_namu_sistemu_pasirinkimas.R

class ActivityJunghome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_junghome)

        val backButton: ImageView = findViewById(R.id.ivAtgalJung)
        backButton.setOnClickListener {
            // Navigate back to the system info activity
            val intent = Intent(this, ActivitySystemInfo::class.java)
            startActivity(intent)
        }

        // ImageView for Rimvydas Velicka
        val imageViewRimvydas: ImageView = findViewById(R.id.UabOdri)
        imageViewRimvydas.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/rimvydas-velicka/")
        }

        // ImageView for Dovydas Kančauskis
        val imageViewDovydas: ImageView = findViewById(R.id.SviesosStudija)
        imageViewDovydas.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/dovydas-kancauskis/")
        }

        // ImageView for Valerij Lukoic
        val imageViewValerij: ImageView = findViewById(R.id.BustoAuto)
        imageViewValerij.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/valerij-lukoic/")
        }

        // ImageView for Anatolij Volodko
        val imageViewAnatolij: ImageView = findViewById(R.id.IsmanusSprendimai)
        imageViewAnatolij.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/anatolij-volodko/")
        }

        // ImageView for Dainius Jurgulis
        val imageViewDainius: ImageView = findViewById(R.id.InzinieriuSpGr)
        imageViewDainius.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/dainius-jurgulis/")
        }
    }

    // Function to open a website
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}