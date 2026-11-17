package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_5Screen(onBack: () -> Unit) {
    var useCustomTheme by remember { mutableStateOf(false) }

    val customColorScheme = lightColorScheme(
        primary = Color(0xFF6A1B9A), // Purple
        onPrimary = Color.White,
        primaryContainer = Color(0xFFE1BEE7),
        onPrimaryContainer = Color(0xFF4A148C),
        background = Color(0xFFF3E5F5),
        surface = Color.White,
        onSurface = Color(0xFF212121)
    )

    val activeColorScheme = if (useCustomTheme) customColorScheme else lightColorScheme()
    val activeShape = if (useCustomTheme) CutCornerShape(12.dp) else CardDefaults.shape

    MaterialTheme(
        colorScheme = activeColorScheme
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    TopAppBar(
                        title = { Text("Ejercicio 4.5 — Tema Completo") },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        ),
                        navigationIcon = {
                            TextButton(onClick = onBack) {
                                Text("← Volver", color = MaterialTheme.colorScheme.primary)
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
                            .height(200.dp),
                        shape = activeShape,
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = if (useCustomTheme) "Tema Personalizado (Morado/Corte)" else "Tema Predeterminado Material",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                            Spacer(modifier = Modifier.height(12.dp))
                            Text(
                                text = "Los colores, formas y estilos cambian según el tema activo.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(32.dp))

                    Button(
                        onClick = { useCustomTheme = !useCustomTheme },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(if (useCustomTheme) "Cambiar a Tema Predeterminado" else "Aplicar Tema Personalizado")
                    }
                }
            }
        }
    }
}
