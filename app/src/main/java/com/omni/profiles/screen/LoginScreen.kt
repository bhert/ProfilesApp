package com.omni.profiles.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omni.profiles.R
import com.omni.profiles.component.ButtonComponent
import com.omni.profiles.component.ClickableTextSignupComponent
import com.omni.profiles.component.DividerTextComponent
import com.omni.profiles.component.HeaderText
import com.omni.profiles.component.NormalText
import com.omni.profiles.component.PasswordField
import com.omni.profiles.component.TextFieldComponent
import com.omni.profiles.component.UnderlinedLinkText
import com.omni.profiles.navigation.AppRouter
import com.omni.profiles.navigation.Screen
import com.omni.profiles.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Spacer(modifier = Modifier.height(16.dp))

            NormalText(value = stringResource(id = R.string.login))

            HeaderText(value = stringResource(R.string.welcome_back))

            Spacer(modifier = Modifier.height(32.dp))

            TextFieldComponent(
                label = stringResource(id = R.string.email),
                drawable = R.drawable.ic_profile
            ) {

            }

            Spacer(modifier = Modifier.height(16.dp))

            PasswordField(
                label = stringResource(id = R.string.password),
                drawable = R.drawable.ic_security
            ) {

            }

            Spacer(modifier = Modifier.height(32.dp))

            UnderlinedLinkText(value = stringResource(R.string.forgot_your_password)) {

            }

            Spacer(modifier = Modifier.height(32.dp))

            ButtonComponent(value = stringResource(id = R.string.login))

            Spacer(modifier = Modifier.height(32.dp))

            DividerTextComponent()

            Spacer(modifier = Modifier.height(32.dp))

            ClickableTextSignupComponent {

            }
        }

    }

    SystemBackButtonHandler {
        AppRouter.navigateTo(Screen.SignupScreen)
    }
}


@Preview(showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}