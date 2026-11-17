package com.example.contactosjpc.data

object ContactoRepository {

    val  lista = listOf(
        Contacto(1, "Juan García", "611123456", 1),
        Contacto(2, "María López", "678456123", 2),
        Contacto(3, "Raúl Cimas", "644789456", 1),
        Contacto(4, "Ana Morantes", "693882147", 2),
        Contacto(5, "Carlos Pérez", "622334455", 1),
        Contacto(6, "Lucía Gómez", "633445566", 2),
        Contacto(7, "Pedro Sánchez", "655667788", 1),
        Contacto(8, "Sofía Martínez", "666778899", 2),
        Contacto(9, "David Rodríguez", "677889900", 1),
        Contacto(10, "Elena Fernández", "688990011", 2)
    )

    fun getAllContacts(): List<Contacto> {
        return lista
    }


}