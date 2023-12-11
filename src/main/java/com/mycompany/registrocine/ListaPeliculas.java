/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author jloza
 */
import javax.swing.JOptionPane;

public class ListaPeliculas {
    private Nodo head; // Nodo inicial de la lista
    private Nodo tail; // Nodo final de la lista

    public ListaPeliculas() {
        this.head = null; // Inicialización del nodo inicial como nulo
        this.tail = null; // Inicialización del nodo final como nulo
    }

    // Método para buscar una película por su título
    private Nodo buscarPeliculaPorTitulo(String titulo) {
        Nodo actual = head; // Comienza desde el inicio de la lista
        while (actual != null) {
            // Itera a través de la lista y devuelve el nodo si el título coincide
            if (actual.getPelicula().getTitulo().equalsIgnoreCase(titulo)) {
                return actual;
            }
            actual = actual.getNext(); // Avanza al siguiente nodo
        }
        return null; // Retorna nulo si la película no se encuentra
    }

     // Método para reservar un asiento para una película
    public boolean reservarAsiento(String titulo, int fila, int columna) {
        Nodo nodoPelicula = buscarPeliculaPorTitulo(titulo); // Busca la película por su título
        if (nodoPelicula != null) {
            Pelicula pelicula = nodoPelicula.getPelicula();
            return pelicula.getSala().reservarAsiento(fila, columna); // Reserva el asiento si la película existe
        }
        return false; // Retorna falso si la película no se encuentra
    }

    public void agregarPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película:");
        String genero = JOptionPane.showInputDialog("Ingrese el género de la película:");
        String productora = JOptionPane.showInputDialog("Ingrese la productora de la película:");
        String director = JOptionPane.showInputDialog("Ingrese el director de la película:");

        // Verifica si algún campo está vacío
        if (titulo.isEmpty() || genero.isEmpty() || productora.isEmpty() || director.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        // Verifica si la película ya existe en la lista
        if (buscarPeliculaPorTitulo(titulo) != null) {
            JOptionPane.showMessageDialog(null, "La película ya existe en el registro.");
            return;
        }
        
        //Solicita la cantidad de filas y columnas de la sala
        int numFilas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas de la sala:"));
        int numColumnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas de la sala:"));

        // Crea una nueva película y un nuevo nodo para agregar a la lista
        Pelicula nuevaPelicula = new Pelicula(titulo, genero, productora, director, numFilas, numColumnas);
        Nodo nuevoNodo = new Nodo(nuevaPelicula);

        // Verifica si la lista está vacía para agregar la película como el primer elemento
        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
            // Agrega la película al final de la lista
            tail.setNext(nuevoNodo);
            nuevoNodo.setPrev(tail);
            tail = nuevoNodo;
        }

        JOptionPane.showMessageDialog(null, "Película agregada correctamente.");
    }

    public void eliminarPelicula() {
        if (head == null) {
        JOptionPane.showMessageDialog(null, "No hay películas registradas.");
        return;
    }
        
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película a eliminar:");

        Nodo peliculaAEliminar = buscarPeliculaPorTitulo(titulo);
        // Verifica si la película no se encuentra en la lista
        if (peliculaAEliminar == null) {
            JOptionPane.showMessageDialog(null, "La película no se encuentra en el registro.");
            return;
        }
        
        // Obtiene el nodo previo y siguiente al nodo de la película a eliminar
        Nodo previo = peliculaAEliminar.getPrev();
        Nodo siguiente = peliculaAEliminar.getNext();

        if (previo != null) {
            previo.setNext(siguiente);
        } else {
            head = siguiente;
        }

        if (siguiente != null) {
            siguiente.setPrev(previo);
        } else {
            tail = previo;
        }

        JOptionPane.showMessageDialog(null, "Película eliminada correctamente.");
    }
    
    public void mostrarAsientosOcupados(String tituloPelicula) {
    Nodo nodoPelicula = buscarPeliculaPorTitulo(tituloPelicula);

    if (nodoPelicula != null) {
        Pelicula pelicula = nodoPelicula.getPelicula();
        Sala sala = pelicula.getSala();

        Asiento[][] asientos = sala.getAsientos();
        int numFilas = asientos.length;
        int numColumnas = asientos[0].length;

        StringBuilder infoAsientosOcupados = new StringBuilder("Asientos ocupados para la película '" + tituloPelicula + "':\n");

        for (int i = 0; i < numFilas; i++) {
            for (int j = 0; j < numColumnas; j++) {
                if (asientos[i][j].isOcupado()) {
                    infoAsientosOcupados.append("Fila: ").append(i).append(", Columna: ").append(j).append("\n");
                }
            }
        }

        if (infoAsientosOcupados.length() == ("Asientos ocupados para la película '" + tituloPelicula + "':\n").length()) {
            JOptionPane.showMessageDialog(null, "No hay asientos ocupados para esta película.");
        } else {
            JOptionPane.showMessageDialog(null, infoAsientosOcupados.toString(), "Asientos ocupados", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "La película no se encuentra en el registro.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    
    public void mostrarTodasLasPeliculas() {
    Nodo actual = head;

    if (actual == null) {
        JOptionPane.showMessageDialog(null, "No hay películas registradas.");
        return;
    }
    // Crea una cadena con la información de todas las películas
    StringBuilder infoPeliculas = new StringBuilder("Peliculas Registradas:\n");

    while (actual != null) {
        Pelicula pelicula = actual.getPelicula();
        infoPeliculas.append("Título: ").append(pelicula.getTitulo()).append("\n");
        infoPeliculas.append("Género: ").append(pelicula.getGenero()).append("\n");
        infoPeliculas.append("Productora: ").append(pelicula.getProductora()).append("\n");
        infoPeliculas.append("Director: ").append(pelicula.getDirector()).append("\n\n");
        actual = actual.getNext();
    }

    JOptionPane.showMessageDialog(null, infoPeliculas.toString(), "Lista de Películas", JOptionPane.INFORMATION_MESSAGE);
}


    public void buscarPelicula() {
        if (head == null) {
        JOptionPane.showMessageDialog(null, "No hay películas registradas.");
        return;
    }
        String[] opcionesBusqueda = {"Título", "Género", "Productora", "Director"};
        String opcionElegida = (String) JOptionPane.showInputDialog(
                null,
                "Seleccione el criterio de búsqueda:",
                "Buscar película por:",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcionesBusqueda,
                opcionesBusqueda[0]);

        String busqueda = JOptionPane.showInputDialog("Ingrese el dato de la película a buscar:");

        Nodo actual = head;
        boolean encontrada = false;
        while (actual != null) {
            Pelicula pelicula = actual.getPelicula();
            boolean coincidencia = false;

            switch (opcionElegida) {
                case "Título":
                    coincidencia = pelicula.getTitulo().equalsIgnoreCase(busqueda);
                    break;
                case "Género":
                    coincidencia = pelicula.getGenero().equalsIgnoreCase(busqueda);
                    break;
                case "Productora":
                    coincidencia = pelicula.getProductora().equalsIgnoreCase(busqueda);
                    break;
                case "Director":
                    coincidencia  = pelicula.getDirector().equalsIgnoreCase(busqueda);
                    break;
            }

            if (coincidencia) {
                JOptionPane.showMessageDialog(null, "Película encontrada:\n" +
                        "Título: " + pelicula.getTitulo() + "\n" +
                        "Género: " + pelicula.getGenero() + "\n" +
                        "Productora: " + pelicula.getProductora() + "\n" +
                        "Director: " + pelicula.getDirector());

                encontrada = true;
            }
            actual = actual.getNext();
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "Película no encontrada en el registro.");
        }
    }
}

