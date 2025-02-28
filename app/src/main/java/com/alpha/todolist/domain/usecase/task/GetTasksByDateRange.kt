package com.alpha.todolist.domain.usecase.task

import com.alpha.todolist.domain.model.calendar.DateRange
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.provider.task.CalendarProvider
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksByDateRange(
    private val taskRepo: TaskRepository,
    private val calendarProv: CalendarProvider.CalendarDateRange
) {
    operator fun invoke(dateRange: DateRange): Flow<List<Task>> {

        val calenderRange: LongRange = when (dateRange) {
            is DateRange.LastNDaysAgo -> calendarProv.getLastNDaysAgoRange(numOfDays = dateRange.numOfDays)
            is DateRange.LastNMonthsAgo -> calendarProv.getLastNMonthsAgoRange(numOfMonths = dateRange.numOfMonths)
            is DateRange.LastNWeeksAgo -> calendarProv.getLastNWeeksAgoRange(numOfWeeks = dateRange.numOfWeeks)
            is DateRange.LastNYearsAgo -> calendarProv.getLastNYearsAgoRange(numOfYears = dateRange.numOfYears)
            is DateRange.Today -> calendarProv.getTodayRange()
            is DateRange.Yesterday -> calendarProv.getYesterdayRange()
        }

        return taskRepo.getTasksByDateRange(calenderRange)
    }
}