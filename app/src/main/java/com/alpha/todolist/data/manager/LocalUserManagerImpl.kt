package com.alpha.todolist.data.manager

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.alpha.todolist.domain.manager.LocalUserManager
import com.alpha.todolist.util.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * later add dagger hilt and make context property dependency
 */
class LocalUserManagerImpl(
    private val context: Context
) : LocalUserManager {

    override fun isDarkThemeSelected(): Flow<Boolean> {
        return context.dataStoreSettingsFile.data.map { settings ->
            settings[PreferencesKeys.isDarkTheme] ?: false
        }
    }

    override suspend fun selectDarkTheme() {
        context.dataStoreSettingsFile.edit { settings ->
            if (settings[PreferencesKeys.isDarkTheme] != null) {
                settings[PreferencesKeys.isDarkTheme] =
                    settings[PreferencesKeys.isDarkTheme] != true
            } else {
                settings[PreferencesKeys.isDarkTheme] = true
            }
        }
    }

    override suspend fun saveAppEntry() {
        context.dataStoreSettingsFile.edit { settings ->
            settings[PreferencesKeys.isAppEntrySkipped] = true
        }
    }

    override fun isAppEntrySkipped(): Flow<Boolean> {
        return context.dataStoreSettingsFile.data.map { settings ->
            settings[PreferencesKeys.isAppEntrySkipped] ?: false
        }
    }

}

/**
 * later add dagger hilt and make this property dependency
 */
private val Context.dataStoreSettingsFile: DataStore<Preferences> by
preferencesDataStore(name = Constants.SETTINGS_FILE_NAME)


private object PreferencesKeys {
    val isDarkTheme = booleanPreferencesKey(Constants.SETTINGS_FILE_NAME_IS_DARK_THEME)
    val isAppEntrySkipped = booleanPreferencesKey(Constants.SETTINGS_FILE_NAME_IS_APP_ENTRY_SKIPPED)

}
