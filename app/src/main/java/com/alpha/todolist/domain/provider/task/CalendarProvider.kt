package com.alpha.todolist.domain.provider.task

import com.alpha.todolist.domain.model.calendar.Date

sealed interface CalendarProvider {


    fun getCalendarAsTimeStamp(): Long

    interface CalendarDateRange : CalendarProvider {
        fun getTodayRange(): LongRange
        fun getYesterdayRange(): LongRange
        fun getLastNDaysAgoRange(numOfDays: Int): LongRange
        fun getLastNWeeksAgoRange(numOfWeeks: Int): LongRange
        fun getLastNMonthsAgoRange(numOfMonths: Int): LongRange
        fun getLastNYearsAgoRange(numOfYears: Int): LongRange

    }


    interface CalendarDateAdaptor : CalendarProvider {
        fun dateToTimeStamp(date: Date): Long?
        fun timeStampToDate(timeStamp: Long?): Date?

    }


}