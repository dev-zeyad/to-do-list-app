package com.alpha.todolist.data.local.entity.task

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "task_table",
    indices = [Index("category"),Index("date")]
)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id : Long = 0,
    val description : String? = null,
    val category : String? = null,
    val date : Long? = null,
    /**
     * create typeConverter
     * @param first is the start of task time
     * @param second is the deadline of task
     */
    val timer : Pair<String?,String?>? = null,
    val important : Boolean? = null,
    val isDone : Boolean? = null,
    val colorId : Int? = null

)
