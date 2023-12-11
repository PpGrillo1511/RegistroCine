package com.mycompany.registrocine;

import javax.swing.JOptionPane;

public class ListaPeliculas {
    private Nodo head;
    private Nodo tail;

    public ListaPeliculas() {
        this.head = null;
        this.tail = null;
    }

    private Nodo buscarPeliculaPorTitulo(String titulo) {
        Nodo actual = head;
        while (actual != null) {
            if (actual.getPelicula().getTitulo().equalsIgnoreCase(titulo)) {
                return actual;
            }
            actual = actual.getNext();
        }
        return null;
    }

    public boolean reservarAsiento(String titulo, int fila, int columna) {
        Nodo nodoPelicula = buscarPeliculaPorTitulo(titulo);
        if (nodoPelicula != null) {
            Pelicula pelicula = nodoPelicula.getPelicula();
            return pelicula.getSala().reservarAsiento(fila, columna);
        }
        return false;
    }

    public void agregarPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película:");
        String genero = JOptionPane.showInputDialog("Ingrese el género de la película:");
        String productora = JOptionPane.showInputDialog("Ingrese la productora de la película:");
        String director = JOptionPane.showInputDialog("Ingrese el director de la película:");

        if (titulo.isEmpty() || genero.isEmpty() || productora.isEmpty() || director.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.");
            return;
        }

        if (buscarPeliculaPorTitulo(titulo) != null) {
            JOptionPane.showMessageDialog(null, "La película ya existe en el registro.");
            return;
        }

        int numFilas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de filas de la sala:"));
        int numColumnas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de columnas de la sala:"));

        Pelicula nuevaPelicula = new Pelicula(titulo, genero, productora, director, numFilas, numColumnas);
        Nodo nuevoNodo = new Nodo(nuevaPelicula);

        if (head == null) {
            head = nuevoNodo;
            tail = nuevoNodo;
        } else {
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

        if (peliculaAEliminar == null) {
            JOptionPane.showMessageDialog(null, "La película no se encuentra en el registro.");
            return;
        }

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
    
    public void mostrarTodasLasPeliculas() {
    Nodo actual = head;

    if (actual == null) {
        JOptionPane.showMessageDialog(null, "No hay películas registradas.");
        return;
    }

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

