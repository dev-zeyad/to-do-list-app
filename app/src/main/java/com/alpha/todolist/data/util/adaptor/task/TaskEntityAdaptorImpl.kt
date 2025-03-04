package com.alpha.todolist.data.util.adaptor.task

import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.data.util.Utils
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.provider.task.CalendarProvider

class TaskEntityAdaptorImpl(
    private val calendarProvider: CalendarProvider.CalendarDateAdaptor
) : TaskEntityAdaptor {
   override fun taskToEntity(task: Task): TaskEntity {
        return TaskEntity(
            description = task.description,
            category = Utils.stringToCapital(task.category?.name),
            date = task.date?.let {
                calendarProvider.dateToTimeStamp(it)
            },
            timer = task.timer?.first to task.timer?.second,
            important = task.important,
            isDone = task.isDone,
            colorId = task.colorId
        )
   }

    override fun entityToTask(entity: TaskEntity): Task {

        return Task(
            description = entity.description,
            category = Category.categoryNameToCategory(entity.category),
            date = calendarProvider.timeStampToDate(entity.date),
            timer = entity.timer?.first to entity.timer?.second,
            important = entity.important,
            isDone = entity.isDone,
            colorId = entity.colorId
        )

    }

}

