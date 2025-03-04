package com.zenmeal.ui.components

import android.util.Log
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.zenmeal.ui.screens.AppNavigatorIntent
import com.zenmeal.ui.screens.AppNavigatorViewModel

@Composable
fun FloatActionButton(navController: NavHostController, appNavigatorViewModel: AppNavigatorViewModel) {
    FloatingActionButton(
        onClick = {
            Log.d("AppNavigator", "FloatingActionButton clicked")
            appNavigatorViewModel.handleIntent(AppNavigatorIntent.UpdateTitle("Add Record"))
            appNavigatorViewModel.handleIntent(AppNavigatorIntent.NavigateTo("add_record"))
            navController.navigate("add_record") {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        },
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    ) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}