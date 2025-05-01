package com.rilla.frontend.auth.ui


import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    Button(onClick = onLoginSuccess) {
        Text("Log in (placeholder)")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(onLoginSuccess = {})
}