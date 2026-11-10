package com.example.boletin1.views

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

/**
 * Ejercicio 14: Diálogo de Confirmación para Reiniciar (AlertDialog)
 *
 * Diálogo emergente de confirmación vinculado al botón flotante (FAB) de la app.
 */
@Composable
fun ResetConfirmationDialog(
    showDialog: Boolean,
    onDismiss: () -> Unit
) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = {
                Text(text = "¿Reiniciar formulario?")
            },
            text = {
                Text(text = "Se perderán todos los datos introducidos.")
            },
            confirmButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text(text = "Sí")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = onDismiss
                ) {
                    Text(text = "No")
                }
            }
        )
    }
}
