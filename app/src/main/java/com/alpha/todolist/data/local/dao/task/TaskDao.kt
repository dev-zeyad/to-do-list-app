package com.alpha.todolist.data.local.dao.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.domain.model.task.Category
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity): Long

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTask(task: TaskEntity): Int

    @Delete
    suspend fun delete(task: TaskEntity): Int


    @Query("SELECT * FROM task_table WHERE category LIKE :category")
    fun getTasks(category: Category): Flow<List<TaskEntity>>


    @Query("SELECT * FROM task_table WHERE date BETWEEN :rangeStart AND :rangeEnd")
    fun getTasks(rangeStart:Long, rangeEnd:Long): Flow<List<TaskEntity>>

}