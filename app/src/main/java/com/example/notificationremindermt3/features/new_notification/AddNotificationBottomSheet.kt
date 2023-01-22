package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.composables.BottomSheetGrappler

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotificationBottomSheetBody() {
    var notificationName by remember { mutableStateOf("") }

    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(20.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            BottomSheetGrappler()
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = notificationName,
                onValueChange = { notificationName = it },
                maxLines = 1,
                label = { Text(text = "Notification Name")  }
            )
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}