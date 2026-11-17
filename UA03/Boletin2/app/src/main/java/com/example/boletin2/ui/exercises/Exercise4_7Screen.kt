package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_7Screen(onBack: () -> Unit) {
    val themeA = lightColorScheme(
        primary = Color(0xFF0D47A1), // Blue
        primaryContainer = Color(0xFFBBDEFB),
        onPrimaryContainer = Color(0xFF0D47A1)
    )

    val themeB = darkColorScheme(
        primary = Color(0xFFB71C1C), // Red
        primaryContainer = Color(0xFFFFCDD2),
        onPrimaryContainer = Color(0xFFB71C1C)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.7 — Temas por Sección") },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Sección A (Tema Azul)
            MaterialTheme(colorScheme = themeA) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Sección A (Tema Azul)",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = { }) {
                            Text("Botón Sección A")
                        }
                    }
                }
            }

            // Sección B (Tema Rojo/Oscuro)
            MaterialTheme(colorScheme = themeB) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Sección B (Tema Rojo)",
                            style = MaterialTheme.typography.titleLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Button(onClick = { }) {
                            Text("Botón Sección B")
                        }
                    }
                }
            }
        }
    }
}
