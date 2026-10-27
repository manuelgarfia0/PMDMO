package com.example.tarea1_3

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea1_3.databinding.ActivityAccesosBinding

/**
 * Actividad de Accesos e Intents Implícitos.
 * Permite realizar diversas acciones externas (buscar en el navegador, marcar por teléfono,
 * enviar SMS, compartir texto) según la entrada ingresada por el usuario.
 */
class AccesosActivity : AppCompatActivity() {

    // Referencia para la vinculación de vistas (View Binding) de activity_accesos.xml
    private lateinit var binding: ActivityAccesosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Habilita el diseño de borde a borde (edge-to-edge)
        enableEdgeToEdge()

        // Infla el diseño XML usando View Binding y establece el contenido de la vista
        binding = ActivityAccesosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ajusta los márgenes según las barras del sistema (estado y navegación)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Botón 1 -> Abre una búsqueda en el Navegador web con el texto ingresado
        binding.btnNavegador.setOnClickListener {
            val texto = textoEscrito() ?: return@setOnClickListener
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = "https://www.google.com/search?q=${Uri.encode(texto)}".toUri()
            abrir(intent)
        }

        // Botón 2 -> Abre el marcador telefónico con el número ingresado
        binding.btnTelefono.setOnClickListener {
            val numero = textoEscrito() ?: return@setOnClickListener
            abrir(Intent(Intent.ACTION_DIAL, "tel:$numero".toUri()))
        }

        // Botón 3 -> Abre la aplicación de SMS para enviar un mensaje
        binding.btnSms.setOnClickListener {
            val numero = textoEscrito() ?: return@setOnClickListener
            val smsIntent = Intent(Intent.ACTION_SENDTO)
            smsIntent.data = "smsto:$numero".toUri()
            smsIntent.putExtra("sms_body", "Hola desde mi app")
            abrir(smsIntent)
        }

        // Botón 4 -> Abre el selector del sistema para compartir texto en otras aplicaciones
        binding.btnCompartir.setOnClickListener {
            val texto = textoEscrito() ?: return@setOnClickListener
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, texto)
            abrir(Intent.createChooser(shareIntent, "Compartir con..."))
        }

        // Botón 5 -> Cierra la actividad para regresar a WelcomeActivity
        binding.btnVolver.setOnClickListener {
            finish()
        }

        // Botón para cerrar sesión -> redirige a MainActivity (Login) y limpia el stack de actividades
        binding.btnCerrarSesion.setOnClickListener {
            Toast.makeText(this, getString(R.string.toast_sesion_cerrada), Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            finish()
        }
    }

    /**
     * Obtiene el texto introducido en el campo de texto.
     * Si está vacío, muestra una notificación Toast y retorna null.
     */
    private fun textoEscrito(): String? {
        val texto = binding.etTexto.text.toString().trim()
        if (texto.isEmpty()) {
            Toast.makeText(this, "Escribe algo primero", Toast.LENGTH_SHORT).show()
            return null
        }
        return texto
    }

    /**
     * Intenta iniciar una actividad mediante un Intent implícito.
     * Si no existe ninguna aplicación en el dispositivo capaz de manejar la acción,
     * captura la excepción y muestra un mensaje de advertencia.
     */
    private fun abrir(intent: Intent) {
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, "No hay ninguna app para esta acción", Toast.LENGTH_SHORT).show()
        }
    }
}
