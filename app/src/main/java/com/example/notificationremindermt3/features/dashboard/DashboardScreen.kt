package com.example.notificationremindermt3.features.dashboard


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.example.notificationremindermt3.core.appbar.MainAppBar
import com.example.notificationremindermt3.core.appbar.composables.fab.BottomSheetScaffoldFabPositionContainer
import com.example.notificationremindermt3.features.dashboard.composable.NotificationItem
import com.example.notificationremindermt3.features.new_notification.AddNotificationBottomSheetBody
import fr.swarmlab.beta.ui.screens.components.material3.*
import kotlinx.coroutines.launch

data class NotificationData(val title: String, val dates: String)

val data = listOf(
    NotificationData("Basen", "PT, SR, NE"),
    NotificationData("Lekcje", "PT, SR, NE"),
    NotificationData("Trening", "PT, SR, NE"),
)


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
) {
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        topBar = {
            MainAppBar(
                text = "Hello Adam",
                navigationIcon = Icons.Default.Menu,
                onNavigationButtonClick = {},
            )
        },
        sheetContent = {
            AddNotificationBottomSheetBody()
        },
        sheetPeekHeight = 0.dp,
        sheetElevation = 0.dp,
        floatingActionButton = {
            BottomSheetScaffoldFabPositionContainer(fab = {
                FloatingActionButton(onClick = {
                    coroutineScope.launch {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    }
                }, shape = RoundedCornerShape(16.dp)) {
                    Icon(imageVector = Icons.Rounded.Add, contentDescription = "Add Button")
                }
            })
        }
    ) {
        DashboardScreenContent(it)
    }
}

@Composable
fun DashboardScreenContent(paddingValues: PaddingValues) {
    Box(
        modifier = Modifier.padding(paddingValues)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxHeight(),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            items(
                items = data,
                itemContent = { item ->
                    NotificationItem(notificationData = item)
                },
            )
        }
    }
}