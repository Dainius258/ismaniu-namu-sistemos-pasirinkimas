package com.example.ismaniu_namu_sistemu_pasirinkimas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageView

class SystemInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_system_info)
        val lbButton: Button = findViewById(R.id.btnLbmanagement)
        val enetButton: Button = findViewById(R.id.btnEnetsmarthome)
        val jungButton: Button = findViewById(R.id.btnJunghome)
        val knxButton: Button = findViewById(R.id.btnKnxsistema)

        lbButton.setOnClickListener{
            val intent = Intent(this, LB_Management::class.java)
            startActivity(intent)
        }
        enetButton.setOnClickListener {
            val intent = Intent(this, eNET_SmartHome::class.java)
            startActivity(intent)
        }
        jungButton.setOnClickListener {
            val intent = Intent(this, JUNGHOME::class.java)
            startActivity(intent)
        }
        knxButton.setOnClickListener {
            val intent = Intent(this, KNX_Valdymo_Sistema::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<ImageView>(R.id.NyptukasAtgal)
        backButton.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}