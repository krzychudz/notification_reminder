package com.example.notificationremindermt3.core.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notificationremindermt3.core.database.dao.NotificationDao
import com.example.notificationremindermt3.core.database.table.Notification

@Database(entities = [(Notification::class)], version = 1, exportSchema = false)
abstract class NotificationAppDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao

    companion object {

        @Volatile
        private var INSTANCE: NotificationAppDatabase? = null

        fun getInstance(context: Context): NotificationAppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotificationAppDatabase::class.java,
                        "notification_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}