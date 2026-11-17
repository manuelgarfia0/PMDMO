package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_4Screen(onBack: () -> Unit) {
    var radioEsquinas by remember { mutableStateOf(24.dp) }
    var elevacion by remember { mutableStateOf(8.dp) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.4 — Formas Personalizadas") },
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
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                shape = RoundedCornerShape(radioEsquinas),
                elevation = CardDefaults.cardElevation(defaultElevation = elevacion),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Tarjeta Personalizada",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Radio: ${radioEsquinas.value.toInt()} dp | Elevación: ${elevacion.value.toInt()} dp",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(onClick = {
                        radioEsquinas = if (radioEsquinas == 24.dp) 8.dp else 24.dp
                        elevacion = if (elevacion == 8.dp) 16.dp else 8.dp
                    }) {
                        Text("Cambiar Forma y Sombra")
                    }
                }
            }
        }
    }
}
