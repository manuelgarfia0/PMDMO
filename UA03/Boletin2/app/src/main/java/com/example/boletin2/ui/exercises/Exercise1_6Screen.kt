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
fun Exercise1_6Screen(onBack: () -> Unit) {
    var contador by remember { mutableStateOf(0) }
    var mensaje by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.6 — Contador Limitado") },
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
            Text(
                text = "$contador",
                style = MaterialTheme.typography.displayLarge
            )
            Spacer(modifier = Modifier.height(12.dp))
            if (mensaje.isNotEmpty()) {
                Text(
                    text = mensaje,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Spacer(modifier = Modifier.height(24.dp))
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    if (contador > 0) {
                        contador--
                        mensaje = ""
                    }
                }) {
                    Text("–")
                }
                Button(onClick = {
                    if (contador < 10) {
                        contador++
                        if (contador == 10) {
                            mensaje = "¡Máximo alcanzado!"
                        }
                    }
                }) {
                    Text("+")
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedButton(onClick = {
                contador = 0
                mensaje = ""
            }) {
                Text("Reiniciar")
            }
        }
    }
}
