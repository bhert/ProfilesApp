package com.omni.profiles.navigation

import androidx.activity.ComponentActivity
import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalLifecycleOwner

private val LocalOnBackPressedDispatcher =
    staticCompositionLocalOf<OnBackPressedDispatcherOwner?> { null }

private class ComposableBackNavigationHandler(enabled: Boolean) : OnBackPressedCallback(enabled) {
    lateinit var onBackpressed: () -> Unit
    override fun handleOnBackPressed() {
        onBackpressed()
    }
}


@Composable
internal fun ComposableHandler(enabled: Boolean = true, onBckpressed: () -> Unit) {
    val dispatcher = (LocalOnBackPressedDispatcher.current ?: return).onBackPressedDispatcher
    val handler = remember {
        ComposableBackNavigationHandler(enabled)
    }

    DisposableEffect(dispatcher) {
        dispatcher.addCallback(handler)
        onDispose { handler.remove() }
    }

    LaunchedEffect(enabled) {
        handler.isEnabled = enabled
        handler.onBackpressed = onBckpressed
    }
}

@Composable
internal fun SystemBackButtonHandler(onBckpressed: () -> Unit) {
    CompositionLocalProvider(LocalOnBackPressedDispatcher provides LocalLifecycleOwner.current as ComponentActivity) {
        ComposableHandler {
            onBckpressed()
        }
    }
}