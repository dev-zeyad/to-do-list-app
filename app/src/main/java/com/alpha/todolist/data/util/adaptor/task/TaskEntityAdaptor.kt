package com.alpha.todolist.data.util.adaptor.task

import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.provider.task.CalendarProvider
import java.util.Locale

class TaskEntityAdaptor(
    private val calendarProvider: CalendarProvider
) {
    fun taskToEntity(task: Task): TaskEntity {
        return TaskEntity(
            description = task.description,
            category = task.category?.name?.lowercase()?.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(locale = Locale.US) else it.toString()
            },
            date = task.date?.let {
                calendarProvider.dateToTimeStamp(it)
            },
            timer = task.timer?.first to task.timer?.second,
            important = task.important,
            isDone = task.isDone,
            colorId = task.colorId
        )
    }

    private fun entityToTask(entity: TaskEntity): Task {

        val category = when (entity.category.toString().uppercase()) {
            Category.FUN.name -> Category.FUN
            Category.HOME.name -> Category.HOME
            Category.SCHOOL.name -> Category.SCHOOL
            Category.WORK.name -> Category.WORK
            else -> null
        }

        return Task(
            description = entity.description,
            category = category,
            date = calendarProvider.timeStampToDate(entity.date),
            timer = entity.timer?.first to entity.timer?.second,
            important = entity.important,
            isDone = entity.isDone,
            colorId = entity.colorId
        )

    }


    fun tasksToEntities(tasks: List<TaskEntity>): List<Task> {
        return tasks.map {
            entityToTask(it)
        }
    }
}