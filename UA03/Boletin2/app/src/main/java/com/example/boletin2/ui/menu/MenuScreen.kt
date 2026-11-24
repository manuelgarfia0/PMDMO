package com.example.boletin2.ui.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class ExerciseItem(val id: Int, val title: String, val description: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(
    listState: LazyListState = rememberLazyListState(),
    onSelectExercise: (Int) -> Unit
) {
    val boletin1 = listOf(
        ExerciseItem(1, "Ejercicio 1.1", "Tu primera UI (Texto y Botón)"),
        ExerciseItem(2, "Ejercicio 1.2", "Tarjeta de presentación"),
        ExerciseItem(3, "Ejercicio 1.3", "Frases aleatorias"),
        ExerciseItem(4, "Ejercicio 1.4", "Cambiador de color"),
        ExerciseItem(5, "Ejercicio 1.5", "Tarjeta de perfil interactiva"),
        ExerciseItem(6, "Ejercicio 1.6", "Contador con límites y reinicio"),
        ExerciseItem(7, "Ejercicio 1.7", "Cambiador de tamaño de texto"),
        ExerciseItem(8, "Ejercicio 1.8", "Alternador de tema"),
        ExerciseItem(9, "Ejercicio 1.9", "Galería simple"),
        ExerciseItem(10, "Ejercicio 1.10", "Generador de citas del día")
    )

    val boletin2 = listOf(
        ExerciseItem(21, "Ejercicio 2.1", "Lista de elementos (Frutas)"),
        ExerciseItem(22, "Ejercicio 2.2", "Layout flexible (Row y weight)"),
        ExerciseItem(23, "Ejercicio 2.3", "Tarjeta de producto"),
        ExerciseItem(24, "Ejercicio 2.4", "Lista de tareas (To-do list)"),
        ExerciseItem(25, "Ejercicio 2.5", "Agenda semanal (LazyRow + LazyColumn)"),
        ExerciseItem(26, "Ejercicio 2.6", "Diseño tipo dashboard (Grid 2 columnas)"),
        ExerciseItem(27, "Ejercicio 2.7", "Galería en cuadrícula 3x3 con zoom"),
        ExerciseItem(28, "Ejercicio 2.8", "Chat layout (Burbujas de chat)"),
        ExerciseItem(29, "Ejercicio 2.9", "Panel con secciones (Scrollable)"),
        ExerciseItem(30, "Ejercicio 2.10", "Ficha de perfil completa (Card flotante)"),
        ExerciseItem(31, "Ejercicio 2.11", "Distribución adaptable (Landscape/Portrait)"),
        ExerciseItem(32, "Ejercicio 2.12", "Layout dinámico con visibilidad y sliders")
    )

    val boletin3 = listOf(
        ExerciseItem(41, "Ejercicio 3.1", "Contador simple con límite"),
        ExerciseItem(42, "Ejercicio 3.2", "Campo de texto en vivo"),
        ExerciseItem(43, "Ejercicio 3.3", "Alternador de tema"),
        ExerciseItem(44, "Ejercicio 3.4", "Lista de tareas interactiva"),
        ExerciseItem(45, "Ejercicio 3.5", "Contador múltiple (Suma total)"),
        ExerciseItem(46, "Ejercicio 3.6", "Alternador de vistas (Perfil / Config)"),
        ExerciseItem(47, "Ejercicio 3.7", "Slider interactivo (Tamaño de texto)"),
        ExerciseItem(48, "Ejercicio 3.8", "Alternador de imágenes (Carrusel)"),
        ExerciseItem(49, "Ejercicio 3.9", "Menú desplegable (DropdownMenu)"),
        ExerciseItem(50, "Ejercicio 3.10", "Contador con animación numérica")
    )

    val boletin4 = listOf(
        ExerciseItem(61, "Ejercicio 4.1", "Alternar tema claro/oscuro"),
        ExerciseItem(62, "Ejercicio 4.2", "Tipografía personalizada"),
        ExerciseItem(63, "Ejercicio 4.3", "Colores dinámicos en botones"),
        ExerciseItem(64, "Ejercicio 4.4", "Formas personalizadas (RoundedCornerShape)"),
        ExerciseItem(65, "Ejercicio 4.5", "Aplicando un tema completo"),
        ExerciseItem(66, "Ejercicio 4.6", "Botones estilizados (Gradiente, Border, Icono)"),
        ExerciseItem(67, "Ejercicio 4.7", "Temas dinámicos por sección"),
        ExerciseItem(68, "Ejercicio 4.8", "TextField estilizado con error"),
        ExerciseItem(69, "Ejercicio 4.9", "Tarjetas con estilo condicional"),
        ExerciseItem(70, "Ejercicio 4.10", "Animación de tema suave")
    )

    val boletin5 = listOf(
        ExerciseItem(81, "Ejercicio 5.1", "Contador con ViewModel y StateFlow"),
        ExerciseItem(82, "Ejercicio 5.2", "Formulario con validación y UiState"),
        ExerciseItem(83, "Ejercicio 5.3", "Navegación entre pantallas (NavHost)"),
        ExerciseItem(84, "Ejercicio 5.4", "Scaffold, FAB y Snackbar con deshacer"),
        ExerciseItem(85, "Ejercicio 5.5", "Cuenta atrás con LaunchedEffect")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Boletín de Ejercicios Compose") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { padding ->
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Text(
                    text = "Boletín 1 — Fundamentos y Estado",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(boletin1) { exercise ->
                ExerciseCard(exercise = exercise, onSelect = onSelectExercise)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Boletín 2 — Layouts y Estructura",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(boletin2) { exercise ->
                ExerciseCard(exercise = exercise, onSelect = onSelectExercise)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Boletín 3 — Estado y Eventos",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(boletin3) { exercise ->
                ExerciseCard(exercise = exercise, onSelect = onSelectExercise)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Boletín 4 — Temas y Estilos",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(boletin4) { exercise ->
                ExerciseCard(exercise = exercise, onSelect = onSelectExercise)
            }

            item {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Boletín 5 — Arquitectura y Navegación",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
            items(boletin5) { exercise ->
                ExerciseCard(exercise = exercise, onSelect = onSelectExercise)
            }
        }
    }
}

@Composable
fun ExerciseCard(exercise: ExerciseItem, onSelect: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect(exercise.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = exercise.title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = exercise.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
