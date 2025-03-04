package com.alpha.todolist.data.util.adaptor.task

import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.domain.model.task.Task

interface TaskEntityAdaptor {

    fun taskToEntity(task: Task): TaskEntity

    fun entityToTask(entity: TaskEntity): Task

}