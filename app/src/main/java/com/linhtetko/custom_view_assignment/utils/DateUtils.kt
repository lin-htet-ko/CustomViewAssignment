package com.linhtetko.custom_view_assignment.utils

import java.text.SimpleDateFormat
import java.util.*

fun getToday(): String {
    val sdf = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
    return sdf.format(Date())
}

fun getPreviousOneYear(): kotlin.collections.List<String>{
    val dates = mutableListOf<String>()
    val sdf = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
    for (i in 0 downTo -365){
        val date = Calendar.getInstance()
        date.add(Calendar.DATE, i)
        dates.add(sdf.format(date.time))
    }
    return dates
}
fun getNextOneYear(): List<String>{
    val dates = mutableListOf<String>()
    val sdf = SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault())
    for (i in 0..365){
        val date = Calendar.getInstance()
        date.add(Calendar.DATE, i)
        dates.add(sdf.format(date.time))
    }
    return dates
}

fun main() {
    println(getPreviousOneYear().reversed())
}