package com.zenmeal.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.zenmeal.domain.models.DrawerMenuItem

@Composable
fun DrawerContent(
    navController: NavHostController,
    menuItems: List<DrawerMenuItem>,
    onMenuItemClick: (String) -> Unit
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            menuItems.forEach { item ->
                NavigationDrawerItem(
                    label = { Text(item.title) },
                    selected = currentRoute == item.route,
                    icon = { Icon(item.icon, contentDescription = item.title) },
                    onClick = { onMenuItemClick(item.route) },
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Divider()
            }
        }
    }
}