package com.zenmeal.domain.models

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerMenuItem(
    val title: String,
    val route: String,
    val icon: ImageVector
)