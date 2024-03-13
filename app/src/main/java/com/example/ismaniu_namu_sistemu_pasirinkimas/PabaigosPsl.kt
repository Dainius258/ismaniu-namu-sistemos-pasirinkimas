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
class PabaigosPsl : AppCompatActivity() {

    private val REQUEST_CODE = 1232
    private lateinit var btnCreatePdf: Button
    private var count = 1 // Move count variable here to persist between button clicks

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

        val subtitle = "Žinomi montuotojai galintys įrengti jūsų pasirinktą sistemą"
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

        // Info apie Rimvyda
        val jungLinkText1 = "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(jungLinkText1, xmontuotuojai1 + 400, ymontuotuojai1 + 100, paint)

        // Info apie Dainiu
        val jungLinkText2 = "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(jungLinkText2, xmontuotuojai1 + 400, ymontuotuojai1 + 125, paint)

        // Info apie Anatolij
        val jungLinkText3 = "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(jungLinkText3, xmontuotuojai1 + 400, ymontuotuojai1 + 150, paint)

        // Info apie Valerij
        val jungLinkText4 = "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(jungLinkText4, xmontuotuojai1 + 400, ymontuotuojai1 +175, paint)

        // Info apie Dovyda
        val jungLinkText5 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(jungLinkText5, xmontuotuojai1 + 400, ymontuotuojai1 +200, paint)

        // Info apie Rimvyda
        val enetLinkText1 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(enetLinkText1, xmontuotuojai2 + 400, ymontuotuojai2 + 100, paint)

        // Info apie Dainiu
        val enetLinkText2 = "Pažangi namų automatika ︱ El-paštas : info@iha.lt ︱ Telefono nr. : +370 680 15265"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(enetLinkText2, xmontuotuojai2 + 400, ymontuotuojai2 + 125, paint)

        // Info apie Anatolij
        val enetLinkText3 = "Vimova ︱ El-paštas : info@vimova.lt ︱ Telefono nr. : +370 644 99571"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(enetLinkText3, xmontuotuojai2 + 400, ymontuotuojai2 + 150, paint)

        // Info apie Valerij
        val enetLinkText4 = "ATEA ︱ El-paštas : Aurimas.petrutis@atea.lt ︱ Telefono nr. : +370 682 55048"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(enetLinkText4, xmontuotuojai2 + 400, ymontuotuojai2 +175, paint)

        // Info apie Dovyda
        val enetLinkText5 = "Elektros architektūra (tik projektavimas) ︱ El-paštas : gediminas@earchitektura.lt ︱ Telefono nr. : +370 672 92600"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(enetLinkText5, xmontuotuojai2 + 400, ymontuotuojai2 +200, paint)

        // Info apie Rimvyda
        val lbLinkText1 = "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(lbLinkText1, xmontuotuojai3 + 400, ymontuotuojai3 + 100, paint)

        // Info apie Dainiu
        val lbLinkText2 = "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(lbLinkText2, xmontuotuojai3 + 400, ymontuotuojai3 + 125, paint)

        // Info apie Anatolij
        val lbLinkText3 = "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(lbLinkText3, xmontuotuojai3 + 400, ymontuotuojai3 + 150, paint)

        // Info apie Valerij
        val lbLinkText4 = "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(lbLinkText4, xmontuotuojai3 + 400, ymontuotuojai3 +175, paint)

        // Info apie Dovyda
        val lbLinkText5 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(lbLinkText5, xmontuotuojai3 + 400, ymontuotuojai3 +200, paint)

        // Info apie Rimvyda
        val knxLinkText1 = "Montuotojas Rimvydas Velička ︱ El-paštas : rimkasss@gmail.com ︱ Telefono nr. : +370 622 93906"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(knxLinkText1, xmontuotuojai4 + 400, ymontuotuojai4 + 100, paint)

        // Info apie Dainiu
        val knxLinkText2 = "Montuotojas Dainius Jurgulis ︱ El-paštas : dovydas.kancauskis@gmail.com ︱ Telefono nr. : +370 629 22779"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(knxLinkText2, xmontuotuojai4 + 400, ymontuotuojai4 + 125, paint)

        // Info apie Anatolij
        val knxLinkText3 = "Montuotojas Anatolij Volodko ︱ El-paštas : valerluko@gmail.com ︱ Telefono nr. : +370 675 84765"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(knxLinkText3, xmontuotuojai4 + 400, ymontuotuojai4 + 150, paint)

        // Info apie Valerij
        val knxLinkText4 = "Montuotojas Valerij Lukoic ︱ El-paštas : eltolikas@gmail.com ︱ Telefono nr. : +370 687 59929"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(knxLinkText4, xmontuotuojai4 + 400, ymontuotuojai4 +175, paint)

        // Info apie Dovyda
        val knxLinkText5 = "Montuotojas Dovydas Kančauskis ︱ El-paštas : djurgulis@gmail.com ︱ Telefono nr. : +370 659 53820"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas.drawText(knxLinkText5, xmontuotuojai4 + 400, ymontuotuojai4 +200, paint)

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