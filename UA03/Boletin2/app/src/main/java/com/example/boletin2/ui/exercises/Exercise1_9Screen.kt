package com.example.boletin2.ui.exercises

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Image
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise1_9Screen(onBack: () -> Unit) {
    val items = listOf(
        Triple("Paisaje Montañoso", Color.DarkGray, "Una hermosa vista de los Alpes en invierno."),
        Triple("Atardecer en la Playa", Color.Magenta, "Olas doradas bajo un sol radiante."),
        Triple("Bosque Encantado", Color.Green, "Árboles centenarios cubiertos de musgo."),
        Triple("Ciudad Nocturna", Color.Blue, "Luces de neón brillando en la metrópoli.")
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentItem = items[currentIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.9 — Galería Simple") },
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
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(currentItem.second.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Image,
                            contentDescription = currentItem.first,
                            modifier = Modifier.size(80.dp),
                            tint = currentItem.second
                        )
                        Text(
                            text = currentItem.first,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = currentItem.third,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    currentIndex = if (currentIndex > 0) currentIndex - 1 else items.size - 1
                }) {
                    Text("← Anterior")
                }

                Text(
                    text = "${currentIndex + 1} / ${items.size}",
                    style = MaterialTheme.typography.bodyMedium
                )

                Button(onClick = {
                    currentIndex = if (currentIndex < items.size - 1) currentIndex + 1 else 0
                }) {
                    Text("Siguiente →")
                }
            }
        }
    }
}
