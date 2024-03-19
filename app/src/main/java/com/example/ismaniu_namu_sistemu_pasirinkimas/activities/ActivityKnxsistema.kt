package com.example.ismaniu_namu_sistemu_pasirinkimas.activities

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.ismaniu_namu_sistemu_pasirinkimas.R

class ActivityKnxsistema : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_knx_valdymo_sistema)

        val backButton: ImageView = findViewById(R.id.ivAtgalKnx)
        backButton.setOnClickListener {
            // Navigate back to the system info activity
            val intent = Intent(this, ActivitySystemInfo::class.java)
            startActivity(intent)
        }

        // ImageView for UAB Odri
        val imageViewOdri: ImageView = findViewById(R.id.UabOdri)
        imageViewOdri.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/uab-odri/")
        }

        // ImageView for Sviesos Studija
        val imageViewSviesosStudija: ImageView = findViewById(R.id.SviesosStudija)
        imageViewSviesosStudija.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/rekomenduojami-elektrikai/sviesos-studija/")
        }

        // ImageView for Busto Automatika
        val imageViewBustoAutomatika: ImageView = findViewById(R.id.BustoAuto)
        imageViewBustoAutomatika.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/busto-automatika/")
        }

        // ImageView for Ismanus Sprendimai
        val imageViewIsmanusSprendimai: ImageView = findViewById(R.id.IsmanusSprendimai)
        imageViewIsmanusSprendimai.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/ismanus-sprendimai/")
        }

        // ImageView for Inzineriniu Sprendimu Grupe
        val imageViewInzineriniuSprendimuGrupe: ImageView = findViewById(R.id.InzinieriuSpGr)
        imageViewInzineriniuSprendimuGrupe.setOnClickListener {
            openWebsite("https://kontaktai.jung.lt/montuotojai/knx-diegejai/inzineriniu-sprendimu-grupe/")
        }
    }

    // Function to open a website
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}