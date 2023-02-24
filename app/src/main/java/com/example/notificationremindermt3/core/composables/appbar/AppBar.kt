package com.example.notificationremindermt3.core.appbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppBar(
    text: String,
    onNavigationButtonClick: () -> Unit,
    navigationIcon: ImageVector,
) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = onNavigationButtonClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = "Nav Icon"
                )
            }
        },
        title = { Text(text = text) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                3.dp
            )
        )
    )
}
