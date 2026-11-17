package com.example.boletin2.ui.exercises

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_5Screen(onBack: () -> Unit) {
    val dias = listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo")
    var diaActivo by remember { mutableStateOf("Lunes") }

    val eventosPorDia = mapOf(
        "Lunes" to listOf("Reunión de equipo a las 10:00", "Entrega de proyecto", "Gimnasio a las 18:00"),
        "Martes" to listOf("Clase de Android", "Comida con clientes"),
        "Miércoles" to listOf("Revisión de código", "Médico a las 12:30"),
        "Jueves" to listOf("Desarrollo de nuevas features", "Cena con amigos"),
        "Viernes" to listOf("Retrospectiva semanal", "Cierre de sprints"),
        "Sábado" to listOf("Excursión a la montaña", "Cine"),
        "Domingo" to listOf("Descanso y lectura", "Preparar la semana")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.5 — Agenda Semanal") },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Selecciona un día:",
                style = MaterialTheme.typography.titleMedium
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(dias) { dia ->
                    val seleccionado = dia == diaActivo
                    Card(
                        modifier = Modifier
                            .clickable { diaActivo = dia },
                        colors = CardDefaults.cardColors(
                            containerColor = if (seleccionado) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant
                        ),
                        elevation = CardDefaults.cardElevation(defaultElevation = if (seleccionado) 4.dp else 1.dp)
                    ) {
                        Box(
                            modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = dia.take(3),
                                style = MaterialTheme.typography.titleMedium,
                                color = if (seleccionado) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Eventos para el $diaActivo:",
                style = MaterialTheme.typography.titleMedium
            )

            val eventos = eventosPorDia[diaActivo] ?: emptyList()
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(eventos) { evento ->
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                    ) {
                        Text(
                            text = "• $evento",
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}
