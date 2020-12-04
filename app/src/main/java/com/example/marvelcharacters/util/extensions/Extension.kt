package com.example.marvelcharacters.util

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getDate(): String {
    try {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
        val currentDate: String = simpleDateFormat.format(Date())
        return currentDate
    } catch (e: Exception) {
        return e.toString()
    }

}


