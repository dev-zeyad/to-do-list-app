package com.alpha.todolist.domain.model.task

/**
 * specify the category of the new task
 */
enum class Category {
    WORK,
    FUN,
    HOME,
    SCHOOL;

    companion object {
        fun categoryNameToCategory(name: String?): Category? {
            return  name?.let {
                Category.entries.firstOrNull {
                    it.name == name.uppercase()
                }
            }
        }
    }
}
