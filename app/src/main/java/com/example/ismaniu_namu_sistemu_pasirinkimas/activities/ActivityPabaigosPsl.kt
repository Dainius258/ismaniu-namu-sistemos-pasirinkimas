package com.example.ismaniu_namu_sistemu_pasirinkimas.activities
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
import android.view.View
import android.widget.ListView
import com.example.ismaniu_namu_sistemu_pasirinkimas.utils.CheckboxAdapter
import com.example.ismaniu_namu_sistemu_pasirinkimas.utils.HomeSystem
import com.example.ismaniu_namu_sistemu_pasirinkimas.R

class ActivityPabaigosPsl : AppCompatActivity() {

    private val REQUEST_CODE = 1232
    private lateinit var btnCreatePdf: Button
    private var count = 1 // Move count variable here to persist between button clicks

    // Define buttons for house systems
    private lateinit var buttonSystem1: Button
    private lateinit var buttonSystem2: Button
    private lateinit var buttonSystem3: Button
    private lateinit var buttonSystem4: Button

    private lateinit var checkboxAdapter: CheckboxAdapter
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.klausimyno_pabaiga)

        // Initialize house system buttons
        buttonSystem1 = findViewById(R.id.button2)
        buttonSystem2 = findViewById(R.id.button3)
        buttonSystem3 = findViewById(R.id.button4)
        buttonSystem4 = findViewById(R.id.button5)

        // Set click listeners for house system buttons
        buttonSystem1.setOnClickListener {
            navigateToEnetSmartHome()
        }
        buttonSystem2.setOnClickListener {
            navigateToJungHome()
        }
        buttonSystem3.setOnClickListener {
            navigateToKnxValdymoSistema()
        }
        buttonSystem4.setOnClickListener {
            navigateToLbManagement()
        }

        // Atrinktos sistemos
        val filteredSystems = (intent.getSerializableExtra("filteredSystems") as? ArrayList<HomeSystem>) ?: return
        // Vartotojo pasirinktos funkcijos, galima pasiimti visas funkcijas su selectedFunctions
        val selectedFunctions = (intent.getSerializableExtra("selectedFunctions") as? ArrayList<String>) ?: return


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
            createPDF(selectedFunctions)
        }

    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
    }

    private fun createPDF(selectedFunctions: ArrayList<String>) {


        val document = PdfDocument()
        val pageInfo1 = PdfDocument.PageInfo.Builder(1080, 1920, 1).create()
        val page1 = document.startPage(pageInfo1)
        val canvas1: Canvas = page1.canvas

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

        canvas1.drawBitmap(photoBitmap, null, RectF(photoX, photoY, photoX + photoWidth, photoY + photoHeight), null)
        val paint = Paint()


//SUBTITLE1
        val subtitle1 = "Jūsų pasirinkti kriterijai :"
        paint.textSize = 48f
        val xTitle = 540f
        val yTitle = 225f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas1.drawText(subtitle1, photoX - 100, yTitle, paint)

        val yOffset = 45 // Increase the y-coordinate gap between items
        val lineLength = 1000f // Length of the lines (350f long)
        val lineStartX = xTitle - 500 // Starting x-coordinate for the lines

// Calculate the x-coordinate for the second row (100 units farther from the first row)
        val secondRowX = lineStartX + 650

// Draw the text and lines
        for (i in selectedFunctions.indices) {
            val row = i % 2 // Determine the row (0 or 1)
            val textY = yTitle + 100 + (i / 2) * yOffset // Calculate y-coordinate for the text
            val textX = if (row == 0) lineStartX else secondRowX // Calculate x-coordinate for the text

            // Draw text
            paint.textSize = 20f
            canvas1.drawText(selectedFunctions[i], textX, textY, paint)

            // Draw line below the text
            val lineY = textY + yOffset / 2 // Y-coordinate for the line (middle of the text)
            canvas1.drawLine(textX, lineY, textX + lineLength, lineY, paint)
        }



        document.finishPage(page1)
        val pageInfo2 = PdfDocument.PageInfo.Builder(1080, 1920, 2).create()
        val page2 = document.startPage(pageInfo2)
        val canvas2: Canvas = page2.canvas


        // photoFirm2
        val photoFirm2Width = 128f
        val photoFirm2Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm2X = 670f
        val photoFirm2Y = 600f
        canvas2.drawBitmap(photoEnet, null, RectF(photoFirm2X, photoFirm2Y, photoFirm2X + photoFirm2Width, photoFirm2Y + photoFirm2Height), null)

        // photoFirm3
        val photoFirm3Width = 72f
        val photoFirm3Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm3X = 670f
        val photoFirm3Y = 980f
        canvas2.drawBitmap(photoJung, null, RectF(photoFirm3X, photoFirm3Y, photoFirm3X + photoFirm3Width, photoFirm3Y + photoFirm3Height), null)

        // photoFirm4
        val photoFirm4Width = 72f
        val photoFirm4Height = (photoBitmap.height.toFloat() / photoBitmap.width * photoWidth).toInt()
        val photoFirm4X = 670f
        val photoFirm4Y = 1430f
        canvas2.drawBitmap(photoKnx, null, RectF(photoFirm4X, photoFirm4Y, photoFirm4X + photoFirm4Width, photoFirm4Y + photoFirm4Height), null)

        // Draw the photo
        canvas2.drawBitmap(photoBitmap, null, RectF(photoX, photoY, photoX + photoWidth, photoY + photoHeight), null)

        paint.color = Color.BLACK
        paint.textSize = 84f
        paint.textAlign = Paint.Align.CENTER // Center the text

        //SUBTITLE
        val subtitle = "Sistemu montuotojų rekvizitai :"
        paint.textSize = 48f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(subtitle, xTitle, yTitle, paint)

        //FIRMA1 pavadinimas
        val firm1 = "LB-MANAGEMENT"
        val xFirmTitle1 = 540f
        val yFirmTitle1 = 300f
        paint.textSize = 24f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(firm1, xFirmTitle1, yFirmTitle1, paint)

        //FIRMA2 pavadinimas
        val firm2 = "eNet SMART HOME"
        val xFirmTitle2 = 540f
        val yFirmTitle2 = 650f
        paint.textSize = 24f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(firm2, xFirmTitle2, yFirmTitle2, paint)

        //FIRMA3 pavadinimas
        val firm3 = "JUNG HOME"
        val xFirmTitle3 = 540f
        val yFirmTitle3 = 1050f
        paint.textSize = 24f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(firm3, xFirmTitle3, yFirmTitle3, paint)

        //FIRMA4 pavadinimas
        val firm4 = "KNX valdymo sistema"
        val xFirmTitle4 = 540f
        val yFirmTitle4 = 1500f
        paint.textSize = 24f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(firm4, xFirmTitle4, yFirmTitle4, paint)

        // Info apie Rimvyda
        val jungLinkText1 = "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(jungLinkText1, xFirmTitle1, yFirmTitle1 + 50, paint)

        // Info apie Dainiu
        val jungLinkText2 = "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(jungLinkText2, xFirmTitle1, yFirmTitle1 + 75, paint)

        // Info apie Anatolij
        val jungLinkText3 = "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(jungLinkText3, xFirmTitle1, yFirmTitle1 + 100, paint)

        // Info apie Valerij
        val jungLinkText4 = "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(jungLinkText4, xFirmTitle1, yFirmTitle1 + 125, paint)

        // Info apie Dovyda
        val jungLinkText5 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(jungLinkText5, xFirmTitle1, yFirmTitle1 + 150, paint)

        // Info apie Rimvyda
        val enetLinkText1 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(enetLinkText1, xFirmTitle2, yFirmTitle2 + 50, paint)

        // Info apie Dainiu
        val enetLinkText2 = "Pažangi namų automatika ︱ El-paštas : info@iha.lt ︱ Telefono nr. : +370 680 15265"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(enetLinkText2, xFirmTitle2, yFirmTitle2 + 75, paint)

        // Info apie Anatolij
        val enetLinkText3 = "Vimova ︱ El-paštas : info@vimova.lt ︱ Telefono nr. : +370 644 99571"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(enetLinkText3, xFirmTitle2, yFirmTitle2 + 100, paint)

        // Info apie Valerij
        val enetLinkText4 = "ATEA ︱ El-paštas : Aurimas.petrutis@atea.lt ︱ Telefono nr. : +370 682 55048"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(enetLinkText4, xFirmTitle2, yFirmTitle2 +125, paint)

        // Info apie Dovyda
        val enetLinkText5 = "Elektros architektūra (tik projektavimas) ︱ El-paštas : gediminas@earchitektura.lt ︱ Telefono nr. : +370 672 92600"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(enetLinkText5, xFirmTitle2, yFirmTitle2 +150, paint)

        // Info apie Rimvyda
        val lbLinkText1 = "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(lbLinkText1, xFirmTitle3, yFirmTitle3 + 50, paint)

        // Info apie Dainiu
        val lbLinkText2 = "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(lbLinkText2, xFirmTitle3, yFirmTitle3 + 75, paint)

        // Info apie Anatolij
        val lbLinkText3 = "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(lbLinkText3, xFirmTitle3, yFirmTitle3 + 100, paint)

        // Info apie Valerij
        val lbLinkText4 = "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(lbLinkText4, xFirmTitle3, yFirmTitle3+125, paint)

        // Info apie Dovyda
        val lbLinkText5 = "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(lbLinkText5, xFirmTitle3, yFirmTitle3 +150, paint)

        // Info apie Rimvyda
        val knxLinkText1 = "Montuotojas Rimvydas Velička ︱ El-paštas : rimkasss@gmail.com ︱ Telefono nr. : +370 622 93906"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(knxLinkText1, xFirmTitle4, yFirmTitle4 + 50, paint)

        // Info apie Dainiu
        val knxLinkText2 = "Montuotojas Dainius Jurgulis ︱ El-paštas : dovydas.kancauskis@gmail.com ︱ Telefono nr. : +370 629 22779"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(knxLinkText2, xFirmTitle4, yFirmTitle4 + 75, paint)

        // Info apie Anatolij
        val knxLinkText3 = "Montuotojas Anatolij Volodko ︱ El-paštas : valerluko@gmail.com ︱ Telefono nr. : +370 675 84765"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(knxLinkText3, xFirmTitle4, yFirmTitle4 + 100, paint)

        // Info apie Valerij
        val knxLinkText4 = "Montuotojas Valerij Lukoic ︱ El-paštas : eltolikas@gmail.com ︱ Telefono nr. : +370 687 59929"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(knxLinkText4, xFirmTitle4, yFirmTitle4 +125, paint)

        // Info apie Dovyda
        val knxLinkText5 = "Montuotojas Dovydas Kančauskis ︱ El-paštas : djurgulis@gmail.com ︱ Telefono nr. : +370 659 53820"
        paint.textSize = 20f
        paint.setShadowLayer(1f, 1f, 1f, Color.BLACK)
        canvas2.drawText(knxLinkText5, xFirmTitle4, yFirmTitle4 +150, paint)

        document.finishPage(page2)


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

    private fun navigateToEnetSmartHome() {
        val intent = Intent(this, ActivityEnetSmartHome::class.java)
        startActivity(intent)
    }

    private fun navigateToJungHome() {
        val intent = Intent(this, ActivityJunghome::class.java)
        startActivity(intent)
    }

    private fun navigateToKnxValdymoSistema() {
        val intent = Intent(this, ActivityKnxsistema::class.java)
        startActivity(intent)
    }

    private fun navigateToLbManagement() {
        val intent = Intent(this, ActivityLbmanagement::class.java)
        startActivity(intent)
    }
}