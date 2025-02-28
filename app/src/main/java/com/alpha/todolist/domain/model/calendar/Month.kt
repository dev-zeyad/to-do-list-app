package com.alpha.todolist.domain.model.calendar

/**
 * formatted as calendar class api
 */
enum class Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;
    companion object {
        fun monthCodeToMonth(monthCode: Int): Month? {
            return Month.entries.getOrNull(monthCode)
        }

    }
}