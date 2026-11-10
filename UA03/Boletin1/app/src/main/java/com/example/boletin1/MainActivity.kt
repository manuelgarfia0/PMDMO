package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.boletin1.ui.theme.Boletin1Theme
import com.example.boletin1.views.DevConnectApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var isDarkMode by rememberSaveable { mutableStateOf(false) }

            Boletin1Theme(darkTheme = isDarkMode) {
                DevConnectApp(
                    modifier = Modifier.fillMaxSize(),
                    isDarkMode = isDarkMode,
                    onThemeChanged = { isDarkMode = it }
                )
            }
        }
    }
}
