package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AddNotificationBottomSheetBody() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(16.dp)
    ) {
        Box(
            modifier = Modifier
                .width(32.dp)
                .height(4.dp)
                .background(color = Color(0xFF79747E), shape = RoundedCornerShape(100))
        ) {
        }
//        Text(text = "Hello from sheet")
    }
}