package com.zenmeal.ui.screens

import android.util.Log
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zenmeal.ui.adrecord.AddRecordScreen
import com.zenmeal.ui.components.BottomBar
import com.zenmeal.ui.components.FloatActionButton
import com.zenmeal.ui.components.TopBar
import com.zenmeal.ui.main.MainScreen
import com.zenmeal.ui.settings.SettingScreen

@Composable
fun AppNavigator(viewModel: AppNavigatorViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    Log.d("AppNavigator", "Current state: $state")

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopBar(currentTitle = state.currentTitle)
        },
        bottomBar = {
            BottomBar(navController = navController, appNavigatorViewModel = viewModel)
        },
        floatingActionButton = {
            FloatActionButton(navController = navController, appNavigatorViewModel = viewModel)
        }
    ) { inner_padding ->
        NavHost(navController = navController, startDestination = "main") {
            composable("main") { MainScreen(inner_padding) }
            composable("setting") { SettingScreen(inner_padding) }
            composable("add_record") { AddRecordScreen(inner_padding) }
        }
    }
}