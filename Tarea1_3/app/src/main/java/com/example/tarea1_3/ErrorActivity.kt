package com.example.tarea1_3

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea1_3.databinding.ActivityErrorBinding

/**
 * Actividad que se muestra cuando el usuario ingresa credenciales incorrectas.
 */
class ErrorActivity : AppCompatActivity() {

    // Referencia para la vinculación de vistas (View Binding) de activity_error.xml
    private lateinit var binding: ActivityErrorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Infla el diseño XML usando View Binding y establece el contenido de la vista
        binding = ActivityErrorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes según las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // El botón de reintentar cierra esta pantalla para volver a la pantalla anterior (Login)
        binding.btnReintentar.setOnClickListener {
            finish()
        }

        // Navega a la pantalla para restablecer la contraseña en modo olvido
        binding.tvOlvido.setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java).apply {
                putExtra("modoOlvido", true)
            }
            startActivity(intent)
        }
    }
}
