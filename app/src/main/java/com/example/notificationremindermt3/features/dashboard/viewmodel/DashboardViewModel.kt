package com.example.notificationremindermt3.features.dashboard.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notificationremindermt3.core.database.table.Notification
import com.example.notificationremindermt3.core.repository.notification.NotificationRepository
import com.example.notificationremindermt3.core.repository.notification.NotificationRepositoryInterface
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val notificationRepository: NotificationRepositoryInterface) :
    ViewModel() {

    private val _state = mutableStateOf(emptyList<Notification>())
    val state: State<List<Notification>> = _state

    init {
        initDatabaseObserver()
    }

    private fun initDatabaseObserver() {
        viewModelScope.launch {
            notificationRepository.allNotifications().collect { notifications ->
                _state.value = notifications
            }
        }
    }
}