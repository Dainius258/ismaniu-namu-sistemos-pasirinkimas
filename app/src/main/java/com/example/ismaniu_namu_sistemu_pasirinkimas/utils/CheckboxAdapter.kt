package com.example.ismaniu_namu_sistemu_pasirinkimas.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.Toast
import com.example.ismaniu_namu_sistemu_pasirinkimas.R

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
    fun getSelectedOptions(): List<String> {
        val selectedOptions = mutableListOf<String>()
//Funkcija gauna duomenis is vartotojo pasirinkimu dropdown sarase (kai pazymi reikiama namo funkcijija yra pridedama namo funkcijos pavadinimas
// i pasiriktu variantu sarasa
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
    /*
    * Nudojant getSelectedOptions kad surinktu visus vartotojo pasirinktus variantus.
    * Kiekvienai programoje apibreztai namu sistemai apskaiciuoja kiek pasirinktu funkciju kiekviena sistema palaiko
    *    naudojant supportsFeature funkcija.
    * Sistemos reitinguojamos pagal atitikmenu skaiciu. Sistemos rusiuojamos pagal ju atitikimu skaiciu uztikrinant kad sistemos
    *    palaikancios daugiau  pageidaujamu funkciju butu suteikiamos pirmenybe.
    * */
    fun recommendHomeSystem(getSelectedOptions: List<String>): List<HomeSystem> {
        // Laikykime kiekvienos sistemos atitikimų skaičių
        val systemMatches = homeSystems.associateWith { system ->
            getSelectedOptions.count { option -> system.supportsFeature(option) }
        }
        // Rūšiuojame sistemas pagal atitikimų skaičių mažėjančia tvarka
        val sortedSystems = systemMatches.toList().sortedByDescending { (_, value) -> value }
        // Jei aukščiausias atitikimų skaičius yra didesnis nei 0, išrenkame sistemas, kurios turi aukščiausią atitikimų skaičių
        val highestMatchCount = sortedSystems.firstOrNull()?.second ?: 0
        if (highestMatchCount > 0) {
            return sortedSystems.takeWhile { it.second == highestMatchCount }.map { it.first }
        }
        // Jeigu nė viena sistema nepasiekia reikiamo atitikimo, grąžiname tuščią sąrašą arba galime grąžinti sistemas su bent keliais atitikimais
        return emptyList()
    }

    private fun HomeSystem.supportsFeature(feature: String): Boolean {
        // Apjungiamos visos palaikomu funkciju kategorijos i vieną sarasa patikrinimui
        //Nustato ar tam tikra HomeSystem sistema palaiko konkrecia funkcija
        val allFeatures = lightfeatures + blindfeatures + vventiliacijosfeatures + scenesfeatures + energyfeatures +
                weatherfeatures + windowdoorwatchfeatures + laikmacioJungikliaifeatures + userConfeatures +
                userControlfeatures + movementsAndOtherfeatures + logicFunfeatures + sigfeatures +
                kamerafeatures + diagramusudarymasfeatures + veiksmusekosfeatures + phonecontrolMethods +
                notphonecontrolMethods + remoteControl + pcControl + smartAssistants + listOf(additionalInfo) + controllConection
        return feature in allFeatures
    }
}