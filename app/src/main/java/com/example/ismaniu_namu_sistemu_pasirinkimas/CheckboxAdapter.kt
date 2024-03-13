package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Toast

class CheckboxAdapter(context: Context, resource: Int, objects: Array<String>):
    ArrayAdapter<String>(context, resource, objects) {
    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private var checkBoxState = booleanArrayOf()
    init {
        checkBoxState = BooleanArray(objects.size)
    }
    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.checkbox_item, parent, false)
        val checkBox = rowView.findViewById<CheckBox>(R.id.checkBox)
        checkBox.text = getItem(position) ?: ""
        checkBox.isChecked = checkBoxState[position]
        // Pasirinkti namu sistema pagal nustatymus
        val systemSpec = getItem(position) ?: ""
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            checkBoxState[position] = isChecked
            if (isChecked) {
                // Jei pasirinkta, atvaizduoti sistemaSpec
                showMessageToUser(systemSpec)
            }
        }
        return rowView
    }
    // Funkcija, kuri pagal vartotojo pasirinkimus sprendzia kuri namu sistema yra rekomenduojama
    private fun determineRecommendedSystem(selectedOptions: List<String>): HomeSystem? {
        // iesko geriausios namu sistemos pagal vartotojo pasirinkimus
        // eina per visu namu sistemu sarasa , skaiciuoja kuri sistema palaiko daugiausiai pasirinktu funkciju
        var bestSystem: HomeSystem? = null
        var bestSupportedFeaturesCount = 0
        // Einame per kiekvieną namu sistemą ir tikrint kiek funkciju ji palaiko iš vartotojo pasirinkimų
        for (system in homeSystems) {
            val supportedFeaturesCount = countSupportedFeatures(system, selectedOptions)
            // Jei si sistema palaiko daugiau pasirinktu funkcijų, ja laikit geriausia
            if (supportedFeaturesCount > bestSupportedFeaturesCount) {
                bestSupportedFeaturesCount = supportedFeaturesCount
                bestSystem = system
            }
        }
        // Gražint geriausios sisemos objekta
        return bestSystem
    }
    private fun countSupportedFeatures(system: HomeSystem, selectedOptions: List<String>): Int {
        // skaiciuoja kiek funkcijų is vartotojo pasirinkimų palaiko ši sistema
        var supportedFeaturesCount = 0 //pasirinktu funkciju palaiko si konkreciu namu sistemu versija
        for (option in selectedOptions) { // eita per kiekviena vartotojo pasirinktą funkciją
            when (option) {
                //tikrina kiekviena pasirinkta funkcija ir tikrina ar ji yra palaikoma  HomeSystem.  funkcija yra palaikoma supportedFeaturesCount padidinamas.
                in system.lightfeatures -> supportedFeaturesCount++
                in system.blindfeatures -> supportedFeaturesCount++
                in system.vventiliacijosfeatures -> supportedFeaturesCount++
                in system.scenesfeatures -> supportedFeaturesCount++
                in system.energyfeatures -> supportedFeaturesCount++
                in system.weatherfeatures -> supportedFeaturesCount++
                in system.windowdoorwatchfeatures -> supportedFeaturesCount++
                in system.laikmacioJungikliaifeatures -> supportedFeaturesCount++
                in system.userConfeatures -> supportedFeaturesCount++
                in system.userControlfeatures -> supportedFeaturesCount++
                in system.movementsAndOtherfeatures -> supportedFeaturesCount++
                in system.logicFunfeatures -> supportedFeaturesCount++
                in system.sigfeatures -> supportedFeaturesCount++
                in system.kamerafeatures -> supportedFeaturesCount++
                in system.diagramusudarymasfeatures -> supportedFeaturesCount++
                in system.veiksmusekosfeatures -> supportedFeaturesCount++
                in system.phonecontrolMethods -> supportedFeaturesCount++
                in system.notphonecontrolMethods -> supportedFeaturesCount++
                in system.remoteControl -> supportedFeaturesCount++
                in system.pcControl -> supportedFeaturesCount++
                in system.smartAssistants -> supportedFeaturesCount++
                in system.additionalInfo -> supportedFeaturesCount++
                "Valdymas Bluetooth" -> {
                    if (system.name == "LB MANAGEMENT" || system.name == "JUNG Home") {
                        supportedFeaturesCount++
                    }
                }
            }
        }
        return supportedFeaturesCount
    }
    fun getSelectedOptions(): List<String> {
        val selectedOptions = mutableListOf<String>()

        for (i in checkBoxState.indices) {
            if (checkBoxState[i]) {
                selectedOptions.add(getItem(i) ?: "")
            }
        }
        return selectedOptions
    }
    // funkcija kuri rodo pranesima
    private fun showMessageToUser(message: String) {
        // rodo pranesima vartotojui
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
    fun recommendHomeSystem(selectedOptions: List<String>): ArrayList<HomeSystem> {
        val recommendedSystems = ArrayList<HomeSystem>()

        // Iterate through each system and check if it supports all selected options.
        homeSystems.forEach { system ->
            if (doesSystemSupportAllSelectedOptions(system, selectedOptions)) {
                recommendedSystems.add(system)
            }
        }
        if (recommendedSystems.isNotEmpty()) {
            recommendedSystems.forEach { system ->
                Log.d("CheckboxAdapter", "Sistema atitinkanti visus pasirinkimus: ${system.name}")
            }
        } else {
            Log.d("CheckboxAdapter", "Nerasta sistemų atitinkančių visus pasirinkimus")
        }

        return recommendedSystems
    }
    // Tikrinti kiekvieną vartotojo pasirinkimą ir patikrinti ar palaikomas rekomenduojama sistemai
    private fun doesSystemSupportAllSelectedOptions(system: HomeSystem, selectedOptions: List<String>): Boolean {
        return selectedOptions.all { option ->
            when (option) {
                in system.lightfeatures -> true
                in system.blindfeatures -> true
                in system.vventiliacijosfeatures -> true
                in system.scenesfeatures -> true
                in system.energyfeatures -> true
                in system.weatherfeatures -> true
                in system.windowdoorwatchfeatures -> true
                in system.laikmacioJungikliaifeatures -> true
                in system.userConfeatures -> true
                in system.userControlfeatures -> true
                in system.movementsAndOtherfeatures -> true
                in system.logicFunfeatures -> true
                in system.sigfeatures -> true
                in system.kamerafeatures -> true
                in system.diagramusudarymasfeatures -> true
                in system.veiksmusekosfeatures -> true
                in system.phonecontrolMethods -> true
                in system.notphonecontrolMethods -> true
                in system.remoteControl -> true
                in system.pcControl -> true
                in system.smartAssistants -> true
                in system.additionalInfo -> true
                "Valdymas Bluetooth" -> system.name == "LB MANAGEMENT" || system.name == "JUNG Home"
                else -> false
            }
        }
    }
    private fun showOtherRecommendedSystems(recommendedSystem: HomeSystem, selectedOptions: List<String>) {
        // perziuri su reikiamom funkcijom sistemas
        for (system in homeSystems) {

            if (system != recommendedSystem) {
                val commonFeatures = findCommonFeatures(system, selectedOptions)

                if (commonFeatures.isNotEmpty()) {
                    Log.d("tag", "Kitos sistemos su panašiomis funkcijomis: ${system.name}, Palaikomos funkcijos: $commonFeatures")
                }
            }
        }
    }
    private fun findCommonFeatures(system: HomeSystem, selectedOptions: List<String>): List<String> {
        // suranda dalykus sistemose
        return selectedOptions.filter { option ->
            when (option) {
                in system.lightfeatures,
                in system.lightfeatures,
                in system.blindfeatures,
                in system.vventiliacijosfeatures,
                in system.scenesfeatures,
                in system.energyfeatures,
                in system.weatherfeatures,
                in system.windowdoorwatchfeatures,
                in system.laikmacioJungikliaifeatures,
                in system.userConfeatures,
                in system.userControlfeatures,
                in system.movementsAndOtherfeatures,
                in system.logicFunfeatures,
                in system.sigfeatures,
                in system.kamerafeatures,
                in system.diagramusudarymasfeatures,
                in system.veiksmusekosfeatures,
                in system.phonecontrolMethods,
                in system.notphonecontrolMethods,
                in system.remoteControl,
                in system.pcControl,
                in system.smartAssistants,
                in system.additionalInfo,
                "Valdymas Bluetooth" -> system.name == "LB MANAGEMENT" || system.name == "JUNG Home"
                else -> false
            }
        }
    }
}