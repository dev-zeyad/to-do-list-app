package com.alpha.todolist.domain.repository.task

import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    /**
     * add new task to tasks database table
     * @return the id of the new task in the task table
     */
    suspend fun addNewTask(task: Task): Long

    /**
     * update task in tasks database table in which make it done or update one or more of its properties
     * @return the id of the updated task in the task table
     */
    suspend fun updateTask(task: Task): Int

    /**
     * delete task in tasks database table
     * @return the id of the updated task in the task table
     */
    suspend fun deleteTask(task: Task): Int


    /**
     * get tasks by match the category param with rows in the tables otherwise emptyList
     * @return flow of list of latest tasks
     * @param category the category of the task
     */
    fun getTasksByCategory(category: Category): Flow<List<Task>>



    /**
     * get tasks by match the date param with rows in the tables otherwise emptyList
     * @return flow of list of latest tasks
     * @param date the date of the task
     */
    fun getTasksByDateRange(dateRange: LongRange): Flow<List<Task>>

}