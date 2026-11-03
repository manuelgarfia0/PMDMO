package com.example.boletin1.views

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 1: Hola DevConnect (Composable y Preview)
 *
 * Muestra un banner de cabecera con el título introducido por parámetro.
 */
@Composable
fun HeaderBanner(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Blue,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun HeaderBannerPreview() {
    Boletin1Theme {
        HeaderBanner(title = "¡Hola DevConnect!")
    }
}
