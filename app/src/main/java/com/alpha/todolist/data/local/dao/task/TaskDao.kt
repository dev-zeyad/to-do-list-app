package com.alpha.todolist.data.local.dao.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alpha.todolist.domain.model.task.Category
import com.alpha.todolist.domain.model.task.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: Task): Int

    @Delete
    suspend fun delete(task: Task): Int


    @Query("SELECT * FROM task_table WHERE category LIKE :category")
    fun getTasks(category: Category): Flow<List<Task>>


    @Query("SELECT * FROM task_table WHERE date IN (:dateRange)")
    fun getTasks(dateRange: LongRange): Flow<List<Task>>

}