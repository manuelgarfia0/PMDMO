package com.example.boletin1.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Modelo de datos para un perfil de desarrollador en el directorio (con URL de avatar).
 */
data class DevProfile(
    val id: Int,
    val name: String,
    val role: String,
    val avatarUrl: String
)

/**
 * Ejercicio 15, 16, 17 y 18: Directorio de Desarrolladores (LazyColumn, Coil, Buscador y Me gusta)
 *
 * Muestra un listado de perfiles con barra de búsqueda y sistema de Me gusta interactivo por tarjeta.
 */
@Composable
fun DevDirectoryScreen(
    modifier: Modifier = Modifier
) {
    val developers = listOf(
        DevProfile(1, "Manuel Garfia", "Desarrollador Android Senior", "https://i.pravatar.cc/150?img=11"),
        DevProfile(2, "Ana Gómez", "Ingeniera Frontend", "https://i.pravatar.cc/150?img=5"),
        DevProfile(3, "Carlos Ruiz", "Arquitecto Backend", "https://i.pravatar.cc/150?img=3"),
        DevProfile(4, "Lucía Fernández", "Especialista Mobile (Kotlin/Swift)", "https://i.pravatar.cc/150?img=9"),
        DevProfile(5, "David Martínez", "Desarrollador Fullstack", "https://i.pravatar.cc/150?img=12"),
        DevProfile(6, "Sofía López", "Diseñadora UI/UX & Compose", "https://i.pravatar.cc/150?img=10"),
        DevProfile(7, "Jorge Pérez", "Ingeniero DevOps", "https://i.pravatar.cc/150?img=15"),
        DevProfile(8, "Elena Torres", "Experta en Ciberseguridad", "https://i.pravatar.cc/150?img=20"),
        DevProfile(9, "Raúl Sánchez", "Lider Técnico / Tech Lead", "https://i.pravatar.cc/150?img=33"),
        DevProfile(10, "Carmen Jimeno", "QA Automation Engineer", "https://i.pravatar.cc/150?img=32")
    )

    var searchQuery by rememberSaveable { mutableStateOf("") }

    val filteredDevelopers = developers.filter {
        it.name.contains(searchQuery, ignoreCase = true) ||
        it.role.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Directorio de Desarrolladores",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar por nombre o rol") },
            placeholder = { Text("Ej: Android, Ana...") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp)
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 400.dp),
            contentPadding = PaddingValues(vertical = 4.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(filteredDevelopers) { dev ->
                DevProfileCard(dev = dev)
            }
        }
    }
}

/**
 * Tarjeta individual para cada perfil con estado de "Me gusta" (Ejercicio 18).
 */
@Composable
fun DevProfileCard(dev: DevProfile) {
    var isLiked by rememberSaveable { mutableStateOf(false) }
    var likesCount by rememberSaveable { mutableIntStateOf(10 + dev.id * 3) }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = dev.avatarUrl,
                contentDescription = "Avatar de ${dev.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = dev.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = dev.role,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Botón de Me gusta (Ejercicio 18)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {
                        isLiked = !isLiked
                        likesCount = if (isLiked) likesCount + 1 else likesCount - 1
                    }
                ) {
                    Icon(
                        imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                        contentDescription = "Me gusta",
                        tint = if (isLiked) Color.Red else Color.Gray
                    )
                }
                Text(
                    text = likesCount.toString(),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DevDirectoryScreenPreview() {
    Boletin1Theme {
        DevDirectoryScreen()
    }
}
