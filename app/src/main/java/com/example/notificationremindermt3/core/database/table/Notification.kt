package com.example.notificationremindermt3.core.database.table

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notificationremindermt3.core.models.notification_time.NotificationTime
import com.example.notificationremindermt3.features.new_notification.models.notification_days_state.NotificationDaysState
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Notifications")
data class Notification(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: String,

    @ColumnInfo(name = "name")
    var name: String,

    @Embedded
    var notificationTime: NotificationTime,

    @Embedded
    var notificationDays: NotificationDaysState

) : Parcelable
