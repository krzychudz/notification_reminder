package com.example.notificationremindermt3.features.new_notification

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.swarmlab.beta.ui.screens.components.material3.BottomSheetScaffold
import fr.swarmlab.beta.ui.screens.components.material3.BottomSheetScaffoldState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNotificationBottomSheet(
    bottomSheetScaffoldState: BottomSheetScaffoldState,
    child: @Composable () -> Unit,
) {
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            AddNotificationBottomSheetBody()
        },
        sheetPeekHeight = 0.dp
    ) {
        child()
    }
}

@Composable
fun AddNotificationBottomSheetBody() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Text(text = "Hello from sheet")
    }
}