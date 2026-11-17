package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_5Screen(onBack: () -> Unit) {
    var c1 by remember { mutableStateOf(0) }
    var c2 by remember { mutableStateOf(0) }
    var c3 by remember { mutableStateOf(0) }

    val totalSum = c1 + c2 + c3

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.5 — Contador Múltiple") },
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
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Suma Total",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "$totalSum",
                        style = MaterialTheme.typography.displayMedium,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            CounterRow("Contador 1", c1, onIncrement = { c1++ }, onDecrement = { if (c1 > 0) c1-- })
            Spacer(modifier = Modifier.height(16.dp))
            CounterRow("Contador 2", c2, onIncrement = { c2++ }, onDecrement = { if (c2 > 0) c2-- })
            Spacer(modifier = Modifier.height(16.dp))
            CounterRow("Contador 3", c3, onIncrement = { c3++ }, onDecrement = { if (c3 > 0) c3-- })
        }
    }
}

@Composable
fun CounterRow(label: String, value: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {
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
                text = "$label: $value",
                style = MaterialTheme.typography.titleMedium
            )
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onDecrement) {
                    Text("–")
                }
                Button(onClick = onIncrement) {
                    Text("+")
                }
            }
        }
    }
}
