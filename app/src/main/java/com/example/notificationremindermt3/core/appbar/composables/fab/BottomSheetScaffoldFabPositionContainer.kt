package com.example.notificationremindermt3.core.appbar.composables.fab

import androidx.compose.runtime.Composable
import androidx.compose.ui.layout.Layout


@Composable
fun BottomSheetScaffoldFabPositionContainer(fab: @Composable () -> Unit) {
    Layout(content = {
        fab()
    }) { measurables, constraints ->
        val placeable = measurables.first().measure(constraints)
        layout(placeable.width, placeable.height) {
            placeable.placeRelative(0, -placeable.height / 2 - 64)
        }
    }
}