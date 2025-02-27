package com.alpha.todolist.framework.provider.task

import com.alpha.todolist.domain.model.task.Date
import com.alpha.todolist.domain.model.task.Month
import com.alpha.todolist.domain.provider.task.CalendarProvider
import java.util.Calendar

/**
 *  use only these function and properties
 * val calendar = Calendar.getInstance()
 *
 * calendar.get()
 * calendar.set()
 * calendar.add()
 *
 * WEEK_OF_YEAR	9	The week number of the year
 * DAY_OF_YEAR	58	The day of the year (1–365 or 366 in a leap year)
 * HOUR	2	12-hour format (0-11)
 *
 * YEAR	2025	The current year
 * MONTH	1 (February)	0-based (Jan = 0, Feb = 1, ...)
 * WEEK_OF_MONTH	4	The week number within the month
 * DAY_OF_MONTH	27	The day of the month (1–31)
 * DAY_OF_WEEK	5 (Thursday)	1 = Sunday, 2 = Monday, ..., 7 = Saturday
 * AM_PM	1 (PM)	0 = AM, 1 = PM
 * HOUR_OF_DAY	14	24-hour format (0-23)
 * MINUTE	45	Current minute (0-59)
 * SECOND	30	Current second (0-59)
 * MILLISECOND	123	Milliseconds (0-999)
 * calendar.timeInMillis// Timestamp
 * calendar.time //Thu Feb 27 15:30:45 GMT 2025
 * calendar.time = Date(timestamp)	Convert timestamp to Calendar
 */
class CalendarProviderImpl : CalendarProvider {
    /**
     * A helper function that returns a new Calendar instance with the current system time.
     */
    private fun getCalendarInstance(): Calendar = Calendar.getInstance()

    /**
     *@return This function returns the time range for today.
     * Ex: Output (If today is 27-Feb-2025)
     * Start: 27-Feb-2025 00:00:00
     * End: 27-Feb-2025 23:59:59.999
     */

    override fun getTodayRange(): LongRange {
        val todayStarter: Long = getCalendarInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val todayEnd: Long = getCalendarInstance().apply {
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis

        return todayStarter..todayEnd
    }

    /**
     * @return This function returns the time range for yesterday.
     * Ex: Output (If today is 27-Feb-2025)
     * Start: 26-Feb-2025 00:00:00
     * End: 26-Feb-2025 23:59:59.999
     */
    override fun getYesterdayRange(): LongRange {
        val yesterdayStarter: Long = getCalendarInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val yesterdayEnd: Long = getCalendarInstance().apply {
            add(Calendar.DAY_OF_MONTH, -1)
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis

        return yesterdayStarter..yesterdayEnd
    }

    /**
     * @return This function returns the time range for N days ago.
     * Ex: Output (If numOfDays = 7, assuming today is 27-Feb-2025)
     * Start: 20-Feb-2025 00:00:00
     * End: 20-Feb-2025 23:59:59.999
     */
    override fun getLastNDaysAgoRange(numOfDays: Int): LongRange {
        val dayAgoStarter: Long = getCalendarInstance().apply {
            add(Calendar.DAY_OF_YEAR, -numOfDays)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val dayAgoEnd: Long = getCalendarInstance().apply {
            add(Calendar.DAY_OF_YEAR, -numOfDays)
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis

        return dayAgoStarter..dayAgoEnd
    }

    /**
     * @return This function returns the time range for the same week N ago.
     * Ex: Output (If numOfWeeks = 2, assuming today is 27-Feb-2025)
     * Start: 10-Feb-2025 00:00:00
     * End: 16-Feb-2025 23:59:59.999
     */
    override fun getLastNWeeksAgoRange(numOfWeeks: Int): LongRange {
        val weekAgoStarter: Long = getCalendarInstance().apply {
            add(Calendar.WEEK_OF_YEAR, -numOfWeeks)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val weekAgoEnd: Long = getCalendarInstance().apply {
            add(Calendar.WEEK_OF_YEAR, -numOfWeeks)
            add(Calendar.DAY_OF_YEAR, 6)
            set(Calendar.HOUR_OF_DAY, 23)
            set(Calendar.MINUTE, 59)
            set(Calendar.SECOND, 59)
            set(Calendar.MILLISECOND, 999)
        }.timeInMillis

        return weekAgoStarter..weekAgoEnd
    }

    /**
     * @return the time range for the same day, N months ago.
     * Ex: (If today is 27-Feb-2025, numOfMonths = 3)
     * Start: 27-Nov-2024 00:00:00
     * End: 26-Dec-2024 23:59:59.999
     */
    override fun getLastNMonthsAgoRange(numOfMonths: Int): LongRange {
        val monthAgoStarter: Long = getCalendarInstance().apply {
            add(Calendar.MONTH, -numOfMonths)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val monthAgoEnd: Long = getCalendarInstance().apply {
            add(Calendar.MONTH, -numOfMonths + 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            set(Calendar.SECOND, 0)
            add(Calendar.SECOND, -1)
        }.timeInMillis

        return monthAgoStarter..monthAgoEnd
    }

    /**
     * @return  the time range for the same day, N years ago.
     * Ex: (If today is 27-Feb-2025, numOfYears = 1)
     * Start: 27-Feb-2024 00:00:00
     * End: 26-Mar-2024 23:59:59.999
     */
    override fun getLastNYearsAgoRange(numOfYears: Int): LongRange {
        val yearAgoStarter: Long = getCalendarInstance().apply {
            add(Calendar.YEAR, -numOfYears)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val yearAgoEnd: Long = getCalendarInstance().apply {
            add(Calendar.YEAR, -numOfYears + 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.SECOND, -1)
        }.timeInMillis

        return yearAgoStarter..yearAgoEnd
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
                month = monthCalendarCodeToMonth(calendar.get(Calendar.MONTH)),
                dayOfMonth = get(Calendar.DAY_OF_MONTH),
                hourOfDay = get(Calendar.HOUR_OF_DAY),
                minutesOfDay = get(Calendar.MINUTE),
                secondsOfDay = get(Calendar.SECOND),
                milliSecondsOfDay = get(Calendar.MILLISECOND),
                weekOfMonth = get(Calendar.WEEK_OF_MONTH),
                dayOfWeek = dayOfWeekToName(calendar.get(Calendar.DAY_OF_WEEK)),
                amOrPm = amPmNumToName(calendar.get(Calendar.AM_PM)),
                weekOfYear = get(Calendar.WEEK_OF_YEAR),
                dayOfYear = get(Calendar.DAY_OF_YEAR),
                timeZone = timeZone.displayName
            )
        }
    }




    //todo less polar play code
    private fun monthToMonthCalendarCode(month: Month?): Int? {
        return when (month) {
            Month.JANUARY -> Calendar.JANUARY
            Month.FEBRUARY -> Calendar.FEBRUARY
            Month.MARCH -> Calendar.MARCH
            Month.APRIL -> Calendar.APRIL
            Month.MAY -> Calendar.MAY
            Month.JUNE -> Calendar.JUNE
            Month.JULY -> Calendar.JULY
            Month.AUGUST -> Calendar.AUGUST
            Month.SEPTEMBER -> Calendar.SEPTEMBER
            Month.OCTOBER -> Calendar.OCTOBER
            Month.NOVEMBER -> Calendar.NOVEMBER
            Month.DECEMBER -> Calendar.DECEMBER
            else -> null
        }
    }

    private fun monthCalendarCodeToMonth(month: Int?): Month? {
        return when (month) {
            0 -> Month.JANUARY
            1 -> Month.FEBRUARY
            2 -> Month.MARCH
            3 -> Month.APRIL
            4 -> Month.MAY
            5 -> Month.JUNE
            6 -> Month.JULY
            7 -> Month.AUGUST
            8 -> Month.SEPTEMBER
            9 -> Month.OCTOBER
            10 -> Month.NOVEMBER
            11 -> Month.DECEMBER
            else -> null
        }
    }

    private fun dayOfWeekToName(day: Int): String? {
        return when (day) {
            1 -> "SUNDAY"
            2 -> "MONDAY"
            3 -> "TUESDAY"
            4 -> "WEDNESDAY"
            5 -> "THURSDAY"
            6 -> "FRIDAY"
            7 -> "SATURDAY"
            else -> null
        }
    }
    private fun amPmNumToName(amOrPm: Int): String? {
        return when (amOrPm) {
            0 -> "AM"
            1 -> "PM"
            else -> null
        }
    }
}