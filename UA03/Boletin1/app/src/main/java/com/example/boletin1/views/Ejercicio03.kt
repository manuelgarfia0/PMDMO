package com.example.boletin1.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boletin1.R
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 3: Tarjeta de Encabezado de Perfil (Column y Row)
 *
 * Integra el banner y el avatar en una Row horizontal con la información del desarrollador.
 */
@Composable
fun ProfileHeader(
    modifier: Modifier = Modifier,
    name: String = "Manuel Garfia",
    role: String = "Desarrollador Android Senior",
    resourceId: Int = R.drawable.ic_launcher_foreground
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(resourceId = resourceId)

        Spacer(modifier = Modifier.width(12.dp))

        Column {
            HeaderBanner(title = name)
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = role,
                fontSize = 14.sp,
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    Boletin1Theme {
        ProfileHeader()
    }
}
