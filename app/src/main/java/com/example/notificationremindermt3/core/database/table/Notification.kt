package com.example.notificationremindermt3.core.database.table

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "Notifications")
data class Notification(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String

) : Parcelable


//val notificationName: String = "",
//val notificationTime: NotificationTime? = null,
//val notificationRepeatDays: NotificationDaysState? = null,
