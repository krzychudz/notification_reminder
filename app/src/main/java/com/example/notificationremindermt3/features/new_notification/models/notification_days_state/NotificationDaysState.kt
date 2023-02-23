package com.example.notificationremindermt3.features.new_notification.models.notification_days_state

data class NotificationDaysState(
    val monday: Boolean = false,
    val tuesday: Boolean = false,
    val wednesdays: Boolean = false,
    val thursday: Boolean = false,
    val friday: Boolean = false,
    val saturday: Boolean = false,
    val sunday: Boolean = false,
) {
    fun isEmpty(): Boolean {
        return !monday && !tuesday && !wednesdays && !thursday && !friday && !saturday && !sunday
    }


    fun formattedDays(): String {
        val monday = if (monday) "Mon" else ""
        val tuesday = if (tuesday) "Tue" else ""
        val wednesdays = if (wednesdays) "Wed" else ""
        val thursday = if (thursday) "Thu" else ""
        val friday = if (friday) "Fri" else ""
        val saturday = if (saturday) "Sat" else ""
        val sunday = if (sunday) "Sun" else ""

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