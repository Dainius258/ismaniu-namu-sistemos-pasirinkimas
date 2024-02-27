package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.Manifest
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class PabaigosPsl : AppCompatActivity() {


    private val REQUEST_CODE = 1232
    private lateinit var btnCreatePdf: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.klausimyno_pabaiga)
        askPermissions()
        btnCreatePdf = findViewById(R.id.XtmlToPdf)
        btnCreatePdf.setOnClickListener {
            createPDF()
        }
    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
    }

    private fun createPDF() {
        val document = PdfDocument()
        val pageInfo = PdfDocument.PageInfo.Builder(1080, 1920, 1).create()
        val page = document.startPage(pageInfo)

        val canvas: Canvas = page.canvas

        val paint = Paint()
        paint.color = Color.RED
        paint.textSize = 42f

        val text = "Hello ismanus namas"
        val x = 500f
        val y = 900f

        canvas.drawText(text, x, y, paint)
        document.finishPage(page)

        val downloadsDir: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val fileName = "Ismanus_Namai1.pdf"
        val file = File(downloadsDir, fileName)
        try {
            val fos = FileOutputStream(file)
            document.writeTo(fos)
            document.close()
            fos.close()
        } catch (e: FileNotFoundException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
    }
}