package com.alpha.todolist.domain.command.task

import com.alpha.todolist.domain.command.task.command.DeleteTaskCommand
import com.alpha.todolist.domain.command.task.command.TaskCommand

class TaskCommandInvoker {

    private val taskCommandHistory = mutableListOf<TaskCommand>()

    suspend fun execute(command: TaskCommand){
        command.execute()
        taskCommandHistory.add(command)
    }

    suspend fun undo(){
        taskCommandHistory.removeLastOrNull()
            ?.undo()
    }

}