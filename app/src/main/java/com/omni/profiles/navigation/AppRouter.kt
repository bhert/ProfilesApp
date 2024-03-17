package com.omni.profiles.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {
    object SignupScreen : Screen()
    object TermsAndConditionsScreen : Screen()
    object LoginScreen:Screen()
}

object AppRouter {
    var currentScreen :MutableState<Screen> = mutableStateOf(Screen.SignupScreen)

    fun navigateTo(destination: Screen){
        currentScreen.value = destination
    }
}