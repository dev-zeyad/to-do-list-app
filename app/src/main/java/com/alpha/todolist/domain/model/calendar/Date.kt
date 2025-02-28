package com.alpha.todolist.domain.model.calendar

/**
 * formatted as calendar class api
 */
data class Date(
    /**
     * ex:2025
     */
    val year: Int? = null,
    /**
     * ex:March
     */
    val month: Month? = null,
    /**
     * ex:3
     */
    val dayOfMonth: Int? = null,
    /**
     * ex:14
     */
    val hourOfDay: Int? = null,
    /**
     * ex:32
     */
    val minutesOfDay: Int? = null,
    /**
     * ex:49
     */
    val secondsOfDay: Int? = null,
    /**
     * ex:449
     */
    val milliSecondsOfDay: Int? = null,
    /**
     * ex:3
     */
    val weekOfMonth: Int? = null,
    /**
     * ex:sunday
     */
    val dayOfWeek: String? = null,
    /**
     * ex:PM
     */
    val amOrPm: String? = null,
    /**
     * ex:8
     */
    val weekOfYear: Int? = null,
    /**
     * ex:229
     */
    val dayOfYear: Int? = null,

    val timeZone : String? = null
)












