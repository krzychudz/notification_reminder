package com.example.notificationremindermt3.features.dashboard


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notificationremindermt3.core.appbar.MainAppBar
import com.example.notificationremindermt3.core.composables.fab.BottomSheetScaffoldFabPositionContainer
import com.example.notificationremindermt3.core.database.table.Notification
import com.example.notificationremindermt3.features.dashboard.composable.NoContentPlaceholder
import com.example.notificationremindermt3.features.dashboard.composable.NotificationList
import com.example.notificationremindermt3.features.dashboard.viewmodel.DashboardViewModel
import com.example.notificationremindermt3.features.new_notification.AddNotificationBottomSheetBody
import fr.swarmlab.beta.ui.screens.components.material3.*
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel = hiltViewModel()
) {
    val dashboardViewModelState by dashboardViewModel.state

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
            AddNotificationBottomSheetBody {
                coroutineScope.launch {
                    bottomSheetScaffoldState.bottomSheetState.collapse()
                }
            }
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
        DashboardScreenContent(it, notificationsData = dashboardViewModelState)
    }
}

@Composable
fun DashboardScreenContent(
    paddingValues: PaddingValues,
    notificationsData: List<Notification>
) {
    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        if (notificationsData.isEmpty()) {
            NoContentPlaceholder()
        } else {
            NotificationList(notificationsData)
        }
    }
}