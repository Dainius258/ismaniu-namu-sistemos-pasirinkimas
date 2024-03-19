package com.example.ismaniu_namu_sistemu_pasirinkimas.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ismaniu_namu_sistemu_pasirinkimas.R

class ActivityEnetSmartHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enet_smart_home)

        val backButton: ImageView = findViewById(R.id.ivAtgalEnet)
        backButton.setOnClickListener {
            // Navigate back to the system info activity
            val intent = Intent(this, ActivitySystemInfo::class.java)
            startActivity(intent)
        }

        // ImageView for UAB Odri
        val imageViewOdri: ImageView = findViewById(R.id.UabOdri)
        imageViewOdri.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/inzineriniu-sprendimu-grupe/")
        }

        // ImageView for Pazangi Namu Automatika
        val imageViewPazangiNamuAutomatika: ImageView = findViewById(R.id.SviesosStudija)
        imageViewPazangiNamuAutomatika.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/pazangi-namu-automatika/")
        }

        // ImageView for Vimova
        val imageViewVimova: ImageView = findViewById(R.id.BustoAuto)
        imageViewVimova.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/rekomenduojami-elektrikai/vimova/")
        }

        // ImageView for Atea
        val imageViewAtea: ImageView = findViewById(R.id.InzinieriuSpGr)
        imageViewAtea.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/atea/")
        }

        // ImageView for Elektros Architektura
        val imageViewElektrosArchitektura: ImageView = findViewById(R.id.IsmanusSprendimai)
        imageViewElektrosArchitektura.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/elektros-architektura-tik-projektavimas/")
        }
    }

    // Function to open a website
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
