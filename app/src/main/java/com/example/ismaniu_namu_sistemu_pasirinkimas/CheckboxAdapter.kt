package com.example.ismaniu_namu_sistemu_pasirinkimas

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox

class CheckboxAdapter(context: Context, resource: Int, objects: Array<String>) :
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
        checkBox.text = getItem(position)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            checkBoxState[position] = isChecked
        }
        return rowView
    }

    fun getCheckBoxState(): BooleanArray {
        return checkBoxState
    }
}
