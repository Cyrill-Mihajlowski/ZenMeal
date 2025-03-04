package com.zenmeal.ui.adrecord

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AddRecordScreen(inner_padding: PaddingValues) {

    Text(
        text = "AddRecord",
        modifier = Modifier.padding(inner_padding)
    )
}