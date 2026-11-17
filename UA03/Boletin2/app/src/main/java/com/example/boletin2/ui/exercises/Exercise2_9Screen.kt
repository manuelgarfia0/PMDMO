package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise2_9Screen(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 2.9 — Panel con Secciones") },
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
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Encabezado
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Términos y Condiciones",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Por favor, lea atentamente la información antes de aceptar.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Cuerpo scrollable
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp)
                ) {
                    Text(
                        text = "1. Introducción\nEste documento establece los términos y condiciones bajo los cuales se rige el uso de nuestra aplicación móvil.\n\n" +
                                "2. Uso de los Servicios\nEl usuario se compromete a hacer un uso adecuado y lícito de los servicios ofrecidos, respetando la normativa vigente.\n\n" +
                                "3. Privacidad y Datos\nGarantizamos la confidencialidad de los datos personales proporcionados por los usuarios de acuerdo con la ley de protección de datos.\n\n" +
                                "4. Modificaciones\nNos reservamos el derecho de modificar estos términos en cualquier momento, notificando a los usuarios mediante la propia aplicación.\n\n" +
                                "5. Aceptación\nEl uso continuado de la plataforma implica la aceptación expresa de las presentes condiciones.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Pie con botones
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.End)
            ) {
                OutlinedButton(onClick = onBack) {
                    Text("Cancelar")
                }
                Button(onClick = onBack) {
                    Text("Aceptar")
                }
            }
        }
    }
}
