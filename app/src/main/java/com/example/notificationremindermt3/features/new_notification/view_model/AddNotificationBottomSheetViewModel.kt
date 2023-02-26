package com.example.notificationremindermt3.features.new_notification.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notificationremindermt3.core.database.table.Notification
import com.example.notificationremindermt3.core.models.notification_time.NotificationTime
import com.example.notificationremindermt3.core.repository.notification.NotificationRepository
import com.example.notificationremindermt3.core.repository.notification.NotificationRepositoryInterface
import com.example.notificationremindermt3.features.new_notification.models.notification_days_state.NotificationDaysState
import com.example.notificationremindermt3.features.new_notification.view_model.state.AddNotificationState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddNotificationBottomSheetViewModel @Inject constructor(
    private val notificationRepository: NotificationRepositoryInterface
) :
    ViewModel() {

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

    fun onSubmitButtonPressed() {
        val notificationState = _state.value

        val notificationData = Notification(
            id = UUID.randomUUID().toString(),
            name = notificationState.notificationName,
            notificationTime = notificationState.notificationTime ?: NotificationTime(),
            notificationDays = notificationState.notificationRepeatDays ?: NotificationDaysState()
        )
        viewModelScope.launch {
            notificationRepository.addNotification(notificationData)
            _state.value = notificationState.copy(isNotificationAdded = true)
        }
    }
}