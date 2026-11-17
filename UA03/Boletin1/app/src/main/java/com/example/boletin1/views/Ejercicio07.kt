package com.example.boletin1.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 7: Lista de Tecnologías de Interés (Checkbox)
 *
 * Permite seleccionar múltiples tecnologías conocidas y muestra el total de seleccionadas.
 */
@Composable
fun TechInterests(
    modifier: Modifier = Modifier
) {
    var isKotlinChecked by rememberSaveable { mutableStateOf(false) }
    var isComposeChecked by rememberSaveable { mutableStateOf(false) }
    var isCoroutinesChecked by rememberSaveable { mutableStateOf(false) }

    val techList = listOf(
        "Kotlin" to isKotlinChecked,
        "Jetpack Compose" to isComposeChecked,
        "Corrutinas" to isCoroutinesChecked
    )

    val count = techList.count { it.second }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Tecnologías de interés:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Kotlin
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { isKotlinChecked = !isKotlinChecked }
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isKotlinChecked,
                onCheckedChange = { isKotlinChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Kotlin")
        }

        // Jetpack Compose
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { isComposeChecked = !isComposeChecked }
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isComposeChecked,
                onCheckedChange = { isComposeChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Jetpack Compose")
        }

        // Corrutinas
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .clickable { isCoroutinesChecked = !isCoroutinesChecked }
                .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isCoroutinesChecked,
                onCheckedChange = { isCoroutinesChecked = it }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Corrutinas")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Tecnologías seleccionadas: $count de ${techList.size}",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TechInterestsPreview() {
    Boletin1Theme {
        TechInterests()
    }
}
