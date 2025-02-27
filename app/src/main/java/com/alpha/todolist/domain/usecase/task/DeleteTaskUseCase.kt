package com.alpha.todolist.domain.usecase.task

import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository

class DeleteTaskUseCase(
    private val taskRepo : TaskRepository
) {
    suspend operator fun invoke(task: Task):Int{
        return taskRepo.deleteTask(task)
    }
}