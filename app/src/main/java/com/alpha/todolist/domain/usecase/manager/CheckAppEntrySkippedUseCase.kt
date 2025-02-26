package com.alpha.todolist.domain.usecase.manager

import com.alpha.todolist.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class CheckAppEntrySkippedUseCase (
    private val manager : LocalUserManager
) {
    operator fun invoke() : Flow<Boolean> {
        return manager.isAppEntrySkipped()
    }
}