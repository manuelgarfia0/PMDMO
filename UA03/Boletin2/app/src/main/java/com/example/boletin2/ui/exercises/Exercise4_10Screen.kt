package com.example.boletin2.ui.exercises

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise4_10Screen(onBack: () -> Unit) {
    var isDark by remember { mutableStateOf(false) }

    val animatedBgColor by animateColorAsState(
        targetValue = if (isDark) Color(0xFF121212) else Color(0xFFFAFAFA),
        animationSpec = tween(durationMillis = 600)
    )

    val animatedCardColor by animateColorAsState(
        targetValue = if (isDark) Color(0xFF1E1E1E) else Color(0xFFFFFFFF),
        animationSpec = tween(durationMillis = 600)
    )

    val animatedTextColor by animateColorAsState(
        targetValue = if (isDark) Color(0xFFE0E0E0) else Color(0xFF212121),
        animationSpec = tween(durationMillis = 600)
    )

    val animatedButtonColor by animateColorAsState(
        targetValue = if (isDark) Color(0xFFBB86FC) else Color(0xFF6200EE),
        animationSpec = tween(durationMillis = 600)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 4.10 — Animación de Tema") },
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
                .background(animatedBgColor)
                .padding(24.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp),
                colors = CardDefaults.cardColors(containerColor = animatedCardColor),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = if (isDark) "Tema Oscuro Animado" else "Tema Claro Animado",
                        style = MaterialTheme.typography.headlineSmall,
                        color = animatedTextColor
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Transiciones suaves con animateColorAsState",
                        style = MaterialTheme.typography.bodyMedium,
                        color = animatedTextColor.copy(alpha = 0.7f)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { isDark = !isDark },
                        colors = ButtonDefaults.buttonColors(containerColor = animatedButtonColor)
                    ) {
                        Text(if (isDark) "Cambiar a Claro" else "Cambiar a Oscuro")
                    }
                }
            }
        }
    }
}
