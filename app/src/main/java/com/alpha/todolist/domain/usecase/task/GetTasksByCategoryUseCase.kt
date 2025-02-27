package com.alpha.todolist.domain.usecase.task

import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksByCategoryUseCase(
    private val taskRepo : TaskRepository
) {
    operator fun invoke(category: Category): Flow<List<Task>> {
        return taskRepo.getTasksByCategory(category)
    }
}