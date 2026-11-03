package com.example.contactos

interface ContactoPulsadoListener {
    fun contactoPulsado(contacto: Contacto) {}
    fun contactoInfoPulsado(contacto: Contacto) {}
    fun contactoCorreoPulsado(contacto: Contacto) {}
}