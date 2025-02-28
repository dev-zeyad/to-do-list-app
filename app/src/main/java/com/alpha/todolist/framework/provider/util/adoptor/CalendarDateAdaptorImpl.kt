package com.alpha.todolist.framework.provider.util.adoptor

import com.alpha.todolist.domain.model.calendar.AmPm
import com.alpha.todolist.domain.model.calendar.Date
import com.alpha.todolist.domain.model.calendar.Month
import com.alpha.todolist.domain.model.calendar.Week
import com.alpha.todolist.domain.provider.task.CalendarProvider
import java.util.Calendar

class CalendarDateAdaptorImpl : CalendarProvider.CalendarDateAdaptor {


    override fun getCalendarAsTimeStamp(): Long {
      return Calendar.getInstance().timeInMillis
    }

    private fun getCalendarInstance(): Calendar {
       return Calendar.getInstance().apply {
           timeInMillis = getCalendarAsTimeStamp()
       }
    }

    override fun dateToTimeStamp(date: Date): Long? {
        return getCalendarInstance().apply {
            val month = monthToMonthCalendarCode(date.month)
            this.set(
                date.year ?: return null,
                month ?: return null,
                date.dayOfMonth ?: return null,
                date.hourOfDay ?: return null,
                date.minutesOfDay ?: return null,
                date.secondsOfDay ?: return null
            )
        }.timeInMillis

    }

    override fun timeStampToDate(timeStamp: Long?): Date? {
        val calendar = getCalendarInstance().apply {
            timeInMillis = timeStamp ?: return null
        }

        return with(calendar) {
            Date(
                year = get(Calendar.YEAR),
                month = Month.monthCodeToMonth(calendar.get(Calendar.MONTH)),
                dayOfMonth = get(Calendar.DAY_OF_MONTH),
                hourOfDay = get(Calendar.HOUR_OF_DAY),
                minutesOfDay = get(Calendar.MINUTE),
                secondsOfDay = get(Calendar.SECOND),
                milliSecondsOfDay = get(Calendar.MILLISECOND),
                weekOfMonth = get(Calendar.WEEK_OF_MONTH),
                dayOfWeek = Week.dayOfWeekToName(calendar.get(Calendar.DAY_OF_WEEK)),
                amOrPm = AmPm.amPmNumToName(calendar.get(Calendar.AM_PM)),
                weekOfYear = get(Calendar.WEEK_OF_YEAR),
                dayOfYear = get(Calendar.DAY_OF_YEAR),
                timeZone = timeZone.displayName
            )
        }
    }

    /**
     * for only for java classes
     * to get the value of static field by its name as string
     *
     * use MyMonths.Companion::class.java.getField() for kotlin classes
     */
    private fun monthToMonthCalendarCode(month: Month?): Int? {
        return month?.let {
            Calendar::class.java.getField(month.name).getInt(null)
        }
    }

}