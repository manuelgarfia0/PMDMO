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

data class TaskItem(val id: Int, val title: String, var isDone: Boolean)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_4Screen(onBack: () -> Unit) {
    val tasks = remember {
        mutableStateListOf(
            TaskItem(1, "Aprender estados en Compose", false),
            TaskItem(2, "Configurar navegación", true),
            TaskItem(3, "Implementar LazyColumn", false),
            TaskItem(4, "Revisar arquitectura MVVM", false)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.4 — To-do List") },
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
            items(tasks) { task ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Checkbox(
                            checked = task.isDone,
                            onCheckedChange = { checked ->
                                val index = tasks.indexOf(task)
                                if (index != -1) {
                                    tasks[index] = task.copy(isDone = checked)
                                }
                            }
                        )
                        Text(
                            text = task.title,
                            style = MaterialTheme.typography.bodyLarge,
                            textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None,
                            color = if (task.isDone) MaterialTheme.colorScheme.onSurfaceVariant else MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }
    }
}
