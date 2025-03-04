package com.alpha.todolist.domain.factory.task

import com.alpha.todolist.domain.model.task.Task

interface ITask{

    var description: String?
    var category: String?
    var timer: String?
    var important: Boolean?
    var colorId: Int?
    var date: Long?

    fun create():Task
}