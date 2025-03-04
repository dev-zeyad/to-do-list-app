package com.alpha.todolist.domain.command.task.command

interface TaskCommand {
    suspend fun execute()
    suspend fun undo()

}