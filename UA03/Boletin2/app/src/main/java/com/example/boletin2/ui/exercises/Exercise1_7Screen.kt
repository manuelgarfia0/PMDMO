package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise1_7Screen(onBack: () -> Unit) {
    var tamanoTexto by remember { mutableStateOf(24.sp) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.7 — Tamaño de Texto") },
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
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Texto ajustable",
                    fontSize = tamanoTexto
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
            ) {
                Button(onClick = {
                    if (tamanoTexto.value > 12f) {
                        tamanoTexto = (tamanoTexto.value - 4f).sp
                    }
                }) {
                    Text("Disminuir")
                }
                Button(onClick = {
                    if (tamanoTexto.value < 60f) {
                        tamanoTexto = (tamanoTexto.value + 4f).sp
                    }
                }) {
                    Text("Aumentar")
                }
            }
        }
    }
}
