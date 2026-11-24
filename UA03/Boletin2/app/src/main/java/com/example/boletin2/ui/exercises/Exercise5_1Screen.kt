package com.example.boletin2.ui.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ContadorViewModel : ViewModel() {
    private val _estado = MutableStateFlow(0)
    val estado: StateFlow<Int> = _estado.asStateFlow()

    fun incrementar() {
        _estado.update { (it + 1).coerceAtMost(10) }
    }

    fun decrementar() {
        _estado.update { (it - 1).coerceAtLeast(0) }
    }

    fun reiniciar() {
        _estado.value = 0
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exercise5_1Screen(
    onBack: () -> Unit,
    viewModel: ContadorViewModel = viewModel()
) {
    val valor by viewModel.estado.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ejercicio 5.1 — Contador ViewModel") },
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
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$valor",
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(16.dp))

            if (valor == 10) {
                Text(
                    text = "¡Máximo alcanzado!",
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodyLarge
                )
            } else {
                Spacer(modifier = Modifier.height(24.dp))
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { viewModel.decrementar() },
                    enabled = valor > 0
                ) {
                    Text("–")
                }
                Button(
                    onClick = { viewModel.incrementar() },
                    enabled = valor < 10
                ) {
                    Text("+")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(onClick = { viewModel.reiniciar() }) {
                Text("Reiniciar")
            }
        }
    }
}
