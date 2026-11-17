package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_6Screen(onBack: () -> Unit) {
    var vistaActual by remember { mutableStateOf("perfil") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.6 — Alternador de Vistas") },
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
            Button(
                onClick = {
                    vistaActual = if (vistaActual == "perfil") "configuracion" else "perfil"
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(if (vistaActual == "perfil") "Cambiar a Configuración" else "Cambiar a Perfil")
            }

            Spacer(modifier = Modifier.height(32.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    if (vistaActual == "perfil") {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "👤 Vista de Perfil",
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Nombre: Carlos Ruiz\nEmail: carlos@example.com",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    } else {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(
                                text = "⚙️ Vista de Configuración",
                                style = MaterialTheme.typography.headlineMedium,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Notificaciones: Activadas\nIdioma: Español",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                    }
                }
            }
        }
    }
}
