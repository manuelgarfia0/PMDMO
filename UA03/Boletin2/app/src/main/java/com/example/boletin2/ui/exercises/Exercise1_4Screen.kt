package com.example.boletin2.ui.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise1_4Screen(onBack: () -> Unit) {
    val colores = listOf(Color.Red, Color.Blue, Color.Green, Color.Magenta, Color.Yellow, Color.Cyan)
    var colorActual by remember { mutableStateOf(colores.random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.4 — Cambiador de color") },
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
                    .size(150.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(colorActual)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                var nuevoColor: Color
                do {
                    nuevoColor = colores.random()
                } while (nuevoColor == colorActual)
                colorActual = nuevoColor
            }) {
                Text("Cambiar color")
            }
        }
    }
}
