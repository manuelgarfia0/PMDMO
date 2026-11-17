package com.example.boletin1.views

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.boletin1.R
import com.example.boletin1.SummaryActivity
import com.example.boletin1.ui.theme.Boletin1Theme
import kotlinx.coroutines.launch

/**
 * Ejercicio 13, 14, 15, 16, 17, 18, 19 y 20: Estructura Principal, Snackbar y Control de Tema Visual (Switch)
 *
 * Integra todas las vistas y permite alternar entre modo claro y modo oscuro.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DevConnectApp(
    modifier: Modifier = Modifier,
    isDarkMode: Boolean = false,
    onThemeChanged: (Boolean) -> Unit = {}
) {
    val context = LocalContext.current
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var showDialog by rememberSaveable { mutableStateOf(false) }

    // Estados del formulario para pasar mediante Intent al Ejercicio 12 (SummaryActivity)
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var selectedRole by rememberSaveable { mutableStateOf("Mobile") }
    var years by rememberSaveable { mutableFloatStateOf(3.5f) }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "DevConnect - Boletín 1",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                },
                actions = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text(
                            text = if (isDarkMode) "🌙" else "☀️",
                            fontSize = 16.sp
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Switch(
                            checked = isDarkMode,
                            onCheckedChange = onThemeChanged
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF1E88E5)
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showDialog = true
                },
                containerColor = Color(0xFF1E88E5),
                contentColor = Color.White
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Refrescar"
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .imePadding(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Ejercicio 1
            item {
                HeaderBanner(title = "¡Hola DevConnect!")
            }

            item { HorizontalDivider() }

            // Ejercicio 2
            item {
                UserAvatar(resourceId = R.drawable.ic_launcher_foreground)
            }

            item { HorizontalDivider() }

            // Ejercicio 3
            item {
                ProfileHeader(name = username.ifBlank { "Manuel Garfia" })
            }

            item { HorizontalDivider() }

            // Ejercicio 4
            item {
                UsernameInput(
                    externalUsername = username,
                    onUsernameChange = { username = it }
                )
            }

            item { HorizontalDivider() }

            // Ejercicio 5
            item {
                RegisterForm(
                    externalEmail = email,
                    onEmailChange = { email = it },
                    externalPassword = password,
                    onPasswordChange = { password = it }
                )
            }

            item { HorizontalDivider() }

            // Ejercicio 6
            item {
                RoleSelector(
                    externalSelectedRole = selectedRole,
                    onRoleSelected = { selectedRole = it }
                )
            }

            item { HorizontalDivider() }

            // Ejercicio 7
            item {
                TechInterests()
            }

            item { HorizontalDivider() }

            // Ejercicio 8
            item {
                NotificationSettings()
            }

            item { HorizontalDivider() }

            // Ejercicio 9
            item {
                ExperienceSlider(
                    externalYears = years,
                    onYearsChanged = { years = it }
                )
            }

            item { HorizontalDivider() }

            // Ejercicio 11 & 19: Botón Guardar -> Muestra Snackbar y lanza Intent a SummaryActivity (Ejercicio 12)
            item {
                SubmitButton(
                    onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Perfil guardado correctamente")
                        }
                        val intent = Intent(context, SummaryActivity::class.java).apply {
                            putExtra("EXTRA_NAME", username)
                            putExtra("EXTRA_EMAIL", email)
                            putExtra("EXTRA_ROLE", selectedRole)
                            putExtra("EXTRA_EXPERIENCE", years)
                        }
                        context.startActivity(intent)
                    }
                )
            }

            item { HorizontalDivider() }

            // Ejercicios 15, 16, 17 y 18: Directorio con Buscador y "Me gusta" (DevDirectoryScreen)
            item {
                DevDirectoryScreen()
            }
        }

        // Diálogo de confirmación (Ejercicio 14) vinculado al FAB del Ejercicio 13
        ResetConfirmationDialog(
            showDialog = showDialog,
            onDismiss = { showDialog = false }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DevConnectAppPreview() {
    Boletin1Theme {
        DevConnectApp()
    }
}
