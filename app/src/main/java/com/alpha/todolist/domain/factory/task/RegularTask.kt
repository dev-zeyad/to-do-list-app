package com.alpha.todolist.domain.factory.task

import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.provider.task.CalendarProvider


class RegularTask(
    private val calendarAdaptor: CalendarProvider.CalendarDateAdaptor
) : ITask {

    override var description: String? = null
    override var category: String? = null
    override var timer: String? = null
    override var important: Boolean? = null
    override var colorId: Int? = null
    override var date: Long? = calendarAdaptor.getCalendarAsTimeStamp()

    override fun create(): Task {
        return Task(
            description = description,
            category = Category.categoryNameToCategory(category),
            timer = timer?.split("-")?.let { it.firstOrNull() to it.lastOrNull() },
            important = important,
            colorId = colorId,
            date = calendarAdaptor.timeStampToDate(date)
        )
    }

}










