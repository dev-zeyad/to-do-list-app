package com.alpha.todolist.data.local.database.task

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.alpha.todolist.data.local.dao.task.TaskDao
import com.alpha.todolist.data.local.entity.task.TaskEntity
import com.alpha.todolist.util.Constants

@Database(
    entities = [TaskEntity::class],
    exportSchema = true,
    version = 1
)
@TypeConverters(
    value = [TaskDatabase.TaskConverter::class]
)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun getDao(): TaskDao

    class TaskConverter {

        @TypeConverter
        fun pairTimerToString(timer: Pair<Long?, Long?>?): String? {
            return timer?.let { timerPair ->
                buildString {
                    timerPair.first?.let { starter ->
                        append(starter.toString())
                    } ?: append("null")
                    append("/")
                    timerPair.second?.let { deadline ->
                        append(deadline.toString())
                    } ?: append("null")
                }
            }
        }

        @TypeConverter
        fun stringToPairTimer(timerString: String?): Pair<Long?, Long?>? {
            return timerString?.let { timer ->
                with(timer.split("/")) {
                    Pair(
                        getOrNull(0).takeIf { it != "null" }?.toLong(),
                        getOrNull(1).takeIf { it != "null" }?.toLong()
                    )
                }
            }
        }

    }

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