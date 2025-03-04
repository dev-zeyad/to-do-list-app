package com.alpha.todolist.data.repository.task

import com.alpha.todolist.data.local.dao.task.TaskDao
import com.alpha.todolist.data.util.adaptor.task.TaskEntityAdaptor
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import com.alpha.todolist.domain.observer.task.TaskObservable
import com.alpha.todolist.domain.repository.task.TaskRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class TaskRepositoryImpl(
    private val taskEntityAdaptor: TaskEntityAdaptor,
    private val dao :TaskDao,
    private val observable: TaskObservable
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
            dao.updateTask(task = entity).also {
                if (it > 0) observable.notifyAll(task)
            }
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
            .map { taskEntityList ->
                taskEntityList.map { taskEntity ->
                    taskEntityAdaptor.entityToTask(taskEntity)
                }
            }
            .flowOn(Dispatchers.IO)

    }

    override fun getTasksByDateRange(dateRange: LongRange): Flow<List<Task>> {
        return dao.getTasks(rangeStart = dateRange.first, rangeEnd = dateRange.last)
            .distinctUntilChanged()
            .map { taskEntityList ->
                taskEntityList.map { taskEntity ->
                    taskEntityAdaptor.entityToTask(taskEntity)
                }
            }
            .flowOn(Dispatchers.IO)
    }

}