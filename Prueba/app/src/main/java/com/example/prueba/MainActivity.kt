package com.example.prueba

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba.databinding.ActivityMainBinding
import androidx.core.net.toUri

class MainActivity : AppCompatActivity() {

    private val TAG = "CICLO_VIDA";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "A: onCreate creado")
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //val myIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "1122334455"));
        //startActivity(myIntent);

        //val boton = findViewById<Button>(R.id.miBoton)
        //boton.text = "¡Pulsame jeta!"

        binding.miBoton.text = "¡Púlsame!"
        binding.miBoton.setOnClickListener {
            val toast = Toast.makeText(
                applicationContext,
                "¡NO ME TOQUES!",
                Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        }
        // Explícito
        binding.buttomSend?.setOnClickListener {
            val message = binding.editTextMessage?.text.toString()
            val intent = Intent(this, WelcomeActivity::class.java).apply {
                putExtra("Extra_Message", message)
            }
            startActivity(intent)
        }
        // Implícito
        binding.buttomOpenBrowser?.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, "https://www.google.com".toUri())
            startActivity(intent)
        }

        binding.btnDialogoSistema?.setOnClickListener {
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 1001)
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "A: onStart llamado.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "A: onResume llamado - ¡La Activity es visible y activa!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "A: onPause llamado - Otra Activity toma el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "A: onStop llamado - La Activity ya no es visible")
        //setContentView(R.layout.stop)
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "A: onRestart llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "A: onDestroy llamado - La Activity está siendo destruida")
    }
}