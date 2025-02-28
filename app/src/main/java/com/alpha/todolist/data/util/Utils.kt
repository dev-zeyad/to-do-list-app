package com.alpha.todolist.data.util

import java.util.Locale

object Utils {
    fun stringToCapital(string: String?): String? {
        return string?.lowercase()?.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(locale = Locale.US) else it.toString()
        }
    }

}