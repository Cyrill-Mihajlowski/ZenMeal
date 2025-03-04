package com.zenmeal.ui.components

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zenmeal.ui.screens.AppNavigatorIntent
import com.zenmeal.ui.screens.AppNavigatorViewModel

@Composable
fun BottomBar(navController: NavHostController, appNavigatorViewModel: AppNavigatorViewModel) {
    Box {
        BottomAppBar(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 4.dp,
            actions = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BottomBarAction(
                        icon = Icons.Default.Home,
                        label = "Home",
                        onClick = {
                            Log.d("BottomBar", "Home clicked")
                            appNavigatorViewModel.handleIntent(AppNavigatorIntent.UpdateTitle("Home"))
                            appNavigatorViewModel.handleIntent(AppNavigatorIntent.NavigateTo("main"))
                            navController.navigate("main") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    BottomBarAction(
                        icon = Icons.Default.Settings,
                        label = "Settings",
                        onClick = {
                            Log.d("BottomBar", "Setting clicked")
                            appNavigatorViewModel.handleIntent(AppNavigatorIntent.UpdateTitle("Settings"))
                            appNavigatorViewModel.handleIntent(AppNavigatorIntent.NavigateTo("setting"))
                            navController.navigate("setting") {
                                popUpTo(navController.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        )
    }
}

@Composable
fun BottomBarAction(icon: ImageVector, label: String, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Icon(
            icon,
            contentDescription = label,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}