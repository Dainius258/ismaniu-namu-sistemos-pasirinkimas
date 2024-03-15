package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView

import android.widget.MultiAutoCompleteTextView
import java.io.Serializable

class KlausimynoPuslapis : AppCompatActivity() {
    // Define your adapters array
    private lateinit var arrayAdapter: CheckboxAdapter
    private lateinit var secondArrayAdapter: CheckboxAdapter
    private lateinit var thirdArrayAdapter: CheckboxAdapter
    private lateinit var fourthArrayAdapter: CheckboxAdapter
    private lateinit var fifthArrayAdapter: CheckboxAdapter
    private lateinit var sixthArrayAdapter: CheckboxAdapter
    private lateinit var seventhArrayAdapter: CheckboxAdapter
    private lateinit var eighthArrayAdapter: CheckboxAdapter
    private lateinit var ninthArrayAdapter: CheckboxAdapter
    private lateinit var tenthArrayAdapter: CheckboxAdapter
    private lateinit var eleventhArrayAdapter: CheckboxAdapter
    private lateinit var twelfthArrayAdapter: CheckboxAdapter
    private lateinit var thirteenthArrayAdapter: CheckboxAdapter
    private lateinit var eighteenthArrayAdapter: CheckboxAdapter
    private lateinit var sixteenthArrayAdapter: CheckboxAdapter
    private lateinit var seventeenthArrayAdapter: CheckboxAdapter
    private lateinit var nineteenthArrayAdapter: CheckboxAdapter
    private lateinit var twentyArrayAdapter: CheckboxAdapter
    private lateinit var twentyOneArrayAdapter: CheckboxAdapter
    private lateinit var twentyTwoArrayAdapter: CheckboxAdapter
    private lateinit var twentyThreeArrayAdapter: CheckboxAdapter
    private lateinit var statybosArrayAdapter: CheckboxAdapter
    private lateinit var valdymasIBArrayAdapter: CheckboxAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_klausimyno_puslapis)
        // custom CheckboxAdapter
        arrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.lightdrop))
        val autoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        //second dropdown
        secondArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.blindsDropdown))
        val secondAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.secondAutoCompleteTextView)
        secondAutoCompleteTextView.setAdapter(secondArrayAdapter)
        secondAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // thrid dropdown
        thirdArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.conDropdown))
        val thirdAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.thirdAutoCompleteTextView)
        thirdAutoCompleteTextView.setAdapter(thirdArrayAdapter)
        thirdAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        //4 dropdown scenos
        fourthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.scDropdown))
        val fourthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fourthAutoCompleteTextView)
        fourthAutoCompleteTextView.setAdapter(fourthArrayAdapter)
        fourthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 5 Energijos  dropdown
        fifthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.energyDropd))
        val fifthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fifthAutoCompleteTextView)
        fifthAutoCompleteTextView.setAdapter(fifthArrayAdapter)
        fifthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 6 Weather dropdown
        sixthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.weatherDropd))
        val sixthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.sixthAutoCompleteTextView)
        sixthAutoCompleteTextView.setAdapter(sixthArrayAdapter)
        sixthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 7 langu duru stebejimas dropdown
        seventhArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.watchDoors))
        val seventhAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.seventhAutoCompleteTextView)
        seventhAutoCompleteTextView.setAdapter(seventhArrayAdapter)
        seventhAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 8 Laikmačio jungikliai
        eighthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.laikoJungikliai))
        val eighthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eighthAutoCompleteTextView)
        eighthAutoCompleteTextView.setAdapter(eighthArrayAdapter)
        eighthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 9 Pačio vartotojo konfiguracijos apsirašymas
        ninthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.vartotojoKonApr))
        val ninthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.ninthAutoCompleteTextView)
        ninthAutoCompleteTextView.setAdapter(ninthArrayAdapter)
        ninthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 10 Vartotojų valdymas
        tenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.varValdymas))
        val tenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.tenthAutoCompleteTextView)
        tenthAutoCompleteTextView.setAdapter(tenthArrayAdapter)
        tenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 11 Judesio, kiti jutiikliai
        eleventhArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.judesioJut))
        val fourteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eleventhAutoCompleteTextView)
        fourteenthAutoCompleteTextView.setAdapter(eleventhArrayAdapter)
        fourteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 12 Loginės funkcijos
        twelfthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.logFunkcijos))
        val twelfthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twelfthAutoCompleteTextView)
        twelfthAutoCompleteTextView.setAdapter(twelfthArrayAdapter)
        twelfthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 13 Signalizacijos žinutės
        thirteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.sigZinutes))
        val thirteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.thirteenthAutoCompleteTextView)
        thirteenthAutoCompleteTextView.setAdapter(thirteenthArrayAdapter)
        thirteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 14 Kamera
        eighteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.cam))
        val eighteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fifteenthAutoCompleteTextView)
        eighteenthAutoCompleteTextView.setAdapter(eighteenthArrayAdapter)
        eighteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 15 Diagramų sudarymas
        sixteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.diagramosDarymas))
        val sixteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.sixteenthAutoCompleteTextView)
        sixteenthAutoCompleteTextView.setAdapter(sixteenthArrayAdapter)
        sixteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 16 Veiksmų sękos
        seventeenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.sekosVeiksmu))
        val seventeenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.seventeenthAutoCompleteTextView)
        seventeenthAutoCompleteTextView.setAdapter(seventeenthArrayAdapter)
        seventeenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 17 Išmanioju telefonu
        nineteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.isTel))
        val nineteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eighteenthAutoCompleteTextView)
        nineteenthAutoCompleteTextView.setAdapter(nineteenthArrayAdapter)
        nineteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 18 Planšete
        twentyArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.planPhone))
        val twentyAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.nineteenthAutoCompleteTextView)
        twentyAutoCompleteTextView.setAdapter(twentyArrayAdapter)
        twentyAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 19 Nuotolinis valdymas
        twentyOneArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.nuotolinisVald))
        val twentyOneAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentiethAutoCompleteTextView)
        twentyOneAutoCompleteTextView.setAdapter(twentyOneArrayAdapter)
        twentyOneAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 20 Išmanūs asistentai
        twentyTwoArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.isHelpers))
        val twentyTwoAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentyfirstAutoCompleteTextView)
        twentyTwoAutoCompleteTextView.setAdapter(twentyTwoArrayAdapter)
        twentyTwoAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 21 Kompiuteriu/naršykle
        twentyThreeArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.controlPc))
        val twentyThreeAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentysecondAutoCompleteTextView)
        twentyThreeAutoCompleteTextView.setAdapter(twentyThreeArrayAdapter)
        twentyThreeAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 22 Kokios statybos namas
        statybosArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.kokiosStatybosNamas))
        val statybosAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.statybosautoCompleteTextView)
        statybosAutoCompleteTextView.setAdapter(statybosArrayAdapter)
        statybosAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 23 Valdymas Bluetooth, internetu
        valdymasIBArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, resources.getStringArray(R.array.valdymasInternetuBluetooth))
        val valdymasIBAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.valdymasInternetuAutoCompleteTextView)
        valdymasIBAutoCompleteTextView.setAdapter(valdymasIBArrayAdapter)
        valdymasIBAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        val backButton = findViewById<ImageView>(R.id.AtgalNyptukas)
        backButton.setOnClickListener {
            val intent = Intent(this, ActivityMain::class.java)
            startActivity(intent)
        }

        val selectSolutionButton = findViewById<Button>(R.id.button)
        selectSolutionButton.setOnClickListener {
            // Čia surink visus pasirinkimus iš visų AutoCompleteTextView
            val selectedOptions = getSelectedOptionsFromAllDropdowns()
            // Filtruok sistemas pagal pasirinkimus
            arrayAdapter.recommendHomeSystem(selectedOptions)
            val recommendedSystems: List<HomeSystem> = arrayAdapter.recommendHomeSystem(selectedOptions)
            val intent = Intent(this, PabaigosPsl::class.java).apply {
                // Here, explicitly cast recommendedSystems as Serializable
                putExtra("filteredSystems", recommendedSystems as Serializable)
            }
            startActivity(intent)
        }

    }
    private fun getSelectedOptionsFromAllDropdowns(): List<String> {
        val selectedOptions = mutableListOf<String>()
        // itrauk visus  MultiAutoCompleteTextView, gaukti pasirinkimus
        selectedOptions.addAll(arrayAdapter.getSelectedOptions())
        selectedOptions.addAll(secondArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(thirdArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(fourthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(fifthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(sixthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(seventhArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(eighthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(ninthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(tenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(eleventhArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(twelfthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(thirteenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(eighteenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(sixteenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(seventeenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(nineteenthArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(twentyArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(twentyOneArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(twentyTwoArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(twentyThreeArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(statybosArrayAdapter.getSelectedOptions())
        selectedOptions.addAll(valdymasIBArrayAdapter.getSelectedOptions())
        Log.d("CheckboxAdapter", "Selected options: $selectedOptions")
        return selectedOptions
    }
}


