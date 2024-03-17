package com.omni.profiles.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.omni.profiles.R
import com.omni.profiles.component.ButtonComponent
import com.omni.profiles.navigation.AppRouter
import com.omni.profiles.navigation.Screen
import com.omni.profiles.component.CheckBoxComponent
import com.omni.profiles.component.ClickableTextLoginComponent
import com.omni.profiles.component.DividerTextComponent
import com.omni.profiles.component.HeaderText
import com.omni.profiles.component.NormalText
import com.omni.profiles.component.PasswordField
import com.omni.profiles.component.TextFieldComponent

@Composable
fun SignupScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(28.dp)
            .background(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            NormalText(value = stringResource(R.string.hello_there))
            HeaderText(value = stringResource(R.string.sign_up))

            Spacer(
                modifier = Modifier
                    .height(16.dp)
                    .fillMaxWidth()
            )

            TextFieldComponent(label = stringResource(R.string.first_name), R.drawable.ic_profile) {
            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
            )

            TextFieldComponent(label = stringResource(R.string.last_name), R.drawable.ic_profile) {
            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
            )

            TextFieldComponent(label = stringResource(R.string.email), R.drawable.ic_profile) {

            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
            )

            PasswordField(label = stringResource(R.string.password), R.drawable.ic_security) {

            }

            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
            )

            CheckBoxComponent(value = stringResource(R.string.privacy_policy)) {
                AppRouter.navigateTo(Screen.TermsAndConditionsScreen)
            }

            Spacer(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
            )

            ButtonComponent(value = stringResource(R.string.register))

            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

            DividerTextComponent()

            Spacer(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
            )

            ClickableTextLoginComponent {
                AppRouter.navigateTo(Screen.LoginScreen)
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun SignUpScreenPreview() {
    SignupScreen()
}