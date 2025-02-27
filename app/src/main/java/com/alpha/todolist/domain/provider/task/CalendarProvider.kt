package com.alpha.todolist.domain.provider.task

import com.alpha.todolist.domain.model.task.Date

interface CalendarProvider {
    fun getTodayRange():LongRange
    fun getYesterdayRange():LongRange
    fun getLastNDaysAgoRange(numOfDays: Int):LongRange
    fun getLastNWeeksAgoRange(numOfWeeks: Int):LongRange
    fun getLastNMonthsAgoRange(numOfMonths: Int):LongRange
    fun getLastNYearsAgoRange(numOfYears: Int):LongRange
    fun dateToTimeStamp(date:Date):Long?
    fun timeStampToDate(timeStamp:Long?):Date?


}