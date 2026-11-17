package com.example.boletin1.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boletin1.ui.theme.Boletin1Theme
import java.util.Locale

/**
 * Ejercicio 9: Años de Experiencia (Slider)
 *
 * Permite al usuario ajustar su nivel de experiencia mediante un control deslizante.
 */
@Composable
fun ExperienceSlider(
    modifier: Modifier = Modifier,
    externalYears: Float? = null,
    onYearsChanged: ((Float) -> Unit)? = null
) {
    var localYears by rememberSaveable { mutableFloatStateOf(3f) }
    val years = externalYears ?: localYears
    val updateYears = onYearsChanged ?: { localYears = it }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Años de experiencia:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Slider(
            value = years,
            onValueChange = updateYears,
            valueRange = 0f..10f,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = String.format(Locale.getDefault(), "Experiencia: %.1f años", years),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExperienceSliderPreview() {
    Boletin1Theme {
        ExperienceSlider()
    }
}
