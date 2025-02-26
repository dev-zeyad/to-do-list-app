package com.alpha.todolist.domain.usecase.task

import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository

class AddNewTaskUseCase(
    private val repo : TaskRepository
) {
    suspend operator fun invoke(task: Task):Long{
       return repo.addNewTask(task)
    }
}