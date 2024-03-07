package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

import android.widget.MultiAutoCompleteTextView
import com.example.ismaniu_namu_sistemu_pasirinkimas.databinding.KlausimynoPabaigaBinding

class KlausimynoPuslapis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_klausimyno_puslapis)

        val languages = resources.getStringArray(R.array.lightdrop)
        // custom CheckboxAdapter
        val arrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, languages)

        //1
        val autoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.autoCompleteTextView)
        autoCompleteTextView.setAdapter(arrayAdapter)
        autoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        val secondLanguages = resources.getStringArray(R.array.blindsDropdown)
        val thirdLanguages = resources.getStringArray(R.array.conDropdown)

        // Use the custom CheckboxAdapter for each dropdown
        val secondArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, secondLanguages)
        val thirdArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, thirdLanguages)

        //2
        val secondAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.secondAutoCompleteTextView)
        //3
        val thirdAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.thirdAutoCompleteTextView)

        secondAutoCompleteTextView.setAdapter(secondArrayAdapter)
        secondAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        thirdAutoCompleteTextView.setAdapter(thirdArrayAdapter)
        thirdAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        //4 dropdown scenos
        val fourthLanguages = resources.getStringArray(R.array.scDropdown)
        val fourthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, fourthLanguages)
        val fourthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fourthAutoCompleteTextView)
        fourthAutoCompleteTextView.setAdapter(fourthArrayAdapter)
        fourthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 5 Energijos  dropdown
        val fifthLanguages = resources.getStringArray(R.array.energyDropd)
        val fifthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, fifthLanguages)
        val fifthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fifthAutoCompleteTextView)
        fifthAutoCompleteTextView.setAdapter(fifthArrayAdapter)
        fifthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 6 Weather dropdown
        val sixthLanguages = resources.getStringArray(R.array.weatherDropd)
        val sixthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, sixthLanguages)
        val sixthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.sixthAutoCompleteTextView)
        sixthAutoCompleteTextView.setAdapter(sixthArrayAdapter)
        sixthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 7 langu duru stebejimas dropdown
        val seventhLanguages = resources.getStringArray(R.array.watchDoors)
        val seventhArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, seventhLanguages)
        val seventhAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.seventhAutoCompleteTextView)
        seventhAutoCompleteTextView.setAdapter(seventhArrayAdapter)
        seventhAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 8 Laikmačio jungikliai
        val eighthLanguages = resources.getStringArray(R.array.laikoJungikliai)
        val eighthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, eighthLanguages)
        val eighthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eighthAutoCompleteTextView)
        eighthAutoCompleteTextView.setAdapter(eighthArrayAdapter)
        eighthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 9 Pačio vartotojo konfiguracijos apsirašymas
        val ninthLanguages = resources.getStringArray(R.array.vartotojoKonApr)
        val ninthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, ninthLanguages)
        val ninthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.ninthAutoCompleteTextView)
        ninthAutoCompleteTextView.setAdapter(ninthArrayAdapter)
        ninthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 10 Vartotojų valdymas
        val tenthLanguages = resources.getStringArray(R.array.varValdymas)
        val tenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, tenthLanguages)
        val tenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.tenthAutoCompleteTextView)
        tenthAutoCompleteTextView.setAdapter(tenthArrayAdapter)
        tenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 11 Judesio, kiti jutiikliai
        val fourteenthLanguages = resources.getStringArray(R.array.judesioJut)
        val eleventhArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, fourteenthLanguages)
        val fourteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eleventhAutoCompleteTextView)
        fourteenthAutoCompleteTextView.setAdapter(eleventhArrayAdapter)
        fourteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 12 Loginės funkcijos
        val twelfthLanguages = resources.getStringArray(R.array.logFunkcijos)
        val twelfthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, twelfthLanguages)
        val twelfthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twelfthAutoCompleteTextView)
        twelfthAutoCompleteTextView.setAdapter(twelfthArrayAdapter)
        twelfthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 13 Signalizacijos žinutės
        val thirteenthLanguages = resources.getStringArray(R.array.sigZinutes)
        val thirteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, thirteenthLanguages)
        val thirteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.thirteenthAutoCompleteTextView)
        thirteenthAutoCompleteTextView.setAdapter(thirteenthArrayAdapter)
        thirteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 14 Kamera
        val eighteenthLanguages = resources.getStringArray(R.array.cam)
        val eighteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, eighteenthLanguages)
        val eighteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.fifteenthAutoCompleteTextView)
        eighteenthAutoCompleteTextView.setAdapter(eighteenthArrayAdapter)
        eighteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 15 Diagramų sudarymas
        val sixteenthLanguages = resources.getStringArray(R.array.diagramosDarymas)
        val sixteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, sixteenthLanguages)
        val sixteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.sixteenthAutoCompleteTextView)
        sixteenthAutoCompleteTextView.setAdapter(sixteenthArrayAdapter)
        sixteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 16 Veiksmų sękos
        val seventeenthLanguages = resources.getStringArray(R.array.sekosVeiksmu)
        val seventeenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, seventeenthLanguages)
        val seventeenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.seventeenthAutoCompleteTextView)
        seventeenthAutoCompleteTextView.setAdapter(seventeenthArrayAdapter)
        seventeenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 17 Išmanioju telefonu
        val nineteenthLanguages = resources.getStringArray(R.array.isTel)
        val nineteenthArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, nineteenthLanguages)
        val nineteenthAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.eighteenthAutoCompleteTextView)
        nineteenthAutoCompleteTextView.setAdapter(nineteenthArrayAdapter)
        nineteenthAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 18 Planšete
        val twentyLanguages = resources.getStringArray(R.array.planPhone)
        val twentyArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, twentyLanguages)
        val twentyAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.nineteenthAutoCompleteTextView)
        twentyAutoCompleteTextView.setAdapter(twentyArrayAdapter)
        twentyAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 19 Nuotolinis valdymas
        val twentyOneLanguages = resources.getStringArray(R.array.nuotolinisVald)
        val twentyOneArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, twentyOneLanguages)
        val twentyOneAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentiethAutoCompleteTextView)
        twentyOneAutoCompleteTextView.setAdapter(twentyOneArrayAdapter)
        twentyOneAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 20 Išmanūs asistentai
        val twentyTwoLanguages = resources.getStringArray(R.array.isHelpers)
        val twentyTwoArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, twentyTwoLanguages)
        val twentyTwoAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentyfirstAutoCompleteTextView)
        twentyTwoAutoCompleteTextView.setAdapter(twentyTwoArrayAdapter)
        twentyTwoAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 21 Kompiuteriu/naršykle
        val twentyThreeLanguages = resources.getStringArray(R.array.controlPc)
        val twentyThreeArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, twentyThreeLanguages)
        val twentyThreeAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.twentysecondAutoCompleteTextView)
        twentyThreeAutoCompleteTextView.setAdapter(twentyThreeArrayAdapter)
        twentyThreeAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 22 Kokios statybos namas
        val statybosLanguages = resources.getStringArray(R.array.kokiosStatybosNamas)
        val statybosArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, statybosLanguages)
        val statybosAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.statybosautoCompleteTextView)
        statybosAutoCompleteTextView.setAdapter(statybosArrayAdapter)
        statybosAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())
        // 23 Valdymas Bluetooth, internetu
        val valdymasIBLanguages = resources.getStringArray(R.array.valdymasInternetuBluetooth)
        val valdymasIBArrayAdapter = CheckboxAdapter(this, R.layout.checkbox_item, valdymasIBLanguages)
        val valdymasIBAutoCompleteTextView = findViewById<MultiAutoCompleteTextView>(R.id.valdymasInternetuAutoCompleteTextView)
        valdymasIBAutoCompleteTextView.setAdapter(valdymasIBArrayAdapter)
        valdymasIBAutoCompleteTextView.setTokenizer(MultiAutoCompleteTextView.CommaTokenizer())

        // Get the checked state array if needed
        val valdymasIBCheckedStateArray = valdymasIBArrayAdapter.getCheckBoxState()
        val statybosCheckedStateArray = statybosArrayAdapter.getCheckBoxState()
        val twentyThreeCheckedStateArray = twentyThreeArrayAdapter.getCheckBoxState()
        val twentyTwoCheckedStateArray = twentyTwoArrayAdapter.getCheckBoxState()
        val twentyOneCheckedStateArray = twentyOneArrayAdapter.getCheckBoxState()
        val twentyCheckedStateArray = twentyArrayAdapter.getCheckBoxState()
        val nineteenthCheckedStateArray = nineteenthArrayAdapter.getCheckBoxState()
        val eighteenthCheckedStateArray = eighteenthArrayAdapter.getCheckBoxState()
        val seventeenthCheckedStateArray = seventeenthArrayAdapter.getCheckBoxState()
        val sixteenthCheckedStateArray = sixteenthArrayAdapter.getCheckBoxState()
        val thirteenthCheckedStateArray = thirteenthArrayAdapter.getCheckBoxState()
        val twelfthCheckedStateArray = twelfthArrayAdapter.getCheckBoxState()
        val eleventhCheckedStateArray = eleventhArrayAdapter.getCheckBoxState()
        val tenthCheckedStateArray = tenthArrayAdapter.getCheckBoxState()
        val ninthCheckedStateArray = ninthArrayAdapter.getCheckBoxState()
        val eighthCheckedStateArray = eighthArrayAdapter.getCheckBoxState()
        val seventhCheckedStateArray = seventhArrayAdapter.getCheckBoxState()
        val sixthCheckedStateArray = sixthArrayAdapter.getCheckBoxState()
        val fifthCheckedStateArray = fifthArrayAdapter.getCheckBoxState()
        val fourthCheckedStateArray = fourthArrayAdapter.getCheckBoxState()
        val thirdCheckedStateArray = thirdArrayAdapter.getCheckBoxState()
        val secondCheckedStateArray = secondArrayAdapter.getCheckBoxState()
        val checkedStateArray = arrayAdapter.getCheckBoxState()

        val myButton = findViewById<Button>(R.id.ParinktiSprendimaNyptukas) // Replace `yourButtonId` with the actual ID of your button
        myButton.setOnClickListener {
            val intent = Intent(this, KlausimynoPabaigaBinding::class.java)
            startActivity(intent)
        }

        val backButton = findViewById<ImageView>(R.id.AtgalNyptukas)
        backButton.setOnClickListener {
            val intent = Intent(this, FirstPage::class.java)
            startActivity(intent)
        }
    }
}