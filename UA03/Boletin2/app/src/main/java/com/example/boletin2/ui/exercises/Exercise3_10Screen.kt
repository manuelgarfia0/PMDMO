package com.example.boletin2.ui.exercises

import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_10Screen(onBack: () -> Unit) {
    var contador by remember { mutableStateOf(0) }
    val animatedCount by animateIntAsState(targetValue = contador)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.10 — Contador Animado") },
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
                text = "$animatedCount",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { contador-- }) {
                    Text("– Decrementar")
                }
                Button(onClick = { contador++ }) {
                    Text("+ Incrementar")
                }
            }
        }
    }
}
