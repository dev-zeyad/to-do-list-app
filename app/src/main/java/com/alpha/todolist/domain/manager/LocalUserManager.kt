package com.alpha.todolist.domain.manager

import kotlinx.coroutines.flow.Flow

interface LocalUserManager {

    /**
     * @return true if user selected dark theme as app default otherwise false
     */
    fun isDarkThemeSelected():Flow<Boolean>

    /**
     * select dark theme as app theme default
     */
    suspend fun selectDarkTheme()

    /**
     * if user saw and interact with app entry, it won't appear again for him
     */
    suspend fun saveAppEntry()

    /**
     * @return true if user already interacted with app entry otherwise false
     */
    fun isAppEntrySkipped() :Flow<Boolean>

}