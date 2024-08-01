package com.github.januprasad.datekmp

import androidx.compose.runtime.Composable
import ui.theme.AppTheme

@Composable
fun App(
    darkTheme: Boolean,
    dynamicColor: Boolean,
    content: @Composable () -> Unit
) {
    AppTheme(
        darkTheme = darkTheme,
        dynamicColor = dynamicColor
    ) {
        content()
    }
}