package com.example.boletin2.ui.exercises

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_12Screen(onBack: () -> Unit) {
    var mostrarAvanzadas by remember { mutableStateOf(false) }
    var slider1 by remember { mutableStateOf(0.5f) }
    var slider2 by remember { mutableStateOf(0.2f) }
    var slider3 by remember { mutableStateOf(0.8f) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.12 — Visibilidad Dinámica") },
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
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { mostrarAvanzadas = !mostrarAvanzadas },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (mostrarAvanzadas) "Ocultar opciones avanzadas" else "Mostrar opciones avanzadas")
            }

            AnimatedVisibility(visible = mostrarAvanzadas) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "Opciones Avanzadas",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )

                        Text("Volumen: ${(slider1 * 100).toInt()}%")
                        Slider(
                            value = slider1,
                            onValueChange = { slider1 = it }
                        )

                        Text("Brillo: ${(slider2 * 100).toInt()}%")
                        Slider(
                            value = slider2,
                            onValueChange = { slider2 = it }
                        )

                        Text("Velocidad: ${(slider3 * 100).toInt()}%")
                        Slider(
                            value = slider3,
                            onValueChange = { slider3 = it }
                        )
                    }
                }
            }
        }
    }
}
