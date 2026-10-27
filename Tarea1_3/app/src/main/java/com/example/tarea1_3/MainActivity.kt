package com.example.tarea1_3

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea1_3.databinding.ActivityMainBinding

/**
 * Actividad principal de Inicio de Sesión (Login).
 * Permite al usuario ingresar sus credenciales para autenticarse en la aplicación.
 */
class MainActivity : AppCompatActivity() {

    // Referencia para la vinculación de vistas (View Binding) de activity_main.xml
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Infla el diseño XML usando View Binding y establece el contenido de la vista
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes para no superponerse con las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configura el evento de clic para el botón de inicio de sesión
        binding.btnLogin.setOnClickListener {
            val usuario = binding.etUser.text.toString()
            val password = binding.etPassword.text.toString()

            // Valida si las credenciales son correctas
            if (usuario == "manuel" && password == "1234") {
                // Muestra un mensaje de éxito
                Toast.makeText(this, "¡Login correcto!", Toast.LENGTH_SHORT).show()

                // Crea el Intent para navegar a WelcomeActivity y pasa el nombre de usuario
                val intent = Intent(this, WelcomeActivity::class.java).apply {
                    putExtra("nombreUsuario", usuario)
                }
                startActivity(intent)
                finish() // Cierra MainActivity para que el usuario no pueda volver al Login con el botón atrás
            } else {
                // Muestra un mensaje de error y navega a ErrorActivity
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ErrorActivity::class.java))
            }
        }
    }
}
