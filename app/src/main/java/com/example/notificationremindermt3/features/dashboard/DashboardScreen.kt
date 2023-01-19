package com.example.notificationremindermt3.features.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.features.dashboard.composable.NotificationItem

data class NotificationData(val title: String, val dates: String)

val data = listOf(
    NotificationData("Basen", "PT, SR, NE"),
    NotificationData("Lekcje", "PT, SR, NE"),
    NotificationData("Trening", "PT, SR, NE"),
)

@Composable
fun DashboardScreen(
    contentPadding: PaddingValues,
) {
    Box(
        modifier = Modifier.padding(contentPadding)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(
                items = data,
                itemContent = { item ->
                    NotificationItem(notificationData = item)
                },
            )
        }
    }
}