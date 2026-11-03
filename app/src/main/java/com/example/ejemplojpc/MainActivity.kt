package com.example.ejemplojpc

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ejemplojpc.ui.theme.EjemploJPCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EjemploJPCTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        Text("Top bar")
                    },
                    bottomBar = {
                        Text("Bottom bar")
                    },
                    floatingActionButton = {
                        Button(onClick = {   }) {
                            Text(text = "+")
                        }
                    }
                ) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val contexto = LocalContext.current
    var texto by remember { mutableStateOf("Hola") }
    Column(modifier = modifier.padding(20.dp)) {
        Text(
            text = "Hello $name!",
            modifier = modifier.background(Color.Green)
        )
        Image(
            painterResource(R.drawable.ic_launcher_foreground),
            contentDescription = "Prueba de imagen"
        )
        Button(
            onClick = {
                Toast.makeText(contexto, "Hola", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text(text = "Pulsame")
        }
        TextField(value = texto, onValueChange = {
            texto = it
        })
        OutlinedTextField(label = { Text("Hola") }, value = texto, onValueChange = {
            texto = it
        })
        Row(modifier = modifier.background(Color.Green).fillMaxWidth().height(100.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Column {
                Text(text = "Hola 1")
                Text(text = "Hola 2")
            }
            Column {
                Text(text = "Mundo 1")
                Text(text = "Mundo 2")
            }
        }
    }
}

@Preview
@Composable
fun Boton(){
    Button(onClick = { /*TODO*/ }) {
        Text(text = "Hola")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjemploJPCTheme {
        Greeting("Android")
    }
}