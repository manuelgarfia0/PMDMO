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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

data class Cita(val texto: String, val autor: String, val color: Color)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise1_10Screen(onBack: () -> Unit) {
    val citas = listOf(
        Cita("La simplicidad es el alma de la eficiencia.", "Austin Freeman", Color(0xFFE8F5E9)),
        Cita("Haz lo que puedas, con lo que tengas, donde estés.", "Theodore Roosevelt", Color(0xFFE3F2FD)),
        Cita("El código es como el humor. Cuando tienes que explicarlo, es malo.", "Cory House", Color(0xFFFFF3E0)),
        Cita("La innovación distingue a un líder de un seguidor.", "Steve Jobs", Color(0xFFFCE4EC))
    )

    var citaActual by remember { mutableStateOf(citas.random()) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 1.10 — Cita del Día") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("← Volver")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(citaActual.color),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = "“${citaActual.texto}”",
                            style = MaterialTheme.typography.titleLarge,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "— ${citaActual.autor}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontStyle = FontStyle.Italic,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(32.dp)
                )

                Button(onClick = {
                    var nuevaCita: Cita
                    do {
                        nuevaCita = citas.random()
                    } while (nuevaCita == citaActual)
                    citaActual = nuevaCita
                }) {
                    Text("Cambiar cita")
                }
            }
        }
    }
}
