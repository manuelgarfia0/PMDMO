package com.example.tarea1_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea1_3.databinding.ActivityWelcomeBinding

/**
 * Actividad de Bienvenida que saluda al usuario autenticado.
 */
class WelcomeActivity : AppCompatActivity() {

    // Referencia para la vinculación de vistas (View Binding) de activity_welcome.xml
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Infla el diseño XML usando View Binding y establece el contenido de la vista
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes según las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Recupera el nombre de usuario enviado a través del Intent desde MainActivity
        val usuarioRecibido = intent.getStringExtra("nombreUsuario")
        if (usuarioRecibido != null) {
            val nombre = usuarioRecibido.replaceFirstChar { it.uppercase() }
            binding.tvBienvenida.text = "¡Bienvenido, $usuarioRecibido!"
        }
        // Si no llega un nombre, se mantiene el texto por defecto definido en el layout XML

        // Configura el botón para continuar hacia la pantalla de accesos
        binding.btnContinuar.setOnClickListener {
            startActivity(Intent(this, AccesosActivity::class.java))
        }

        // Configura el botón para ir a la pantalla de cambiar contraseña
        binding.btnCambiarPassword.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
    }
}
