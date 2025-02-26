package com.alpha.todolist.domain.usecase.manager

import com.alpha.todolist.domain.manager.LocalUserManager

class SelectDarkThemeUseCase(
    private val manager: LocalUserManager
) {
   suspend operator fun invoke() {
        manager.selectDarkTheme()
   }
}