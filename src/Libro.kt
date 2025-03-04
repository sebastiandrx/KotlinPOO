package org.example

class Libro(
    var titulo: String = "",
    var autor: String = "",
    var isbn: String = "",
    var noPaginas: Int = 0,
    var precio: Double = 0.0,
    var cantidadDisponible: Int = 0
) {
    fun mostrarInfoLibro() {
        println("""
            Título: $titulo
            Autor: $autor
            ISBN: $isbn
            Número de Páginas: $noPaginas
            Precio: $$precio
            Cantidad Disponible: $cantidadDisponible
        """.trimIndent())
    }

    fun prestarLibro(cantidad: Int): Boolean {
        return if (cantidadDisponible >= cantidad) {
            cantidadDisponible -= cantidad
            true
        } else {
            false
        }
    }

    fun devolverLibro(cantidad: Int): Boolean {
        cantidadDisponible += cantidad
        return true
    }
}