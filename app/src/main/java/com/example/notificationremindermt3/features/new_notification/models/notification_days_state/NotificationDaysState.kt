package com.example.notificationremindermt3.features.new_notification.models.notification_days_state

data class NotificationDaysState(
    val monday: Boolean = true,
    val tuesday: Boolean = true,
    val wednesdays: Boolean = true,
    val thursday: Boolean = true,
    val friday: Boolean = true,
    val saturday: Boolean = true,
    val sunday: Boolean = true,
) {
    fun formattedDays(): String {
        val monday = if (monday) "Mon" else ""
        val tuesday = if (tuesday) "Tue" else ""
        val wednesdays = if (wednesdays) "Wed" else ""
        val thursday = if (thursday) "Thu" else ""
        val friday = if (friday) "Fri" else ""
        val saturday = if (saturday) "Sat" else ""
        val sunday = if (sunday) "Sat" else ""

        val daysList = listOf(
            monday,
            tuesday,
            wednesdays,
            thursday,
            friday,
            saturday,
            sunday
        ).filter { element -> element.isNotEmpty() }

        return daysList.joinToString(" | ")
    }
}