package com.lazday.news.util

import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    fun dateFormat(date:String?):String
    {
        return if(date.isNullOrEmpty()) {
            ""
        }
        else {
            val currentDate = SimpleDateFormat("yyyy-MM-dd'T'HH:MM:SS'Z'",Locale.getDefault())
            val dataParse = currentDate.parse(date)
            val toFormat = SimpleDateFormat("MMM, dd yy",Locale.getDefault())
            toFormat.format(dataParse)
        }
    }

}