package com.omni.profiles.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omni.profiles.R
import com.omni.profiles.component.HeaderText
import com.omni.profiles.navigation.AppRouter
import com.omni.profiles.navigation.Screen
import com.omni.profiles.navigation.SystemBackButtonHandler

@Composable
fun TermsAndConditionsScreen() {
    Surface(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .padding(16.dp)) {

        HeaderText(value = stringResource(R.string.terms_of_use_header))
    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignupScreen)
    }
}

@Preview(showSystemUi = true)
@Composable
fun TermsAndConditionsPreview(){
    TermsAndConditionsScreen()
}