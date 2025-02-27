package com.alpha.todolist.data.local.database.task

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.alpha.todolist.data.local.dao.task.TaskDao
import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.data.local.type_convertor.task.TaskTypeConvertor
import com.alpha.todolist.data.util.values.Constants

@Database(
    entities = [TaskEntity::class],
    exportSchema = true,
    version = 1
)
@TypeConverters(
    value = [TaskTypeConvertor::class]
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getDao(): TaskDao

    companion object {
        @Volatile
        private var _instance: TaskDatabase? = null

        private fun buildTaskDatabase(context: Context): TaskDatabase {
            return synchronized(this) {
                Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = TaskDatabase::class.java,
                    name = Constants.TASK_DATABASE_NAME
                ).build()
            }
        }

        fun getInstance(context: Context): TaskDatabase {
            return _instance ?: buildTaskDatabase(context).also {
                _instance = it
            }
        }

    }
}