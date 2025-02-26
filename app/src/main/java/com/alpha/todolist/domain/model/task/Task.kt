package com.alpha.todolist.domain.model.task


/**
 * the main data that user will need across the tasks app's feature
 */
data class Task(
    val description : String? = null,
    val category : Category? = null,
        val date : Long? = null,
    /**
     * @param first is the start of task time
     * @param second is the deadline of task
     */
    val timer : Pair<Long?,Long?>? = null,
    val important : Boolean? = null,
    val isDone : Boolean? = null,
    val colorId : Int? = null
)
