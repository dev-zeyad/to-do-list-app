package com.alpha.todolist.presentation.main

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private var _state = mutableStateOf(MainState())
    val state: State<MainState>
        get() = _state


   init {
       viewModelScope.launch(Dispatchers.Main) {
           delay(600)
           _state.value = _state.value.copy(isAppReady = true)
       }
   }

}