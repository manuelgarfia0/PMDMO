package com.example.contactosjpc.ui.views

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.contactosjpc.data.ContactoRepository

@Composable
fun ContactsScreen(modifier: Modifier = Modifier) {
    val lista = ContactoRepository.getAllContacts()
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {	// Scroll vertical,
            items(lista) { itemContacto ->
                ContactRow(contacto = itemContacto)
            }
        }
    }
}
