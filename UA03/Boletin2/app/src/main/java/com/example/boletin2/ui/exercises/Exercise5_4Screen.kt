package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

data class SnackbarTask(val id: Int, val nombre: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise5_4Screen(onBack: () -> Unit) {
    val tareas = remember {
        mutableStateListOf(
            SnackbarTask(1, "Estudiar Jetpack Compose"),
            SnackbarTask(2, "Configurar Navigation Compose"),
            SnackbarTask(3, "Implementar Scaffold y Snackbar"),
            SnackbarTask(4, "Revisar arquitectura ViewModel")
        )
    }

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    var nextId by remember { mutableStateOf(5) }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 5.4 — Scaffold & Snackbar") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("← Volver")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    val nueva = SnackbarTask(nextId, "Nueva Tarea #${nextId}")
                    tareas.add(nueva)
                    nextId++
                    scope.launch {
                        snackbarHostState.showSnackbar("Tarea añadida con éxito")
                    }
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir tarea")
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(tareas, key = { it.id }) { tarea ->
                val index = tareas.indexOf(tarea)
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = tarea.nombre,
                            style = MaterialTheme.typography.bodyLarge
                        )
                        IconButton(onClick = {
                            val eliminada = tarea
                            val eliminadaIndex = index
                            tareas.remove(tarea)

                            scope.launch {
                                val result = snackbarHostState.showSnackbar(
                                    message = "Tarea eliminada",
                                    actionLabel = "Deshacer",
                                    duration = SnackbarDuration.Short
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    if (eliminadaIndex in 0..tareas.size) {
                                        tareas.add(eliminadaIndex, eliminada)
                                    } else {
                                        tareas.add(eliminada)
                                    }
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Borrar tarea",
                                tint = MaterialTheme.colorScheme.error
                            )
                        }
                    }
                }
            }
        }
    }
}
