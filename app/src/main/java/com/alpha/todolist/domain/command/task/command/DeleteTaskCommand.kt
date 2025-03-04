package com.alpha.todolist.domain.command.task.command

import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository

class DeleteTaskCommand(
    private val taskRepo: TaskRepository,
    private val task: Task
) :TaskCommand {

    override suspend fun execute() {
       taskRepo.deleteTask(task)
    }

    override suspend fun undo() {
        taskRepo.addNewTask(task)
    }
}