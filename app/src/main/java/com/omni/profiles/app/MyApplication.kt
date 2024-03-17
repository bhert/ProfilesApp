package com.omni.profiles.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.omni.profiles.navigation.AppRouter
import com.omni.profiles.navigation.Screen
import com.omni.profiles.screen.LoginScreen
import com.omni.profiles.screen.SignupScreen
import com.omni.profiles.screen.TermsAndConditionsScreen
import com.omni.profiles.ui.theme.ProfilesTheme

@Composable
fun MyApplication() {
    ProfilesTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        ) {

            Crossfade(targetState = AppRouter.currentScreen, label = "") { currentState ->
                when (currentState.value) {
                    Screen.SignupScreen -> SignupScreen()
                    Screen.TermsAndConditionsScreen -> TermsAndConditionsScreen()
                    Screen.LoginScreen -> LoginScreen()
                }
            }
        }
    }
}
