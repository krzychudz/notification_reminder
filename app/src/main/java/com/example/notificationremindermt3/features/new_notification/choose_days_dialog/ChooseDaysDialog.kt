package com.example.notificationremindermt3.features.new_notification.choose_days_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.composables.SpacerContainer
import com.example.notificationremindermt3.features.new_notification.SubmitButton
import com.example.notificationremindermt3.features.new_notification.models.notification_days_state.NotificationDaysState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChooseDaysDialog(
    onDismissRequest: () -> Unit = {},
    onConfirmationButtonClicked: (result: NotificationDaysState) -> Unit
) {

    val daysCheckState =
        remember {
            mutableStateOf(
                NotificationDaysState()
            )
        }

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
                DaySelector(
                    "Monday",
                    isChecked = daysCheckState.value.monday
                ) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(monday = isSelected)
                }
                DaySelector("Tuesday", isChecked = daysCheckState.value.tuesday) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(tuesday = isSelected)
                }
                DaySelector(
                    "Wednesday",
                    isChecked = daysCheckState.value.wednesdays
                ) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(wednesdays = isSelected)
                }
                DaySelector("Thursday", isChecked = daysCheckState.value.thursday) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(thursday = isSelected)
                }
                DaySelector("Friday", isChecked = daysCheckState.value.friday) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(friday = isSelected)
                }
                DaySelector("Saturday", isChecked = daysCheckState.value.saturday) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(saturday = isSelected)
                }
                DaySelector("Sunday", isChecked = daysCheckState.value.sunday) { isSelected ->
                    daysCheckState.value = daysCheckState.value.copy(sunday = isSelected)
                }
                SpacerContainer(16.0)
                SubmitButton(
                    modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                    label = "Confirm"
                ) {
                    onConfirmationButtonClicked(daysCheckState.value)
                }
            }
        }
    }
}

@Composable
fun DaySelector(label: String, isChecked: Boolean, onSelected: (isSelected: Boolean) -> Unit) {
    Row() {
        Checkbox(checked = isChecked, onCheckedChange = onSelected)
        Text(text = label, modifier = Modifier.align(Alignment.CenterVertically))
    }
}
