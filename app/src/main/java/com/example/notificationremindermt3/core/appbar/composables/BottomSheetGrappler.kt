package com.example.notificationremindermt3.core.appbar.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetGrappler() {
    Box(
        modifier = Modifier
            .width(32.dp)
            .height(4.dp)
            .background(color = Color(0xFF79747E), shape = RoundedCornerShape(100)),
        content = {}
    )
}