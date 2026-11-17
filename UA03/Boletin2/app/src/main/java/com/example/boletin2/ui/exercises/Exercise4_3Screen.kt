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
fun Exercise4_3Screen(onBack: () -> Unit) {
    var mensajeEstado by remember { mutableStateOf("Pulsa un botón de color") }
    var colorEstado by remember { mutableStateOf(Color.Gray) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.3 — Colores Dinámicos") },
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
                    .height(120.dp),
                colors = CardDefaults.cardColors(containerColor = colorEstado.copy(alpha = 0.2f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = mensajeEstado,
                        style = MaterialTheme.typography.titleMedium,
                        color = colorEstado
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    onClick = {
                        mensajeEstado = "¡Has pulsado el botón Rojo!"
                        colorEstado = Color.Red
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Botón Rojo")
                }

                Button(
                    onClick = {
                        mensajeEstado = "¡Has pulsado el botón Azul!"
                        colorEstado = Color.Blue
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Botón Azul")
                }

                Button(
                    onClick = {
                        mensajeEstado = "¡Has pulsado el botón Verde!"
                        colorEstado = Color(0xFF2E7D32)
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF2E7D32),
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Botón Verde")
                }
            }
        }
    }
}
