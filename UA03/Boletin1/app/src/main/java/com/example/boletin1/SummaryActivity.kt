package com.example.boletin1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.boletin1.ui.theme.Boletin1Theme
import com.example.boletin1.views.ProfileSummaryCard

/**
 * Activity para mostrar la tarjeta resumen del Ejercicio 12 (recibida mediante Intent).
 */
class SummaryActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val name = intent.getStringExtra("EXTRA_NAME") ?: "Sin nombre"
        val email = intent.getStringExtra("EXTRA_EMAIL") ?: "Sin email"
        val role = intent.getStringExtra("EXTRA_ROLE") ?: "Mobile"
        val experience = intent.getFloatExtra("EXTRA_EXPERIENCE", 0f)

        setContent {
            Boletin1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ProfileSummaryCard(
                            name = name,
                            email = email,
                            role = role,
                            experienceYears = experience
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = { finish() },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(text = "Volver")
                        }
                    }
                }
            }
        }
    }
}
