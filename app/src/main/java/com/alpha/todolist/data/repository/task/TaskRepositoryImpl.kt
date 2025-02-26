package com.alpha.todolist.data.repository.task

import android.content.Context
import com.alpha.todolist.data.local.database.task.TaskDatabase
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(
    private val context: Context
) : TaskRepository {

    private val dao = TaskDatabase.getInstance(context)

    override suspend fun addNewTask(task: Task): Long {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task): Int {
        TODO("Not yet implemented")
    }

    override suspend fun deleteTask(task: Task): Int {
        TODO("Not yet implemented")
    }

    override fun getTasksByCategory(category: Category): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

    override fun getTasksByDateRange(dateRange: LongRange): Flow<List<Task>> {
        TODO("Not yet implemented")
    }

}