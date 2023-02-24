package com.example.notificationremindermt3.core.database.dao

import androidx.room.*
import com.example.notificationremindermt3.core.database.table.Notification
import kotlinx.coroutines.flow.Flow

@Dao
interface NotificationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSingle(notification: Notification)

    @Query("SELECT * FROM Notifications")
    suspend fun getAll(): Flow<List<Notification>>

    @Query("SELECT * FROM Notifications WHERE id = :notificationId")
    suspend fun getById(notificationId: String) : Notification

    @Delete
    suspend fun delete(notification: Notification)

}