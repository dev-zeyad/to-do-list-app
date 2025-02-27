package com.alpha.todolist.domain.model.task

sealed class DateRange {
    data object Today:DateRange()
    data object Yesterday:DateRange()
    data class LastNDaysAgo(val numOfDays: Int):DateRange()
    data class LastNWeeksAgo(val numOfWeeks: Int):DateRange()
    data class LastNMonthsAgo(val numOfMonths: Int):DateRange()
    data class LastNYearsAgo(val numOfYears: Int):DateRange()

}