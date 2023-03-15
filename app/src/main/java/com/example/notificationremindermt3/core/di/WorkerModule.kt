package com.example.notificationremindermt3.core.di

import android.content.Context
import com.example.notificationremindermt3.core.workers.manager.WorkManager
import com.example.notificationremindermt3.core.workers.manager.WorkManagerInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object WorkerModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): WorkManagerInterface =
        WorkManager(context)
}
