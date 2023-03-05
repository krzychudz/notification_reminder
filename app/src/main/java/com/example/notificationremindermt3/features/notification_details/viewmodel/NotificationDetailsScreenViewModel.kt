package com.example.notificationremindermt3.features.notification_details.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notificationremindermt3.core.repository.notification.NotificationRepositoryInterface
import com.example.notificationremindermt3.features.notification_details.viewmodel.state.NotificationDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotificationDetailsScreenViewModel @Inject constructor(
    private val notificationRepository: NotificationRepositoryInterface,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(NotificationDetailsState())
    val state: State<NotificationDetailsState> = _state

    init {
        getNotificationData()
    }


    private fun getNotificationData() {
        viewModelScope.launch {
            val notificationId = savedStateHandle.get<String>("notificationId")

            notificationId?.let {
                val notificationData = notificationRepository.getNotificationById(it)
                val currentState = _state.value
                _state.value = currentState.copy(notification = notificationData)
            }

        }
    }

    fun removeNotification() {
        viewModelScope.launch {
            val currentState = _state.value
            currentState.notification?.let {
                notificationRepository.removeNotification(it)
                _state.value = currentState.copy(isRemoved = true)
            }

        }
    }
}