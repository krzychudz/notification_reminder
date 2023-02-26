package com.example.notificationremindermt3.core.di

import android.content.Context
import com.example.notificationremindermt3.core.database.NotificationAppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) =
        NotificationAppDatabase.getInstance(context)

    @Provides
    @Singleton
    fun provideNotificationDao(db: NotificationAppDatabase) = db.notificationDao()
}