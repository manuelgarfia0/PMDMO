package com.example.boletin2.ui.exercises

import android.util.Patterns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class RegistroUiState(
    val nombre: String = "",
    val correo: String = "",
    val contrasena: String = "",
    val nombreTocado: Boolean = false,
    val correoTocado: Boolean = false,
    val contrasenaTocado: Boolean = false,
    val mostrarContrasena: Boolean = false,
    val registradoExitoso: Boolean = false
) {
    val nombreError: String? = when {
        !nombreTocado -> null
        nombre.isBlank() -> "El nombre no puede estar vacío"
        else -> null
    }

    val correoError: String? = when {
        !correoTocado -> null
        correo.isBlank() -> "El correo no puede estar vacío"
        !Patterns.EMAIL_ADDRESS.matcher(correo).matches() -> "Formato de correo no válido"
        else -> null
    }

    val contrasenaError: String? = when {
        !contrasenaTocado -> null
        contrasena.length < 8 -> "La contraseña debe tener al menos 8 caracteres"
        else -> null
    }

    val esValido: Boolean = nombre.isNotBlank() &&
            Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
            contrasena.length >= 8
}

class RegistroViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegistroUiState())
    val uiState: StateFlow<RegistroUiState> = _uiState.asStateFlow()

    fun onNombreChanged(nombre: String) {
        _uiState.update { it.copy(nombre = nombre, nombreTocado = true) }
    }

    fun onCorreoChanged(correo: String) {
        _uiState.update { it.copy(correo = correo, correoTocado = true) }
    }

    fun onContrasenaChanged(contrasena: String) {
        _uiState.update { it.copy(contrasena = contrasena, contrasenaTocado = true) }
    }

    fun toggleMostrarContrasena() {
        _uiState.update { it.copy(mostrarContrasena = !it.mostrarContrasena) }
    }

    fun registrar() {
        if (_uiState.value.esValido) {
            _uiState.update { it.copy(registradoExitoso = true) }
        }
    }

    fun reiniciar() {
        _uiState.value = RegistroUiState()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise5_2Screen(
    onBack: () -> Unit,
    viewModel: RegistroViewModel = viewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 5.2 — Formulario ViewModel") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("← Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (state.registradoExitoso) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text(
                            text = "¡Registro Exitoso!",
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Text(
                            text = "Nombre: ${state.nombre}\nCorreo: ${state.correo}",
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(onClick = { viewModel.reiniciar() }) {
                            Text("Registrar otro usuario")
                        }
                    }
                }
            } else {
                Text(
                    text = "Crea una cuenta",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.Start)
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = state.nombre,
                    onValueChange = { viewModel.onNombreChanged(it) },
                    label = { Text("Nombre") },
                    isError = state.nombreError != null,
                    supportingText = { state.nombreError?.let { Text(it, color = MaterialTheme.colorScheme.error) } },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = state.correo,
                    onValueChange = { viewModel.onCorreoChanged(it) },
                    label = { Text("Correo electrónico") },
                    isError = state.correoError != null,
                    supportingText = { state.correoError?.let { Text(it, color = MaterialTheme.colorScheme.error) } },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedTextField(
                    value = state.contrasena,
                    onValueChange = { viewModel.onContrasenaChanged(it) },
                    label = { Text("Contraseña") },
                    isError = state.contrasenaError != null,
                    supportingText = { state.contrasenaError?.let { Text(it, color = MaterialTheme.colorScheme.error) } },
                    visualTransformation = if (state.mostrarContrasena) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        IconButton(onClick = { viewModel.toggleMostrarContrasena() }) {
                            Icon(
                                imageVector = if (state.mostrarContrasena) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                                contentDescription = "Mostrar contraseña"
                            )
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = { viewModel.registrar() },
                    enabled = state.esValido,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Registrarse")
                }
            }
        }
    }
}
