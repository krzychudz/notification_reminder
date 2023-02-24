package com.example.notificationremindermt3.core.composables.rounded_label

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RoundedLabel(text: String) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = text)
    }
}
