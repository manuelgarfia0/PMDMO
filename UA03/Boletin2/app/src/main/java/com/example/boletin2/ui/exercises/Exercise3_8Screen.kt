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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

data class CarouselItem(val title: String, val color: Color, val desc: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise3_8Screen(onBack: () -> Unit) {
    val items = listOf(
        CarouselItem("Imagen 1: Amanecer", Color(0xFFFFCC80), "Primeros rayos de sol sobre el horizonte."),
        CarouselItem("Imagen 2: Océano", Color(0xFF81D4FA), "Aguas cristalinas y tranquilas."),
        CarouselItem("Imagen 3: Bosque", Color(0xFFA5D6A7), "Verde intenso entre la niebla matutina."),
        CarouselItem("Imagen 4: Galaxia", Color(0xFFCE93D8), "Estrellas y nebulosas lejanas.")
    )

    var currentIndex by remember { mutableStateOf(0) }
    val currentItem = items[currentIndex]

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 3.8 — Carrusel de Imágenes") },
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
                    .height(260.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(currentItem.color),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Image,
                            contentDescription = currentItem.title,
                            modifier = Modifier.size(64.dp),
                            tint = Color.DarkGray
                        )
                        Text(
                            text = currentItem.title,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.DarkGray
                        )
                        Text(
                            text = currentItem.desc,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.DarkGray
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
                    style = MaterialTheme.typography.titleMedium
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
