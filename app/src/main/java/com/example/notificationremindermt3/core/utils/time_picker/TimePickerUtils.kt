package com.example.notificationremindermt3.core.utils.time_picker

import android.app.TimePickerDialog
import android.content.Context


class TimePickerUtils {
    companion object {
        fun buildTimePickerDialog(
            context: Context,
            onTimeSelected: (hours: Int, minutes: Int) -> Unit,
            initHours: Int = 12,
            initMinutes: Int = 12,
        ): TimePickerDialog {
            return TimePickerDialog(
                context,
                { _, hours, minutes ->
                    onTimeSelected(hours, minutes)
                },
                initHours,
                initMinutes,
                true
            )
        }
    }
}