package com.alpha.todolist.domain.observer.task;

import com.alpha.todolist.domain.model.task.Task;

public interface TaskObserver {
    void onTaskUpdate(Task task);
}
