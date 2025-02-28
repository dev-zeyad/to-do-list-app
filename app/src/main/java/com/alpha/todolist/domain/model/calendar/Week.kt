package com.alpha.todolist.domain.model.calendar

/**
 * formatted as calendar class api
 */
enum class Week {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
    companion object{
        fun dayOfWeekToName(dayCode: Int): String? {
            return Week.entries.getOrNull(dayCode)?.name
        }
    }
}