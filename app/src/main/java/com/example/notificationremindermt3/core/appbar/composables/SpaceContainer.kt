package com.example.notificationremindermt3.core.appbar.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SpacerContainer(height: Double = 0.0, width: Double = 0.0) {
    Spacer(modifier = Modifier.height(height.dp).width(width.dp))
}