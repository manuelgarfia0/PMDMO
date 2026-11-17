package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise1_3Screen(onBack: () -> Unit) {
    val frases = listOf(
        "Sigue adelante",
        "Nunca te rindas",
        "El código es poesía",
        "Aprende algo nuevo hoy"
    )
    var fraseActual by remember { mutableStateOf(frases.random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.3 — Frases aleatorias") },
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
                text = "\"$fraseActual\"",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = { fraseActual = frases.random() }) {
                Text("Nueva frase")
            }
        }
    }
}
