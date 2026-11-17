package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_8Screen(onBack: () -> Unit) {
    var textValue by remember { mutableStateOf("") }
    var hasError by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.8 — TextField Estilizado") },
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
            OutlinedTextField(
                value = textValue,
                onValueChange = {
                    textValue = it
                    hasError = it.length > 10
                },
                label = { Text("Introduce usuario (máx 10 chars)") },
                isError = hasError,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    unfocusedBorderColor = MaterialTheme.colorScheme.outline,
                    errorBorderColor = Color.Red,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    errorCursorColor = Color.Red
                ),
                modifier = Modifier.fillMaxWidth()
            )

            if (hasError) {
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "⚠️ El texto supera los 10 caracteres permitidos.",
                    color = Color.Red,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.align(Alignment.Start)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    hasError = textValue.isEmpty() || textValue.length > 10
                }
            ) {
                Text("Validar Campo")
            }
        }
    }
}
