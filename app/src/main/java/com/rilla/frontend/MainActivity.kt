package com.rilla.frontend

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.rilla.frontend.core.navigation.AppNavGraph
import com.rilla.frontend.ui.theme.RillafrontendTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RillafrontendTheme {
                val navController = rememberNavController()
                AppNavGraph(navController = navController)
            }
        }
    }
}