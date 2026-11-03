package com.example.tarea1_3

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea1_3.databinding.ActivityChangePasswordBinding

/**
 * Actividad que permite al usuario cambiar o restablecer su contraseña.
 * Si se accede desde "¿Olvidaste tu contraseña?", se oculta el campo de contraseña actual.
 */
class ChangePasswordActivity : AppCompatActivity() {

    // Referencia para la vinculación de vistas (View Binding) de activity_change_password.xml
    private lateinit var binding: ActivityChangePasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Infla el diseño XML usando View Binding y establece el contenido de la vista
        binding = ActivityChangePasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes según las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Comprueba si se ha abierto en modo "olvidó su contraseña"
        val esModoOlvido = intent.getBooleanExtra("modoOlvido", false)

        if (esModoOlvido) {
            // Oculta el campo de la contraseña actual si el usuario la olvidó
            binding.layoutCurrentPassword.visibility = View.GONE
            binding.tvTitulo.text = "Restablecer Contraseña"
            binding.btnSavePassword.text = "Restablecer Contraseña"
        }

        // Configura el evento del botón para guardar la nueva contraseña
        binding.btnSavePassword.setOnClickListener {
            val currentPass = binding.etCurrentPassword.text.toString().trim()
            val newPass = binding.etNewPassword.text.toString().trim()
            val confirmPass = binding.etConfirmPassword.text.toString().trim()

            // Validación de campos vacíos (si no está en modo olvido, también valida la contraseña actual)
            if ((!esModoOlvido && currentPass.isEmpty()) || newPass.isEmpty() || confirmPass.isEmpty()) {
                Toast.makeText(this, "Por favor, llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validación de coincidencia de contraseñas
            if (newPass != confirmPass) {
                Toast.makeText(this, "Las nuevas contraseñas no coinciden", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Éxito: notifica al usuario y cierra la pantalla
            Toast.makeText(this, "¡Contraseña actualizada con éxito!", Toast.LENGTH_SHORT).show()
            finish()
        }

        // Configura el botón para regresar a la pantalla anterior
        binding.btnVolver.setOnClickListener {
            finish()
        }
    }
}
