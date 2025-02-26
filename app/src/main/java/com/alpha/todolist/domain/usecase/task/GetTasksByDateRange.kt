package com.alpha.todolist.domain.usecase.task

import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class GetTasksByDateRange (
    private val repo : TaskRepository
) {
    operator fun invoke(dateRange: LongRange): Flow<List<Task>> {
        return repo.getTasksByDateRange(dateRange)
    }
}