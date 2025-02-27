package com.alpha.todolist.data.local.type_convertor.task

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TaskTypeConvertor {

    //when add dagger hilt, inject this property
    private val gsonInstance: Gson = Gson()

    @TypeConverter
    fun pairTimerToString(timer: Pair<Long?, Long?>?): String? {
        return timer?.let { gsonInstance.toJson(timer) }
    }

    @TypeConverter
    fun stringToPairTimer(timerString: String?): Pair<Long?, Long?>? {
        return timerString?.let {
            val type = object : TypeToken<Pair<Long?, Long?>>() {}.type
            gsonInstance.fromJson(timerString, type)
        }
    }
}