package com.example.contactos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle)

        val mainLayout = findViewById<View>(R.id.detalleMain)

        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val tvNombre = findViewById<TextView>(R.id.tvDetalleNombre)
        val tvTelefono = findViewById<TextView>(R.id.tvDetalleTelefono)
        val tvCorreo = findViewById<TextView>(R.id.tvDetalleCorreo)
        val btnCorreo = findViewById<Button>(R.id.btnDetalleCorreo)

        val nombre = intent.getStringExtra("nombre") ?: ""
        val telefono = intent.getStringExtra("telefono") ?: ""
        val correo = intent.getStringExtra("correo") ?: ""

        tvNombre.text = nombre
        tvTelefono.text = telefono
        tvCorreo.text = correo

        // Intent implicito para enviar correo
        btnCorreo.setOnClickListener {
            Snackbar.make(
                mainLayout,
                "Enviando correo a $correo...",
                Snackbar.LENGTH_SHORT
            ).show()

            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = ("mailto:$correo").toUri()
            }
            startActivity(emailIntent)
        }
    }
}
