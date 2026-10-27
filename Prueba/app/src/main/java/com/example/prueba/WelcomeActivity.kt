package com.example.prueba

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {

    val TAG = "CICLO_VIDA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "B: onCreate creado")
        enableEdgeToEdge()

        val binding = ActivityWelcomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.textViewMessage.text = intent.getStringExtra("Extra_Message") ?: "No hay mensaje"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "B: onStart llamado.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "B: onResume llamado - ¡La Activity es visible y activa!")
        Toast.makeText(this, getString(R.string.toast_actividad_b), Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "B: onPause llamado - Otra Activity toma el foco")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "B: onStop llamado - La Activity ya no es visible")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "B: onRestart llamado - Volviendo de estar 'stopped'")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "B: onDestroy llamado - La Activity está siendo destruida")
    }
}