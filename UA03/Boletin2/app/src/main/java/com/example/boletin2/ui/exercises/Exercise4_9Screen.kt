package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class StyledTask(val title: String, val status: String) // "Completada", "Pendiente", "Urgente"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_9Screen(onBack: () -> Unit) {
    val tasks = listOf(
        StyledTask("Diseñar interfaz de usuario", "Completada"),
        StyledTask("Corregir bugs de navegación", "Urgente"),
        StyledTask("Escribir pruebas unitarias", "Pendiente"),
        StyledTask("Actualizar dependencias Gradle", "Completada"),
        StyledTask("Revisar pull request", "Pendiente")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.9 — Tarjetas Condicionales") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("← Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(tasks) { task ->
                val (bgColor, textColor, badgeText) = when (task.status) {
                    "Completada" -> Triple(Color(0xFFE8F5E9), Color(0xFF2E7D32), "✓ Completada")
                    "Urgente" -> Triple(Color(0xFFFFEBEE), Color(0xFFC62828), "🔥 Urgente")
                    else -> Triple(Color(0xFFFFF8E1), Color(0xFFF57F17), "⏳ Pendiente")
                }

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = bgColor),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = task.title,
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.DarkGray
                            )
                        }
                        Surface(
                            shape = MaterialTheme.shapes.small,
                            color = textColor
                        ) {
                            Text(
                                text = badgeText,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                style = MaterialTheme.typography.labelMedium,
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}
