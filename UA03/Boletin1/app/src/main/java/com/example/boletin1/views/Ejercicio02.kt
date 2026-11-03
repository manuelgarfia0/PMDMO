package com.example.boletin1.views

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boletin1.R
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 2: Avatar del Desarrollador (Image y Modificadores)
 *
 * Muestra una imagen de perfil con tamaño fijo de 100.dp, forma circular y margen de 8.dp.
 */
@Composable
fun UserAvatar(
    @DrawableRes resourceId: Int,
    modifier: Modifier = Modifier
) {
    Image(
        painter = painterResource(id = resourceId),
        contentDescription = "Avatar del desarrollador",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .padding(8.dp)
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Preview(showBackground = true)
@Composable
fun UserAvatarPreview() {
    Boletin1Theme {
        UserAvatar(resourceId = R.drawable.ic_launcher_foreground)
    }
}
