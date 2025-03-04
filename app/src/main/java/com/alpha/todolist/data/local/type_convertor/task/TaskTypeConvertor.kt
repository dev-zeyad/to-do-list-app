package com.alpha.todolist.data.local.type_convertor.task

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskTypeConvertor{
    private val gsonInstance: Gson = Gson()
    @TypeConverter
    fun pairTimerToString(timer: Pair<String?, String?>?): String? {
        return timer?.let { gsonInstance.toJson(timer) }
    }

    @TypeConverter
    fun stringToPairTimer(timerString: String?): Pair<String?, String?>? {
        return timerString?.let {
            val type = object : TypeToken<Pair<Long?, Long?>>() {}.type
            gsonInstance.fromJson(timerString, type)
        }
    }
}