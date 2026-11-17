package com.example.boletin2.ui.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

data class Mensaje(val texto: String, val esMio: Boolean, val hora: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_8Screen(onBack: () -> Unit) {
    val mensajes = listOf(
        Mensaje("¡Hola! ¿Qué tal vas con Jetpack Compose?", false, "10:00"),
        Mensaje("¡Hola! Muy bien, ya estoy creando layouts avanzados.", true, "10:01"),
        Mensaje("¡Genial! Los Modifiers y LazyColumn son muy potentes.", false, "10:02"),
        Mensaje("Totalmente de acuerdo, es súper intuitivo.", true, "10:03")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.8 — Chat Layout") },
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
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(mensajes) { msg ->
                    val alignment = if (msg.esMio) Alignment.End else Alignment.Start
                    val bubbleColor = if (msg.esMio) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                    val textColor = if (msg.esMio) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant

                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = alignment
                    ) {
                        Box(
                            modifier = Modifier
                                .widthIn(max = 280.dp)
                                .clip(
                                    RoundedCornerShape(
                                        topStart = 16.dp,
                                        topEnd = 16.dp,
                                        bottomStart = if (msg.esMio) 16.dp else 0.dp,
                                        bottomEnd = if (msg.esMio) 0.dp else 16.dp
                                    )
                                )
                                .background(bubbleColor)
                                .padding(12.dp)
                        ) {
                            Column {
                                Text(
                                    text = msg.texto,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = textColor
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = msg.hora,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = textColor.copy(alpha = 0.7f),
                                    modifier = Modifier.align(Alignment.End)
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Escribe un mensaje...") },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
