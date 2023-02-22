package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.example.notificationremindermt3.features.new_notification.choose_days_dialog.ChooseDaysDialog
import com.example.notificationremindermt3.features.new_notification.view_model.AddNotificationBottomSheetViewModel
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.clock.ClockDialog
import com.maxkeppeler.sheets.clock.models.ClockConfig
import com.maxkeppeler.sheets.clock.models.ClockSelection
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotificationBottomSheetBody(
    addNotificationBottomSheetViewModel: AddNotificationBottomSheetViewModel = viewModel()
) {
    val openDialog = remember { mutableStateOf(false) }
    val calendarState = rememberSheetState()
    val addNotificationState by addNotificationBottomSheetViewModel.state

    ClockDialog(
        state = calendarState,
        config = ClockConfig(is24HourFormat = true),
        selection = ClockSelection.HoursMinutes { hours, minutes ->
            addNotificationBottomSheetViewModel.onTimeNotificationChanged(hours, minutes)
        })

    if (openDialog.value)
        ChooseDaysDialog { resultData ->
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
        ) { calendarState.show() }
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

        }
        SpacerContainer(4.0)
    }
}

@Composable
fun RoundedLabel(text: String) {
    Box(
        modifier = Modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = text)
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

@Composable
fun CircularIconButton(
    modifier: Modifier,
    onClick: () -> Unit,
    image: ImageVector,
    contentDescription: String
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = CircleShape
            )
            .height(24.dp)
            .width(24.dp)
    ) {
        Icon(image, contentDescription)
    }
}

@Composable
fun SubmitButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text = label)
    }
}