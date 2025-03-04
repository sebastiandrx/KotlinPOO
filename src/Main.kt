package org.example

fun main() {
    // Lista de libros
    val libros = mutableListOf(
        Libro(
            titulo = "Don Quijote",
            autor = "Miguel de Cervantes",
            isbn = "0011",
            noPaginas = 863,
            precio = 29.99,
            cantidadDisponible = 5
        ),
        Libro(
            titulo = "Cien Años de Soledad",
            autor = "Gabriel García Márquez",
            isbn = "1100",
            noPaginas = 471,
            precio = 35.50,
            cantidadDisponible = 3
        ),
        Libro(
            titulo = "1984",
            autor = "George Orwell",
            isbn = "0101",
            noPaginas = 328,
            precio = 24.99,
            cantidadDisponible = 4
        ),
        Libro(
            titulo = "El Principito",
            autor = "Antoine de Saint-Exupéry",
            isbn = "1010",
            noPaginas = 96,
            precio = 15.99,
            cantidadDisponible = 6
        )
    )

    while (true) {
        println(
            """
            Bienvenidos a LIBROSMUNDO
            1. Prestar Libro
            2. Devolver Libro
            3. Listar Libros
            4. Salir
            """.trimIndent()
        )
        print("Elige una opcion: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                println("Ingrese el ISBN del libro a prestar:")
                val isbnPrestar = readLine() ?: ""

                val libroEncontrado = libros.find { libro -> libro.isbn == isbnPrestar }

                if (libroEncontrado != null) {
                    println("Cantidad de libros a prestar:")
                    val cantidadPrestar = readLine()?.toIntOrNull() ?: 0

                    if (libroEncontrado.prestarLibro(cantidadPrestar)) {
                        println("Libro prestado exitosamente")
                    } else {
                        println("No hay suficientes libros disponibles para préstar")
                    }
                } else {
                    println("Libro no encontrado")
                }
            }

            2 -> {
                println("Ingrese el ISBN del libro a devolver:")
                val isbnDevolver = readLine() ?: ""

                val libroEncontrado = libros.find { libro -> libro.isbn == isbnDevolver }

                if (libroEncontrado != null) {
                    println("Cantidad de libros a devolver:")
                    val cantidadDevolver = readLine()?.toIntOrNull() ?: 0

                    libroEncontrado.devolverLibro(cantidadDevolver)
                    println("Libro devuelto exitosamente")
                } else {
                    println("Libro no encontrado")
                }
            }

            3 -> {
                println("LISTA DE LIBROS:")
                libros.forEachIndexed { indice, libro ->
                    println("Libro ${indice + 1}:")
                    libro.mostrarInfoLibro()
                    println()
                }
            }

            4 -> {
                println("Gracias por usar LIBROSMUNDO. ¡Hasta luego!")
                break
            }

            null -> {
                println("Por favor, ingrese un número válido")
            }

            else -> {
                println("Opción no válida. Elija una opción entre 1 y 4.")
            }
        }

        println("Presione Enter para continuar...")
        readLine()
    }
}