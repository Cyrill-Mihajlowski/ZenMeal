package com.zenmeal.ui.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SettingScreen(inner_padding: PaddingValues) {
    Text(
        text = "Settings",
        modifier = Modifier.padding(inner_padding)
    )
}