package com.alpha.todolist.domain.factory.task

import com.alpha.todolist.domain.provider.task.CalendarProvider

class TaskFactory(
    private val calendarAdaptor : CalendarProvider.CalendarDateAdaptor
) {
    fun create(taskType: TaskType):ITask{
        return when(taskType){
            TaskType.REGULAR -> RegularTask(calendarAdaptor = calendarAdaptor)
        }
    }
}