package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_7Screen(onBack: () -> Unit) {
    var fontSizeValue by remember { mutableStateOf(24f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.7 — Slider Interactivo") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("← Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Texto Dinámico (${fontSizeValue.toInt()}.sp)",
                    fontSize = fontSizeValue.sp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Tamaño: ${fontSizeValue.toInt()} sp",
                style = MaterialTheme.typography.bodyMedium
            )

            Slider(
                value = fontSizeValue,
                onValueChange = { fontSizeValue = it },
                valueRange = 12f..60f,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
