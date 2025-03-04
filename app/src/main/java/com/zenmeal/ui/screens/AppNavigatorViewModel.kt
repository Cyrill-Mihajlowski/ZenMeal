package com.zenmeal.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AppNavigatorViewModel : ViewModel() {
    private val _state = MutableStateFlow(AppNavigatorState())
    val state: StateFlow<AppNavigatorState> = _state

    fun handleIntent(intent: AppNavigatorIntent) {
        Log.d("AppNavigatorViewModel", "Handling intent: $intent")
        when (intent) {
            is AppNavigatorIntent.NavigateTo -> {
                _state.value = _state.value.copy(currentRoute = intent.route)
            }

            is AppNavigatorIntent.UpdateTitle -> {
                _state.value = _state.value.copy(currentTitle = intent.title)
            }
        }
    }
}