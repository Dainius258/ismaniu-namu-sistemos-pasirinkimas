package com.example.ismaniu_namu_sistemu_pasirinkimas.utils

import java.io.Serializable
/*
* val selectSolutionButton = findViewById<Button>(R.id.button)
        selectSolutionButton.setOnClickListener {
            // Čia surink visus pasirinkimus iš visų AutoCompleteTextView
            val selectedOptions = getSelectedOptionsFromAllDropdowns()
            // Filtruok sistemas pagal pasirinkimus
            arrayAdapter.recommendHomeSystem(selectedOptions)
            val recommendedSystems: List<HomeSystem> = arrayAdapter.recommendHomeSystem(selectedOptions)
            val intent = Intent(this, ActivityPabaigosPsl::class.java).apply {
                // Here, explicitly cast recommendedSystems as Serializable
                putExtra("filteredSystems", recommendedSystems as Serializable)
                putExtra("selectedFunctions", selectedOptions as Serializable)
            }
            startActivity(intent)
        }*/
data class HomeSystem(
    val name: String,
    val lightfeatures: List<String>,
    val blindfeatures: List<String>,
    val vventiliacijosfeatures: List<String>,
    val scenesfeatures: List<String>,
    val energyfeatures: List<String>,
    val weatherfeatures: List<String>,
    val windowdoorwatchfeatures: List<String>,
    val laikmacioJungikliaifeatures: List<String>,
    val userConfeatures: List<String>,
    val userControlfeatures: List<String>,
    val movementsAndOtherfeatures: List<String>,
    val logicFunfeatures: List<String>,
    val sigfeatures: List<String>,
    val kamerafeatures: List<String>,
    val diagramusudarymasfeatures: List<String>,
    val veiksmusekosfeatures: List<String>,
    val phonecontrolMethods: List<String>,
    val notphonecontrolMethods: List<String>,
    val remoteControl: List<String>,
    val pcControl: List<String>,
    val smartAssistants: List<String>,
    val additionalInfo: String,
    val controllConection: List<String>,
    val statybosHouse: List<String>
): Serializable
val homeSystems = listOf(
    HomeSystem(
        name = "LB MANAGEMENT",
        lightfeatures = listOf("Paprastas jungiklis", "Pritemdoma šviesa"),
        blindfeatures = listOf("Žaliuzės", "langinės", "tentai"),
        vventiliacijosfeatures = emptyList(),
        scenesfeatures = emptyList(),
        energyfeatures = emptyList(),
        weatherfeatures = emptyList(),
        windowdoorwatchfeatures = emptyList(),
        laikmacioJungikliaifeatures = listOf("40 perjungimo kartu", "Astro funkcija"),
        userConfeatures = listOf("Laikmačio programos", "Vieno paspaudimo ryškumas maž. didž ryškumas","Vėlo veikimo funkcijos", "judesio aptikimo zonų apibrėžimas", "Naktinės šviesos funkcijos", "viešbučio funkcija"),
        userControlfeatures = listOf("Vartotojai ir slaptažodžiai"),
        movementsAndOtherfeatures = listOf("Judesio"),
        logicFunfeatures = emptyList(),
        sigfeatures = emptyList(),
        kamerafeatures = emptyList(),
        diagramusudarymasfeatures = emptyList(),
        veiksmusekosfeatures = emptyList(),
        phonecontrolMethods = listOf("iOS", "Android"),
        notphonecontrolMethods = listOf("iOS", "Android"),
        remoteControl = emptyList(),
        smartAssistants = emptyList(),
        pcControl = emptyList(),
        additionalInfo = "LB MANAGEMENT sistema neturi šių funkcijų: ...",
        controllConection  = listOf("Bluetooth"),
        statybosHouse = listOf("Naujos arba atnaujintos statybos", "Esančius projektavimo etape")
    ),
    HomeSystem(
        name = "eNet SMART HOME",
        lightfeatures = listOf("Paprastas jungiklis", "Pritemdoma šviesa Energijos matavimas"),
        blindfeatures = listOf("Žaliuzės", "Langinės", "Tentai"),
        vventiliacijosfeatures = listOf("Radiatoriaus termostatas", "Sienos termostatas", "Katilo termostatas"),
        scenesfeatures = listOf("Scenų valdymas balso kontrole", "Scenų valdymas programėle", "Max 34 scenos"),
        energyfeatures = listOf("Energijos matavimas"),
        weatherfeatures = emptyList(),
        windowdoorwatchfeatures = emptyList(),
        laikmacioJungikliaifeatures = listOf("100 perjungimo kartų", "Astro funkcija"),
        userConfeatures = listOf("Mėgstamiausių funkcijų išsaugojimas", "Scenų taisyklės","Laikmačio programos","Balso aptarnavimas", "Nuotolinė prieiga"),
        userControlfeatures = listOf("Administratorius + vartotojai su galimybę keisti leidimus", "Vartotojai (Be leidimo keitimų)"),
        movementsAndOtherfeatures = listOf("Judesio","Saulės"),
        logicFunfeatures = listOf("Iki 34 loginių funkcijų(AND, OR, XOR, if-then)"),
        sigfeatures = emptyList(),
        kamerafeatures = emptyList(),
        diagramusudarymasfeatures = emptyList(),
        veiksmusekosfeatures = emptyList(),
        phonecontrolMethods = listOf("iOS", "Android"),
        notphonecontrolMethods = listOf("iOS", "Android"),
        remoteControl = listOf("eSmart HOME Remote (nemokamas)"),
        smartAssistants = listOf("Google Assistan", "Amazon Alexa Kompiuteriu/naršykle"),
        pcControl = emptyList(),
        additionalInfo = "eNet SMART HOME sistema neturi šių funkcijų: ...",
        controllConection  = listOf("Internetu"),
        statybosHouse = listOf("Naujos arba atnaujintos statybos", "Esančius projektavimo etape")
    ),
    HomeSystem(
        name = "KNX",
        lightfeatures = listOf("Paprastas jungiklis", "Pritemdoma šviesa", "Šviesos spalva", "Apšvietimo sękos"),
        blindfeatures = listOf("Žaliuzės", "Langinės", "Tentai", "Stoglangiai"),
        vventiliacijosfeatures = listOf("Radiatoriaus termostatas", "Ventiliacijos atvartai", "Katilo termostatas", "Grindų šildymo termostatas"),
        scenesfeatures = listOf("Scenų valdymas balso kontrole", "Scenų valdymas programėle", "Scenų kiekis be limitų"),
        energyfeatures = listOf("Energijos matavimas"),
        weatherfeatures = listOf("Orų prognozės", "Orų stotelė","Taisyklių nustatymas pagal orus"),
        windowdoorwatchfeatures = listOf("Langai", "Durys"),
        laikmacioJungikliaifeatures = listOf("256 perjungimo kartų", "Astro funkcija"),
        userConfeatures = listOf("Scenų taisyklės", "Laikmačio programos", "Balso aptarnavimas", "Nuotolinė prieiga"),
        userControlfeatures = listOf("Administratorius su iki 150 vartotojų su laisvai apibrėžimais leidimais"),
        movementsAndOtherfeatures = listOf("Judesio","Saulės"),
        logicFunfeatures = listOf("Iki 34 loginių funkcijų(AND, OR, XOR, if-then)", "Neriboti if-then loginiai veiksmai", "Counter"),
        sigfeatures = listOf("Elektronio pašto žinutes"),
        kamerafeatures = listOf("Per naršyklę"),
        diagramusudarymasfeatures = listOf("Diagramos"),
        veiksmusekosfeatures = listOf("Individualių veiksmo sekų kūrimas"),
        phonecontrolMethods = listOf("iOS", "Android"),
        notphonecontrolMethods = listOf("iOS", "Android"),
        remoteControl = listOf("JUNG Remote (29e vienkartinis)"),
        smartAssistants = listOf("Google Assistan", "Amazon Alexa"),
        pcControl = listOf("Kompiuteriu/naršykle"),
        additionalInfo = "KNX sistema neturi šių funkcijų: ...",
        controllConection  = listOf("Internetu"),
        statybosHouse = listOf("Esančius projektavimo etape")
    ),
    HomeSystem(
        name = "JUNG Home",
        lightfeatures = listOf("Paprastas jungiklis", "Pritemdoma šviesa"),
        blindfeatures = listOf("Žaliuzės", "Langinės", "Tentai"),
        vventiliacijosfeatures = listOf("Radiatoriaus termostatas", "Grindų šildymo termostatas"),
        scenesfeatures = listOf("Scenų valdymas sienos mygtuku"),
        energyfeatures = listOf("Energijos matavimas"),
        weatherfeatures = emptyList(),
        windowdoorwatchfeatures = emptyList(),
        laikmacioJungikliaifeatures = listOf("40 perjungimo kartų", "Astro funkcija"),
        userConfeatures = listOf("Vieno paspaudimo ryškumas, maž. didž ryškumas", "Mėgstamiausių funkcijų išsaugojimas","Viešbučio funkcija" ,"Laikmačio programos", "Vėlo veikimo funkcijos","aktinės šviesos funkcijos" ,"udesio aptikimo zonų apibrėžimas"),
        userControlfeatures = listOf("Vartotojai ir slaptažodžiai"),
        movementsAndOtherfeatures = listOf("Judesio"),
        logicFunfeatures = emptyList(),
        sigfeatures = emptyList(),
        kamerafeatures = emptyList(),
        diagramusudarymasfeatures = emptyList(),
        veiksmusekosfeatures = emptyList(),
        phonecontrolMethods = listOf("iOS", "Android"),
        notphonecontrolMethods = listOf("iOS", "Android"),
        remoteControl = emptyList(),
        smartAssistants = listOf("Google Assistan", "Amazon Alexa"),
        pcControl = emptyList(),
        additionalInfo = "KNX sistema neturi šių funkcijų: ...",
        controllConection  = listOf("Internetu", "Bluetooth"),
        statybosHouse = listOf("Naujos arba atnaujintos statybos")
    )
)