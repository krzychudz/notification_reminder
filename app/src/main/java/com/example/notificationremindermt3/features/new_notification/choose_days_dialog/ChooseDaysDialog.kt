package com.example.notificationremindermt3.features.new_notification.choose_days_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.composables.SpacerContainer
import com.example.notificationremindermt3.features.new_notification.SubmitButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseDaysDialog(onDismissRequest: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissRequest
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 400.dp, max = 800.dp)
                .background(color = Color.White, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    "Choose days",
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
                SpacerContainer(16.0)
                DaySelector("Monday") {}
                DaySelector("Tuesday") {}
                DaySelector("Wednesday") {}
                DaySelector("Thursday") {}
                DaySelector("Friday") {}
                DaySelector("Saturday") {}
                DaySelector("Sunday") {}
                SubmitButton(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
            }
        }
    }
}

@Composable
fun DaySelector(label: String, onSelect: () -> Unit) {
    Row() {
        Checkbox(checked = true, onCheckedChange = {})
        Text(text = label, modifier = Modifier.align(Alignment.CenterVertically))
    }
}
