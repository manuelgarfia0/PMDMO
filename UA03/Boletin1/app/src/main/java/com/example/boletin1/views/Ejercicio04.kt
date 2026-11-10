package com.example.boletin1.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 4: Campo de Texto para Nombre de Usuario (TextField y State)
 *
 * Permite ingresar el nombre del usuario y mostrar un saludo en tiempo real utilizando estado (rememberSaveable).
 */
@Composable
fun UsernameInput(
    modifier: Modifier = Modifier,
    externalUsername: String? = null,
    onUsernameChange: ((String) -> Unit)? = null
) {
    var localUsername by rememberSaveable { mutableStateOf("") }
    val username = externalUsername ?: localUsername
    val updateUsername = onUsernameChange ?: { localUsername = it }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = updateUsername,
            label = { Text("Nombre de usuario") },
            placeholder = { Text("Ingresa tu nombre") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = if (username.isBlank()) "Hola," else "Hola, $username"
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UsernameInputPreview() {
    Boletin1Theme {
        UsernameInput()
    }
}
