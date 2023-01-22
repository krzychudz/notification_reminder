package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.composables.BottomSheetGrappler

@Composable
fun AddNotificationBottomSheetBody() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
            BottomSheetGrappler()
        }

    }
}