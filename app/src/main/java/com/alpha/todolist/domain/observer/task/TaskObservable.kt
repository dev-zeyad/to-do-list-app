package com.alpha.todolist.domain.observer.task

import com.alpha.todolist.domain.model.task.Task

class TaskObservable {

    private val subscribers = mutableListOf<TaskObserver>()

    fun subscribe(taskObserver: TaskObserver){
        subscribers.add(taskObserver)
    }
    fun unSubscribe(taskObserver: TaskObserver){
        subscribers.remove(taskObserver)
    }

    fun notifyAll(task:Task){
        subscribers.forEach { subscriber ->
            subscriber.onTaskUpdate(task)
        }
    }

}