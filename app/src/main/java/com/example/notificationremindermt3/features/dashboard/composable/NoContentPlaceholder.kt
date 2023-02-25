package com.example.notificationremindermt3.features.dashboard.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun NoContentPlaceholder() {
    Text(
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center,
        maxLines = 2,
        text = "You have not scheduled any notifications yet.\n Tap + to add one."
    )
}