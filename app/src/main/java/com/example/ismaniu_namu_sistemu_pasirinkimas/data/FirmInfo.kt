package com.example.ismaniu_namu_sistemu_pasirinkimas.data

data class FirmInfo(
    val firmName: String,
    val xFirmTitle: Float,
    val yFirmTitle: Float,
    val photoFirmWidth: Float,
    val photoFirmHeight: Float,
    val linkTexts: List<String>
)