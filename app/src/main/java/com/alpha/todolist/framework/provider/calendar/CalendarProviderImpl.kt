package com.alpha.todolist.framework.provider.calendar

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
class CalendarProviderImpl : CalendarProvider.CalendarDateRange {
    /**
     * A helper function that returns a new Calendar instance with the current system time.
     */

    override fun getCalendarAsTimeStamp(): Long {
       return Calendar.getInstance().timeInMillis
    }

    private fun getCalendarInstance(): Calendar {
        return Calendar.getInstance().apply {
            timeInMillis = getCalendarAsTimeStamp()
        }
    }

    /**
     *@return This function returns the time range for today.
     * Ex: Output (If today is 27-Feb-2025)
     * Start: 27-Feb-2025 00:00:00
     * End: 27-Feb-2025 23:59:59.999
     */

    override fun getTodayRange(): LongRange {
        
        val currentDate = getCalendarInstance()
        
        val todayStarter: Long = currentDate.apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val todayEnd: Long = currentDate.apply {
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
        
        val currentDate = getCalendarInstance()

        val yesterdayStarter: Long = currentDate.apply {
            add(Calendar.DAY_OF_MONTH, -1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val yesterdayEnd: Long = currentDate.apply {
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
        
        val currentDate = getCalendarInstance()

        val dayAgoStarter: Long = currentDate.apply {
            add(Calendar.DAY_OF_YEAR, -numOfDays)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val dayAgoEnd: Long = currentDate.apply {
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

        val currentDate = getCalendarInstance()

        val weekAgoStarter: Long = currentDate.apply {
            add(Calendar.WEEK_OF_YEAR, -numOfWeeks)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val weekAgoEnd: Long = currentDate.apply {
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
        
        val currentDate = getCalendarInstance()
        
        val monthAgoStarter: Long = currentDate.apply {
            add(Calendar.MONTH, -numOfMonths)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val monthAgoEnd: Long = currentDate.apply {
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

        val currentDate = getCalendarInstance()

        val yearAgoStarter: Long = currentDate.apply {
            add(Calendar.YEAR, -numOfYears)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.timeInMillis

        val yearAgoEnd: Long = currentDate.apply {
            add(Calendar.YEAR, -numOfYears + 1)
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
            add(Calendar.SECOND, -1)
        }.timeInMillis

        return yearAgoStarter..yearAgoEnd
    }

}