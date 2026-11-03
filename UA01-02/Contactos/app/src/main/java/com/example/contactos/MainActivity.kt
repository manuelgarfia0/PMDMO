package com.example.contactos

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactos.databinding.ActivityMainBinding

import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.vistaContactos.layoutManager = LinearLayoutManager(this)
        binding.vistaContactos.adapter = ContactosAdapter(
            listOf(
                Contacto("Juan", "611123456", "juan@gmail.com"),
                Contacto("María", "678456123", "maria@gmail.com"),
                Contacto("Raúl", "644789456", "raul@gmail.com"),
                Contacto("Ana", "693882147", "ana@gmail.com"),
                Contacto("Carlos", "655112233", "carlos@gmail.com"),
                Contacto("Laura", "622334455", "laura@gmail.com"),
                Contacto("Pedro", "633445566", "pedro@gmail.com"),
                Contacto("Lucía", "644556677", "lucia@gmail.com"),
                Contacto("David", "655667788", "david@gmail.com"),
                Contacto("Sofía", "666778899", "sofia@gmail.com"),
                Contacto("Alejandro", "677889900", "alejandro@gmail.com"),
                Contacto("Elena", "688990011", "elena@gmail.com"),
                Contacto("Javier", "699001122", "javier@gmail.com"),
                Contacto("Carmen", "611223344", "carmen@gmail.com"),
                Contacto("Diego", "622446688", "diego@gmail.com"),
                Contacto("Paula", "633557799", "paula@gmail.com"),
                Contacto("Pablo", "644668800", "pablo@gmail.com"),
                Contacto("Isabel", "655779911", "isabel@gmail.com"),
                Contacto("Fernando", "666880022", "fernando@gmail.com")
            ),
            object : ContactoPulsadoListener {
                // Intent implicito para llamar al contacto
                override fun contactoPulsado(contacto: Contacto) {
                    Snackbar.make(
                        binding.root,
                        "Iniciando llamada a ${contacto.nombre} (${contacto.tfno})...",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    val dial = Intent(
                        Intent.ACTION_DIAL,
                        ("tel:" + contacto.tfno).toUri()
                    )
                    startActivity(dial)
                }

                // Intent explicito para ver información del contacto
                override fun contactoInfoPulsado(contacto: Contacto) {
                    Snackbar.make(
                        binding.root,
                        "Abriendo detalle de ${contacto.nombre}...",
                        Snackbar.LENGTH_SHORT
                    ).show()

                    val intent = Intent(this@MainActivity, DetalleActivity::class.java).apply {
                        putExtra("nombre", contacto.nombre)
                        putExtra("telefono", contacto.tfno)
                        putExtra("correo", contacto.correo)
                    }
                    startActivity(intent)
                }
            }
        )
    }
}