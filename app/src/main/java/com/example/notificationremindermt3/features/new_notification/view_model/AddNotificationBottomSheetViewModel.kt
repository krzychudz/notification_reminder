package com.example.notificationremindermt3.features.new_notification.view_model

import androidx.lifecycle.ViewModel
import com.example.notificationremindermt3.core.appbar.composables.models.notification_time.NotificationTime
import com.example.notificationremindermt3.features.new_notification.view_model.state.AddNotificationState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AddNotificationBottomSheetViewModel : ViewModel() {

    private val _state = MutableStateFlow(AddNotificationState())
    private val _stateValue = _state.value
    val state: StateFlow<AddNotificationState> = _state.asStateFlow()

    fun onNotificationNameChanged(newNotificationName: String) {
        val newState = _stateValue.copy(notificationName = newNotificationName)
        _state.value = newState
    }

    fun onTimeNotificationChanged(hours: Int, minutes: Int) {
        val newNotificationTime = NotificationTime(hours = hours, minutes = minutes)
        val newState = _stateValue.copy(notificationTime = newNotificationTime)
        _state.value = newState
    }

    fun onRepeatDateChanged() {

    }
}