package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise5_5Screen(onBack: () -> Unit) {
    var segundos by remember { mutableStateOf(10) }
    var corriendo by remember { mutableStateOf(false) }

    LaunchedEffect(corriendo) {
        while (corriendo && segundos > 0) {
            delay(1000)
            segundos--
        }
        if (segundos == 0) {
            corriendo = false
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 5.5 — Cuenta Atrás (LaunchedEffect)") },
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
                text = if (segundos > 0) "$segundos s" else "¡Tiempo!",
                style = MaterialTheme.typography.displayLarge,
                color = if (segundos > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { corriendo = true },
                    enabled = !corriendo && segundos > 0
                ) {
                    Text("Iniciar")
                }

                OutlinedButton(
                    onClick = { corriendo = false },
                    enabled = corriendo
                ) {
                    Text("Pausar")
                }

                Button(
                    onClick = {
                        corriendo = false
                        segundos = 10
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                ) {
                    Text("Reiniciar")
                }
            }
        }
    }
}
