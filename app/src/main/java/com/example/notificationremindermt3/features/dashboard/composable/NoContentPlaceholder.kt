package com.example.notificationremindermt3.features.dashboard.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.R

@Composable
fun NoContentPlaceholder() {
    Text(
        modifier = Modifier.padding(16.dp),
        textAlign = TextAlign.Center,
        maxLines = 2,
        text = stringResource(id = R.string.notification_empty_list_placeholder)
    )
}