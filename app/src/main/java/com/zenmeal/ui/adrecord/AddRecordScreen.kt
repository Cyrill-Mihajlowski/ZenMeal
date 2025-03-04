package com.zenmeal.ui.adrecord

import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.material3.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable

@Composable
fun AddRecordScreen(
    inner_padding: PaddingValues,
    viewModel: AddRecordViewModel = viewModel()
) {
    val state = viewModel.state.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(inner_padding)
            .padding(16.dp)
    ) {

        if (state.mealType == MealType.FOOD) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { viewModel.handleIntent(AddRecordIntent.UpdateField("title", it)) },
                label = { Text("Food Title") },
                modifier = Modifier.fillMaxWidth()
            )
        } else if (state.mealType == MealType.DRINK) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { viewModel.handleIntent(AddRecordIntent.UpdateField("title", it)) },
                label = { Text("Drink Title") },
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = state.description,
            onValueChange = {
                viewModel.handleIntent(
                    AddRecordIntent.UpdateField(
                        "description",
                        it
                    )
                )
            },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            RadioButton(
                selected = state.mealType == MealType.FOOD,
                onClick = { viewModel.handleIntent(AddRecordIntent.UpdateMealType(MealType.FOOD)) }
            )
            Text("Food")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = state.mealType == MealType.DRINK,
                onClick = { viewModel.handleIntent(AddRecordIntent.UpdateMealType(MealType.DRINK)) }
            )
            Text("Drink")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.handleIntent(AddRecordIntent.SaveRecord) },
            modifier = Modifier.align(Alignment.End),
            enabled = !state.isSaving
        ) {
            Text(if (state.isSaving) "Saving..." else "Save")
        }

        if (state.error != null) {
            Text(
                text = "Error: ${state.error}",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}