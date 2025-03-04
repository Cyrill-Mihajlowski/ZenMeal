package com.zenmeal.ui.screens

sealed class AppNavigatorIntent {
    data class UpdateTitle(val title: String) : AppNavigatorIntent()
    data class NavigateTo(val route: String) : AppNavigatorIntent()
}