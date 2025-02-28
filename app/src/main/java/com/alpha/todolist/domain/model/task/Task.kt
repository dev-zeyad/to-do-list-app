package com.alpha.todolist.domain.model.task

import com.alpha.todolist.domain.model.calendar.Date


/**
 * the main data that user will need across the tasks app's feature
 */
data class Task(
    val description : String? = null,
    val category : Category? = null,
    val date : Date? = null,
    /**
     * @param first is the start of task time as 12:30PM format
     * @param second is the deadline of task as 14:30PM format
     */
    val timer : Pair<String?,String?>? = null,
    val important : Boolean? = null,
    val isDone : Boolean? = null,
    val colorId : Int? = null
)
