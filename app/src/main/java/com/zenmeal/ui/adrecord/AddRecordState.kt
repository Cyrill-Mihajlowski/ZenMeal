package com.zenmeal.ui.adrecord

data class AddRecordState(
    val title: String = "",
    val description: String = "",
    val mealType: MealType = MealType.FOOD,
    val isSaving: Boolean = false,
    val error: String? = null
)

enum class MealType {
    FOOD, DRINK
}