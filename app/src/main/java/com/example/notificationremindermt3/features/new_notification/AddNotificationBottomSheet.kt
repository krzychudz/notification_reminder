package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notificationremindermt3.core.composables.BottomSheetGrappler
import com.example.notificationremindermt3.core.composables.SpacerContainer
import com.example.notificationremindermt3.features.new_notification.choose_days_dialog.ChooseDaysDialog
import com.example.notificationremindermt3.features.new_notification.view_model.AddNotificationBottomSheetViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.notificationremindermt3.core.composables.circular_icon_button.CircularIconButton
import com.example.notificationremindermt3.core.composables.rounded_label.RoundedLabel
import com.example.notificationremindermt3.core.composables.submit_button.SubmitButton
import com.example.notificationremindermt3.core.utils.time_picker.TimePickerUtils
import com.example.notificationremindermt3.features.new_notification.models.notification_days_state.NotificationDaysState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotificationBottomSheetBody(
    addNotificationBottomSheetViewModel: AddNotificationBottomSheetViewModel = hiltViewModel()
) {
    val openDialog = remember { mutableStateOf(false) }
    val addNotificationState by addNotificationBottomSheetViewModel.state

    val timePickerDialog = TimePickerUtils.buildTimePickerDialog(
        LocalContext.current,
        onTimeSelected = { hours, minutes ->
            addNotificationBottomSheetViewModel.onTimeNotificationChanged(
                hours,
                minutes
            )
        },
        initHours = addNotificationState.notificationTime?.hours ?: 12,
        initMinutes = addNotificationState.notificationTime?.minutes ?: 12
    )

    if (openDialog.value)
        ChooseDaysDialog(
            initialDaysState = addNotificationState.notificationRepeatDays
                ?: NotificationDaysState(),
        ) { resultData ->
            openDialog.value = false
            addNotificationBottomSheetViewModel.onRepeatDateChanged(resultData)
        }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(32.dp)
    ) {
        BottomSheetGrappler(modifier = Modifier.align(Alignment.CenterHorizontally))
        SpacerContainer(20.0)
        TextField(
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth(),
            value = addNotificationState.notificationName,
            onValueChange = { addNotificationBottomSheetViewModel.onNotificationNameChanged(it) },
            maxLines = 1,
            label = { Text(text = "Notification Name") },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.Transparent)
        )
        SpacerContainer(16.0)
        Text(text = "Notification dates")
        SpacerContainer(12.0)
        AddPropertySection(
            label = "Time:",
            buttonContentDescription = "Add notification date",
            selectedComposable = addNotificationState.notificationTime?.let {
                { RoundedLabel(it.formattedTime()) }
            },
        ) { timePickerDialog.show() }
        SpacerContainer(12.0)
        AddPropertySection(
            label = "Repeat:",
            buttonContentDescription = "Add notification date",
            selectedComposable = addNotificationState.notificationRepeatDays?.let {
                { RoundedLabel(it.formattedDays()) }
            },
        ) { openDialog.value = true }
        SpacerContainer(16.0)
        SubmitButton(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            label = "Add Notification"
        ) {
            addNotificationBottomSheetViewModel.onSubmitButtonPressed()
        }
        SpacerContainer(4.0)
    }
}

@Composable
fun AddPropertySection(
    label: String,
    buttonContentDescription: String,
    selectedComposable: (@Composable () -> Unit)?,
    onClick: () -> Unit,
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(modifier = Modifier.align(Alignment.CenterVertically), text = label)
        SpacerContainer(width = 12.0)
        if (selectedComposable != null) {
            Row(modifier = Modifier.weight(1F, fill = false)) {
                selectedComposable()
                SpacerContainer(width = 12.0)
            }
        }
        CircularIconButton(
            modifier = Modifier
                .align(Alignment.CenterVertically),
            image = Icons.Rounded.Add,
            contentDescription = buttonContentDescription,
            onClick = onClick,
        )

    }
}