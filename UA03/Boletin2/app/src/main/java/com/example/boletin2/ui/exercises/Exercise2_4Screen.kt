package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

data class Tarea(val nombre: String, var completada: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_4Screen(onBack: () -> Unit) {
    val tareas = remember {
        mutableStateListOf(
            Tarea("Estudiar Jetpack Compose", false),
            Tarea("Hacer la compra", true),
            Tarea("Sacar al perro", false),
            Tarea("Revisar código fuente", false)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.4 — Lista de Tareas") },
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
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tareas) { tarea ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Checkbox(
                            checked = tarea.completada,
                            onCheckedChange = { checked ->
                                val index = tareas.indexOf(tarea)
                                if (index != -1) {
                                    tareas[index] = tarea.copy(completada = checked)
                                }
                            }
                        )
                        Text(
                            text = tarea.nombre,
                            style = MaterialTheme.typography.bodyLarge,
                            textDecoration = if (tarea.completada) TextDecoration.LineThrough else TextDecoration.None,
                            color = if (tarea.completada) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
