package com.alpha.todolist.data.repository.task

import com.alpha.todolist.data.local.dao.task.TaskDao
import com.alpha.todolist.data.util.adaptor.task.TaskEntityAdaptor
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TaskRepositoryImpl(
    private val taskEntityAdaptor: TaskEntityAdaptor,
    private val dao :TaskDao
) : TaskRepository {

    override suspend fun addNewTask(task: Task): Long {
        return withContext(Dispatchers.IO) {
            val entity = taskEntityAdaptor.taskToEntity(task = task)
            dao.insertTask(task = entity)
        }
    }

    override suspend fun updateTask(task: Task): Int {
        return withContext(Dispatchers.IO) {
            val entity = taskEntityAdaptor.taskToEntity(task = task)
            dao.updateTask(task = entity)
        }
    }

    override suspend fun deleteTask(task: Task): Int {
        return withContext(Dispatchers.IO) {
            val entity = taskEntityAdaptor.taskToEntity(task = task)
            dao.delete(task = entity)
        }
    }

    override fun getTasksByCategory(category: Category): Flow<List<Task>> {
        return dao.getTasks(category = category)
            .distinctUntilChanged()
            .map { taskEntityAdaptor.tasksToEntities(it) }
            .flowOn(Dispatchers.IO)

    }

    override fun getTasksByDateRange(dateRange: LongRange): Flow<List<Task>> {
        return dao.getTasks(dateRange = dateRange)
            .distinctUntilChanged()
            .map { taskEntityAdaptor.tasksToEntities(it) }
            .flowOn(Dispatchers.IO)
    }

}