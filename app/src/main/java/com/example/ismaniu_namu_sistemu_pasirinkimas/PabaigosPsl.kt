package com.example.ismaniu_namu_sistemu_pasirinkimas
import android.util.Log
import android.Manifest
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.RectF
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import android.view.MotionEvent
import android.view.View
import android.widget.ListView

class PabaigosPsl : AppCompatActivity() {

    private val REQUEST_CODE = 1232
    private lateinit var btnCreatePdf: Button
    private var count = 1 // Move count variable here to persist between button clicks

    private lateinit var checkboxAdapter: CheckboxAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.klausimyno_pabaiga)

// HOUSE SYSTEM BUTTONS
        val buttonSystem1 = findViewById<Button>(R.id.button2)
        val buttonSystem2 = findViewById<Button>(R.id.button3)
        val buttonSystem3 = findViewById<Button>(R.id.button4)
        val buttonSystem4 = findViewById<Button>(R.id.button5)

        // Paslepti mygtukus
        val filteredSystems =
            (intent.getSerializableExtra("filteredSystems") as? ArrayList<HomeSystem>) ?: return
        //Log.d("PabaigosPsl", "Gautos filtruotos sistemos: $filteredSystems")
        Log.d("PabaigosPsl", "Filtered Systems: $filteredSystems, Size: ${filteredSystems.size}")

// Paslpti visus mytukus
        val buttons = listOf(buttonSystem1, buttonSystem2, buttonSystem3, buttonSystem4)
        buttons.forEach { it.visibility = View.GONE }

// Nesl5pti tik mygtukus kurie atitinka pasirinkimams
        filteredSystems.forEach { system ->
            when(system.name) {
                "KNX" -> buttonSystem1.visibility = View.VISIBLE
                "JUNG Home" -> buttonSystem2.visibility = View.VISIBLE
                "eNet SMART HOME" -> buttonSystem3.visibility = View.VISIBLE
                "LB MANAGEMENT" -> buttonSystem4.visibility = View.VISIBLE
            }
        }

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

        // Load your photo from resources
        val photoBitmap = BitmapFactory.decodeResource(resources, R.drawable.jung)
        val photoEnet = BitmapFactory.decodeResource(resources, R.drawable.enet)
        val photoJung = BitmapFactory.decodeResource(resources, R.drawable.junglogo)
        val photoKnx = BitmapFactory.decodeResource(resources, R.drawable.knx)

        // Logo
        val photoWidth = 250
        val photoHeight = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoX = (1080 - photoWidth) / 2f
        val photoY = 50f

        // photoFirm2
        val photoFirm2Width = 128f
        val photoFirm2Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm2X = 700f
        val photoFirm2Y = 650f

        // photoFirm3
        val photoFirm3Width = 96f
        val photoFirm3Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm3X = 650f
        val photoFirm3Y = 1050f

        // photoFirm4
        val photoFirm4Width = 96f
        val photoFirm4Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm4X = 750f
        val photoFirm4Y = 1500f


        // Draw the photo
        canvas.drawBitmap(photoBitmap, null, RectF(photoX, photoY, photoX + photoWidth, photoY + photoHeight), null)

        val paint = Paint()
        paint.color = Color.BLACK
        paint.textSize = 84f
        paint.textAlign = Paint.Align.CENTER // Center the text

        val subtitle = "Galimos sistemos pagal jūsų pasirinktus kriterijus :"
        val xTitle = 540f
        val yTitle = 150f

        val firm1 = "LB-MANAGEMENT"
        val xFirmTitle1 = 540f
        val yFirmTitle1 = 300f

        val montuotuojai1 = "Montuotojai : "
        val xmontuotuojai1 = 125f
        val ymontuotuojai1 = 400f

        val firm2 = "eNet SMART HOME"
        val xFirmTitle2 = 540f
        val yFirmTitle2 = 650f

        val montuotuojai2 = "Montuotojai : "
        val xmontuotuojai2 = 125f
        val ymontuotuojai2 = 750f

        val firm3 = "JUNG HOME"
        val xFirmTitle3 = 540f
        val yFirmTitle3 = 1050f

        val montuotuojai3 = "Montuotojai : "
        val xmontuotuojai3 = 125f
        val ymontuotuojai3 = 1150f

        val firm4 = "KNX valdymo sistema"
        val xFirmTitle4 = 540f
        val yFirmTitle4 = 1500f

        val montuotuojai4 = "Montuotojai : "
        val xmontuotuojai4 = 125f
        val ymontuotuojai4 = 1600f

        // Draw montuotuojai1
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(montuotuojai1, xmontuotuojai1, ymontuotuojai1 + 50, paint)

        // Draw montuotuojai2
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(montuotuojai2, xmontuotuojai2, ymontuotuojai2 + 50, paint)

        // Draw montuotuojai3
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(montuotuojai3, xmontuotuojai3, ymontuotuojai3 + 50, paint)

        // Draw montuotuojai4
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(montuotuojai4, xmontuotuojai4, ymontuotuojai4 + 50, paint)

        // Draw subtitle
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(subtitle, xTitle, yTitle + 50, paint)

        // Draw Firm1
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(firm1, xFirmTitle1, yFirmTitle1 + 50, paint)
        drawLine(canvas, xFirmTitle1 - 200f, yFirmTitle1 + 75f)

        // Draw Firm2 and photoFirm2
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(firm2, xFirmTitle2, yFirmTitle2 + 50, paint)
        drawLine(canvas, xFirmTitle2 - 200f, yFirmTitle2 + 75f)
        canvas.drawBitmap(photoEnet, null, RectF(photoFirm2X, photoFirm2Y, photoFirm2X + photoFirm2Width, photoFirm2Y + photoFirm2Height), null)

        // Draw Firm3 and photoFirm3
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(firm3, xFirmTitle3, yFirmTitle3 + 50, paint)
        drawLine(canvas, xFirmTitle3 - 200f, yFirmTitle3 + 75f)
        canvas.drawBitmap(photoJung, null, RectF(photoFirm3X, photoFirm3Y, photoFirm3X + photoFirm3Width, photoFirm3Y + photoFirm3Height), null)

        // Draw Firm4 and photoFirm4
        paint.textSize = 32f
        paint.setShadowLayer(2f, 2f, 2f, Color.BLACK)
        canvas.drawText(firm4, xFirmTitle4, yFirmTitle4 + 50, paint)
        drawLine(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 75f)
        canvas.drawBitmap(photoKnx, null, RectF(photoFirm4X, photoFirm4Y, photoFirm4X + photoFirm4Width, photoFirm4Y + photoFirm4Height), null)

        // Add clickable link "Montuotuojas Rimvydas Velička"
        val knxLinkText1 = "Montuotojas Rimvydas Velička"
        val knxLinkUrl1 = "https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/rimvydas-velicka/"
        paint.textSize = 24f
        drawLink(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 150f, knxLinkText1, knxLinkUrl1)

        // Add clickable link "Montuotuojas Rimvydas Velička"
        val knxLinkText2 = "Montuotojas Dainius Jurgulis"
        val knxLinkUrl2 = "https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/dainius-jurgulis/"
        paint.textSize = 24f
        drawLink(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 200f, knxLinkText2, knxLinkUrl2)

        // Add clickable link "Montuotuojas Rimvydas Velička"
        val knxLinkText3 = "Montuotojas Anatolij Volodko"
        val knxLinkUrl3 = "https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/anatolij-volodko/"
        paint.textSize = 24f
        drawLink(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 250f, knxLinkText2, knxLinkUrl3)

        // Add clickable link "Montuotuojas Rimvydas Velička"
        val knxLinkText4 = "Montuotojas Valerij Lukoic"
        val knxLinkUrl4 = "https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/valerij-lukoic/"
        paint.textSize = 24f
        drawLink(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 300f, knxLinkText4, knxLinkUrl4)

        // Add clickable link "Montuotuojas Rimvydas Velička"
        val knxLinkText5 = "Montuotojas Dovydas Kančauskis"
        val knxLinkUrl5 = "https://kontaktai.jung.lt/montuotojai/jung-home-diegejai/dovydas-kancauskis/"
        paint.textSize = 24f
        drawLink(canvas, xFirmTitle4 - 200f, yFirmTitle4 + 350f, knxLinkText5, knxLinkUrl5)

        document.finishPage(page)

        val downloadsDir: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
        val baseName = "Ismanus_Namai"
        var fileName = "$baseName$count.pdf"

        count++

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

    private fun drawLine(canvas: Canvas, startX: Float, startY: Float) {
        val paint = Paint().apply {
            color = Color.BLACK
            strokeWidth = 2f
        }
        val gap = 25f
        canvas.drawLine(startX, startY + gap, startX + 400f, startY + gap, paint)
    }

    private fun drawLink(canvas: Canvas, x: Float, y: Float, text: String, url: String) {
        val paint = Paint().apply {
            color = Color.BLUE
            textSize = 32f
            isUnderlineText = true
        }
        canvas.drawText(text, x, y, paint)
        val rect = RectF(x, y - paint.textSize, x + paint.measureText(text), y)
        // Store the clickable region and the URL in a data structure to handle clicks
        clickableRegions.add(ClickableRegion(rect, url))
    }

    // Handle click events
    // Define a data class to represent clickable regions
    data class ClickableRegion(val rect: RectF, val url: String)

    // Initialize an empty list to store clickable regions
    private val clickableRegions = mutableListOf<ClickableRegion>()

    // Handle click events
    private fun handleOnClick(x: Float, y: Float) {
        for (region in clickableRegions) {
            if (region.rect.contains(x, y)) {
                openUrlInBrowser(region.url)
                return
            }
        }
    }

    // Open URL in browser
    private fun openUrlInBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No application can handle this request", Toast.LENGTH_LONG).show()
        }
    }
    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            handleOnClick(event.x, event.y)
        }
        Log.d("TouchEvent", "X: ${event.x}, Y: ${event.y}")
        return super.onTouchEvent(event)
    }
}