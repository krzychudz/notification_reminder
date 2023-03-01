package com.example.notificationremindermt3.core.composition_locals

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavigationProvider = staticCompositionLocalOf<NavHostController>
{ error("No navigation host controller provided.") }