package com.example.notificationremindermt3.features.new_notification.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.notificationremindermt3.core.models.notification_time.NotificationTime
import com.example.notificationremindermt3.features.new_notification.models.notification_days_state.NotificationDaysState
import com.example.notificationremindermt3.features.new_notification.view_model.state.AddNotificationState

class AddNotificationBottomSheetViewModel : ViewModel() {

    private val _state = mutableStateOf(AddNotificationState())
    val state: State<AddNotificationState> = _state

    fun onNotificationNameChanged(newNotificationName: String) {
        val newState = _state.value.copy(notificationName = newNotificationName)
        _state.value = newState
    }

    fun onTimeNotificationChanged(hours: Int, minutes: Int) {
        val newNotificationTime = NotificationTime(hours = hours, minutes = minutes)
        val newState = _state.value.copy(notificationTime = newNotificationTime)
        _state.value = newState
    }

    fun onRepeatDateChanged(notificationDaysData: NotificationDaysState) {
        if (notificationDaysData.isEmpty()) return
        val newState = _state.value.copy(notificationRepeatDays = notificationDaysData)
        _state.value = newState
    }
}