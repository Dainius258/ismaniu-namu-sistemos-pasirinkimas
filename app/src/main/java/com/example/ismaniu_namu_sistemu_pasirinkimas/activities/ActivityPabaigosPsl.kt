package com.example.ismaniu_namu_sistemu_pasirinkimas.activities
import android.Manifest
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.RectF
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import android.view.View
import android.widget.ListView
import android.widget.ProgressBar
import com.example.ismaniu_namu_sistemu_pasirinkimas.utils.CheckboxAdapter
import com.example.ismaniu_namu_sistemu_pasirinkimas.utils.HomeSystem
import com.example.ismaniu_namu_sistemu_pasirinkimas.R
import com.example.ismaniu_namu_sistemu_pasirinkimas.data.FirmInfo

class ActivityPabaigosPsl : AppCompatActivity() {

    private val REQUEST_CODE = 1232
    private lateinit var btnCreatePdf: Button

    // Define buttons for house systems
    private lateinit var buttonSystem1: Button
    private lateinit var buttonSystem2: Button
    private lateinit var buttonSystem3: Button
    private lateinit var buttonSystem4: Button

    private lateinit var checkboxAdapter: CheckboxAdapter
    private lateinit var listView: ListView

    private val downloadsDir: File = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

    fun generateRandomString(length: Int): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') // Define the characters allowed in the random string
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.klausimyno_pabaiga)

        askPermissions()

        // Initialize house system buttons
        buttonSystem1 = findViewById(R.id.button2)
        buttonSystem2 = findViewById(R.id.button3)
        buttonSystem3 = findViewById(R.id.button4)
        buttonSystem4 = findViewById(R.id.button5)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

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

        btnCreatePdf = findViewById(R.id.XtmlToPdf)
        btnCreatePdf.setOnClickListener {
            createPDF(selectedFunctions, progressBar, downloadsDir, filteredSystems)
        }

        val btnBackToStartPage = findViewById<Button>(R.id.BackToStartPage)
        btnBackToStartPage.setOnClickListener {
            val intent = Intent(this, ActivityMain::class.java)
            startActivity(intent)
            finish() // Finish the current activity
        }
    }

    private fun askPermissions() {
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_CODE)
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), REQUEST_CODE)
    }

    private fun createPDF(selectedFunctions: ArrayList<String>, progressBar:ProgressBar, downloadsDir:File, filteredSystems:ArrayList<HomeSystem>) {

        progressBar.visibility = View.VISIBLE

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

        val lbLinkTexts = listOf(
            "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021",
            "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403",
            "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904",
            "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488",
            "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        )

        val enetLinkTexts = listOf(
            "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400",
            "Pažangi namų automatika ︱ El-paštas : info@iha.lt ︱ Telefono nr. : +370 680 15265",
            "Vimova ︱ El-paštas : info@vimova.lt ︱ Telefono nr. : +370 644 99571",
            "ATEA ︱ El-paštas : Aurimas.petrutis@atea.lt ︱ Telefono nr. : +370 682 55048",
            "Elektros architektūra (tik projektavimas) ︱ El-paštas : gediminas@earchitektura.lt ︱ Telefono nr. : +370 672 92600"
        )

        val jungLinkTexts = listOf(
            "UAB Odri ︱ El-paštas : info@odri.lt ︱ Telefono nr. : +370 652 04021",
            "Šviesos studija THINKLIGHT ︱ El-paštas : info@thinklight.lt ︱ Telefono nr. : +370 665 11403",
            "Būsto automatika ︱ El-paštas : gediminas.jovaisa@bustoautomatika.lt ︱ Telefono nr. : +370 659 29904",
            "Išmanūs sprendimai ︱ El-paštas : info@ismanussprendimai.lt ︱ Telefono nr. : +370 672 66488",
            "Inžinerinių sprendimų grupė ︱ El-paštas : info@isg.lt ︱ Telefono nr. : +370 698 73400"
        )

        val knxLinkTexts = listOf(
            "Montuotojas Rimvydas Velička ︱ El-paštas : rimkasss@gmail.com ︱ Telefono nr. : +370 622 93906",
            "Montuotojas Dainius Jurgulis ︱ El-paštas : dovydas.kancauskis@gmail.com ︱ Telefono nr. : +370 629 22779",
            "Montuotojas Anatolij Volodko ︱ El-paštas : valerluko@gmail.com ︱ Telefono nr. : +370 675 84765",
            "Montuotojas Valerij Lukoic ︱ El-paštas : eltolikas@gmail.com ︱ Telefono nr. : +370 687 59929",
            "Montuotojas Dovydas Kančauskis ︱ El-paštas : djurgulis@gmail.com ︱ Telefono nr. : +370 659 53820"
        )

        val firmInfo1 = FirmInfo(
            firmName = "LB-MANAGEMENT",
            xFirmTitle = 540f,
            yFirmTitle = 400f,
            photoFirmWidth = 166f,
            photoFirmHeight = 16f,
            linkTexts = lbLinkTexts
        )

        val firmInfo2 = FirmInfo(
            firmName = "eNet SMART HOME",
            xFirmTitle = 540f,
            yFirmTitle = 750f,
            photoFirmWidth = 266f,
            photoFirmHeight = 16f,
            linkTexts = enetLinkTexts
        )

        val firmInfo3 = FirmInfo(
            firmName = "JUNG HOME",
            xFirmTitle = 540f,
            yFirmTitle = 1150f,
            photoFirmWidth = 166f,
            photoFirmHeight = 16f,
            linkTexts = jungLinkTexts
        )

        val firmInfo4 = FirmInfo(
            firmName = "KNX valdymo sistema",
            xFirmTitle = 540f,
            yFirmTitle = 1600f,
            photoFirmWidth = 266f,
            photoFirmHeight = 16f,
            linkTexts = knxLinkTexts
        )







        // Nesl5pti tik mygtukus kurie atitinka pasirinkimams
        var previousFirmInfoY = 350f // Initialize the previous Y-coordinate

        filteredSystems.forEach { system ->
            var currentFirmInfo: FirmInfo? = null
            var currentPhoto: Bitmap? = null

            // Set current firm info and photo based on the system name
            when(system.name) {
                "KNX" -> {
                    currentFirmInfo = firmInfo4
                    currentPhoto = photoKnx
                }
                "JUNG Home" -> {
                    currentFirmInfo = firmInfo3
                    currentPhoto = photoJung
                }
                "eNet SMART HOME" -> {
                    currentFirmInfo = firmInfo2
                    currentPhoto = photoEnet
                }
                "LB MANAGEMENT" -> {
                    currentFirmInfo = firmInfo1
                    // No need to assign photo for LB MANAGEMENT
                }
            }

            // If current firm info exists, adjust its y-coordinate and draw
            currentFirmInfo?.let { firmInfo ->
                paint.textSize = 24f
                canvas2.drawText(firmInfo.firmName, firmInfo.xFirmTitle, previousFirmInfoY, paint)

                // Draw photo if available
                currentPhoto?.let {
                    canvas2.drawBitmap(
                        it,
                        null,
                        RectF(firmInfo.xFirmTitle + 150, previousFirmInfoY + 150, firmInfo.xFirmTitle + firmInfo.photoFirmWidth, previousFirmInfoY + firmInfo.photoFirmHeight),
                        null
                    )
                }

                // Draw link texts
                val linkTextsStartY = previousFirmInfoY + 50
                paint.textSize = 20f
                firmInfo.linkTexts.forEachIndexed { index, text ->
                    canvas2.drawText(text, firmInfo.xFirmTitle, linkTextsStartY + index * 30, paint)
                }

                // Update previous Y-coordinate for the next iteration
                previousFirmInfoY += 250f
            }
        }

        document.finishPage(page2)

        val baseName = "Ismanus_Namai"
        val randomString = generateRandomString(8)
        var fileName = "$baseName$randomString.pdf"


        val file = File(downloadsDir, fileName)
        try {
            Log.d("PDFSAVE", "Trying to save")
            val fos = FileOutputStream(file)
            document.writeTo(fos)
            Log.d("PDFSAVE", "writeTo")
            document.close()
            Log.d("PDFSAVE", "Document close")
            fos.close()
            Log.d("PDFSAVE", "Stream close")
        } catch (e: FileNotFoundException) {
            throw RuntimeException(e)
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        progressBar.visibility = View.GONE
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