package com.example.notificationremindermt3.core.composables.circular_icon_button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CircularIconButton(
    modifier: Modifier,
    onClick: () -> Unit,
    image: ImageVector,
    contentDescription: String
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = CircleShape
            )
            .height(24.dp)
            .width(24.dp)
    ) {
        Icon(image, contentDescription)
    }
}