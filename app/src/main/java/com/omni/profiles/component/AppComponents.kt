package com.omni.profiles.component

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omni.profiles.R


@Composable
fun NormalText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun UnderlinedLinkText(value: String, onClick: () -> Unit) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(40.dp),
        style = TextStyle(
            fontSize = 14.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Normal
        ),
        color = Color.Gray,
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}

@Composable
fun HeaderText(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
        style = TextStyle(
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Bold
        ),
        color = Color.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextFieldComponent(
    label: String,
    drawable: Int, onTextChange: (value: String) -> Unit
) {
    var textInput by remember { mutableStateOf("") }

    OutlinedTextField(
        label = { Text(text = label) },
        value = textInput,
        onValueChange = {
            textInput = it
            onTextChange(it)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200)
        ),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        leadingIcon = {
            Icon(
                painter = painterResource(id = drawable),
                contentDescription = ""
            )
        },
        singleLine = true,
        maxLines = 1
    )
}

@Composable
fun PasswordField(
    label: String,
    drawable: Int, onTextChange: (value: String) -> Unit
) {
    val localFocusManager = LocalFocusManager.current

    var password by remember { mutableStateOf("") }

    var passwordVisible by remember {
        mutableStateOf(false)
    }

    OutlinedTextField(
        label = { Text(text = label) },
        value = password,
        onValueChange = {
            password = it
            onTextChange(it)
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = colorResource(id = R.color.purple_200),
            focusedLabelColor = colorResource(id = R.color.purple_200),
            cursorColor = colorResource(id = R.color.purple_200)
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clip(componentShapes.small),
        leadingIcon = {
            Icon(
                painter = painterResource(id = drawable),
                contentDescription = ""
            )
        },
        trailingIcon = {
            val icon = if (passwordVisible) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff
            }

            val description = if (passwordVisible) {
                stringResource(R.string.hide_password)
            } else {
                stringResource(R.string.show_password)
            }

            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = icon, contentDescription = description)
            }
        },
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        singleLine = true,
        maxLines = 1,
        keyboardActions = KeyboardActions {
            localFocusManager.clearFocus()
        }
    )
}

@Composable
fun CheckBoxComponent(value: String, onTextSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        var checkedState by remember {
            mutableStateOf(false)
        }
        Checkbox(
            checked = checkedState,
            onCheckedChange = {
                checkedState = !checkedState
            }
        )
        ClickableTextComponent(value = value, onTextSelected = onTextSelected)
    }
}

@Composable
fun ClickableTextComponent(value: String, onTextSelected: (String) -> Unit) {
    val initialString = "By continuing You accept our "
    val privacyPolicyText = "Privacy Policy"
    val andText = " and "
    val termsAndConditionsText = "Terms of Use"

    val annotatedString = buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.purple_200))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.purple_200))) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }
    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("TAG", "ClickableTextComponent: $span")

                if (span.item == termsAndConditionsText || span.item == privacyPolicyText) {
                    onTextSelected(span.item)
                }
            }

    })
}

@Composable
fun ButtonComponent(value: String) {
    Button(
        onClick = { /*TODO*/ }, modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(id = R.color.purple_200),
                            colorResource(id = R.color.purple_500)
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(text = value, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun DividerTextComponent() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.gray),
            thickness = 1.dp
        )

        Text(
            text = stringResource(R.string.or),
            modifier = Modifier.padding(8.dp),
            fontSize = 14.sp
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(id = R.color.gray),
            thickness = 1.dp
        )
    }

}

@Composable
fun ClickableTextLoginComponent(onTextSelected: (String) -> Unit) {
    val initialString = "Already have an account? "
    val loginText = "Login"

    val annotatedString = buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.purple_200))) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }

    ClickableText(text = annotatedString, modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->

                    if (span.item == loginText) {
                        onTextSelected(span.item)
                    }
                }

        })
}


@Composable
fun ClickableTextSignupComponent(onTextSelected: (String) -> Unit) {
    val initialString = "Don't have an account yet? "
    val signupText = "Signup"

    val annotatedString = buildAnnotatedString {
        append(initialString)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.purple_200))) {
            pushStringAnnotation(tag = signupText, annotation = signupText)
            append(signupText)
        }
    }

    ClickableText(text = annotatedString, modifier = Modifier.fillMaxWidth(),
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 21.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ), onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->

                    if (span.item == signupText) {
                        onTextSelected(span.item)
                    }
                }

        })
}