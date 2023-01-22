package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.composables.BottomSheetGrappler
import com.example.notificationremindermt3.core.appbar.composables.SpacerContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotificationBottomSheetBody() {
    var notificationName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        BottomSheetGrappler(modifier = Modifier.align(Alignment.CenterHorizontally))
        SpacerContainer(20.0)
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = notificationName,
            onValueChange = { notificationName = it },
            maxLines = 1,
            label = { Text(text = "Notification Name") },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
        )
        SpacerContainer(16.0)
        Text(text = "Notification dates")
        SpacerContainer(8.0)
        Divider()
        SpacerContainer(8.0)
        CircularIconButton(image = Icons.Rounded.Add, contentDescription = "Add notification date", onClick = {})
        SubmitButton(modifier = Modifier.align(Alignment.CenterHorizontally))
        SpacerContainer(8.0)
    }
}

@Composable
fun CircularIconButton(onClick: () -> Unit, image: ImageVector, contentDescription: String) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.surface,
            shape = CircleShape
        )
    ) {
        Icon(image, contentDescription)
    }
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier) {
    ElevatedButton(
        onClick = { /*TODO*/ },
        modifier = modifier
    ) {
        Text(text = "Add Notification")
    }
}