package com.zenmeal.ui.main

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(inner_padding: PaddingValues) {
    Text(
        text = "Main",
        modifier = Modifier.padding(inner_padding)
    )
}
