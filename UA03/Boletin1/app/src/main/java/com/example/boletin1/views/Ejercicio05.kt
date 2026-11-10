package com.example.boletin1.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 5: Formulario de Registro Estilizado (OutlinedTextField)
 *
 * Campos para correo electrónico y contraseña con tipos de teclado adecuados y transformación visual para la contraseña.
 */
@Composable
fun RegisterForm(
    modifier: Modifier = Modifier,
    externalEmail: String? = null,
    onEmailChange: ((String) -> Unit)? = null,
    externalPassword: String? = null,
    onPasswordChange: ((String) -> Unit)? = null
) {
    var localEmail by rememberSaveable { mutableStateOf("") }
    var localPassword by rememberSaveable { mutableStateOf("") }

    val email = externalEmail ?: localEmail
    val updateEmail = onEmailChange ?: { localEmail = it }
    val password = externalPassword ?: localPassword
    val updatePassword = onPasswordChange ?: { localPassword = it }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Campo de Email
        OutlinedTextField(
            value = email,
            onValueChange = updateEmail,
            label = { Text("Correo electrónico") },
            placeholder = { Text("ejemplo@correo.com") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo de Contraseña
        OutlinedTextField(
            value = password,
            onValueChange = updatePassword,
            label = { Text("Contraseña") },
            placeholder = { Text("Ingresa tu contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterFormPreview() {
    Boletin1Theme {
        RegisterForm()
    }
}
