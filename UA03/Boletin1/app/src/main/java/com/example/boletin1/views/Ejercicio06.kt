package com.example.boletin1.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boletin1.ui.theme.Boletin1Theme

/**
 * Ejercicio 6: Selección de Rol Principal (RadioButton)
 *
 * Muestra un selector de opción única para definir la especialidad del desarrollador.
 */
@Composable
fun RoleSelector(
    modifier: Modifier = Modifier,
    externalSelectedRole: String? = null,
    onRoleSelected: ((String) -> Unit)? = null
) {
    val roles = listOf("Frontend", "Backend", "Mobile", "Fullstack")
    var localSelectedRole by rememberSaveable { mutableStateOf(roles[2]) }

    val selectedRole = externalSelectedRole ?: localSelectedRole
    val updateRole = onRoleSelected ?: { localSelectedRole = it }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Selecciona tu rol principal:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.selectableGroup()) {
            roles.forEach { role ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .selectable(
                            selected = (role == selectedRole),
                            onClick = { updateRole(role) },
                            role = Role.RadioButton
                        )
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (role == selectedRole),
                        onClick = { updateRole(role) }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = role,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RoleSelectorPreview() {
    Boletin1Theme {
        RoleSelector()
    }
}
