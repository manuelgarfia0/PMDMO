package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Fruta(val nombre: String, val icono: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_1Screen(onBack: () -> Unit) {
    val frutas = listOf(
        Fruta("Manzana", "🍎"),
        Fruta("Plátano", "🍌"),
        Fruta("Fresa", "🍓"),
        Fruta("Naranja", "🍊"),
        Fruta("Pera", "🍐")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.1 — Lista de Frutas") },
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
            items(frutas) { fruta ->
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
                        Text(
                            text = fruta.icono,
                            fontSize = 28.sp
                        )
                        Text(
                            text = fruta.nombre,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}
