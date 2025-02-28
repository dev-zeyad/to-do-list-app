package com.alpha.todolist.domain.model.calendar

/**
 * formatted as calendar class api
 */
enum class AmPm {
    AM,
    PM;

    companion object{
         fun amPmNumToName(amOrPm: Int): String? {
            return AmPm.entries.getOrNull(amOrPm)?.name
        }
    }
}