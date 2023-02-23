package com.example.notificationremindermt3.core.composables.submit_button

import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SubmitButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = label)
    }
}
