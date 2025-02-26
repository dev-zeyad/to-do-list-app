package com.alpha.todolist.domain.usecase.manager

import com.alpha.todolist.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class CheckDarkThemeSelectedUseCase(
    private val manager : LocalUserManager
) {
    operator fun invoke() :Flow<Boolean> {
        return manager.isDarkThemeSelected()
    }
}