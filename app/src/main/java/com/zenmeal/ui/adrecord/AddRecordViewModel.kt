package com.zenmeal.ui.adrecord

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AddRecordViewModel() : ViewModel() {
    private val _state = MutableStateFlow(AddRecordState())
    val state: StateFlow<AddRecordState> = _state

    fun handleIntent(intent: AddRecordIntent) {
        when (intent) {
            is AddRecordIntent.SaveRecord -> saveRecord()
            is AddRecordIntent.UpdateField -> updateField(intent.field, intent.value)
            is AddRecordIntent.UpdateMealType -> updateMealType(intent.type)
        }
    }

    private fun updateField(field: String, value: String) {
        _state.value = when (field) {
            "title" -> _state.value.copy(title = value)
            "description" -> _state.value.copy(description = value)
            else -> _state.value
        }
    }

    private fun saveRecord() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isSaving = true)
            try {
                // Simulate saving to database
                // Replace this with Room or your chosen data layer.
                kotlinx.coroutines.delay(1000)
                _state.value = AddRecordState()
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isSaving = false,
                    error = e.message
                )
            }
        }
    }

    private fun updateMealType(type: MealType) {
        _state.value = _state.value.copy(mealType = type)
    }
}