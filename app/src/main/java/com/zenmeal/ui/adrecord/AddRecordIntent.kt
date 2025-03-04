package com.zenmeal.ui.adrecord

sealed class AddRecordIntent {
    object SaveRecord : AddRecordIntent()
    data class UpdateField(val field: String, val value: String) : AddRecordIntent()
    data class UpdateMealType(val type: MealType) : AddRecordIntent()
}