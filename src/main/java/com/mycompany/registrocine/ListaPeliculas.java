/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
import javax.swing.JOptionPane;

public class ListaPeliculas {
    private Nodo head;
    private Nodo tail;

    // Constructor
    public ListaPeliculas() {
        this.head = null;
        this.tail = null;
    }

    // Método para agregar películas
    public void agregarPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película:");
        String genero = JOptionPane.showInputDialog("Ingrese el género de la película:");
        String productora = JOptionPane.showInputDialog("Ingrese la productora de la película:");
        String director = JOptionPane.showInputDialog("Ingrese el director de la película:");

        Pelicula nuevaPelicula = new Pelicula(titulo, genero, productora, director);
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

    // Método para eliminar películas por título
    public void eliminarPelicula() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película a eliminar:");
        
        Nodo actual = head;
        while (actual != null) {
            if (actual.getPelicula().getTitulo().equalsIgnoreCase(titulo)) {
                Nodo previo = actual.getPrev();
                Nodo siguiente = actual.getNext();

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
                return;
            }
            actual = actual.getNext();
        }

        JOptionPane.showMessageDialog(null, "Película no encontrada.");
    }

    // Método para buscar película por título
    public void buscarPorTitulo() {
        String titulo = JOptionPane.showInputDialog("Ingrese el título de la película a buscar:");
        
        Nodo actual = head;
        while (actual != null) {
            if (actual.getPelicula().getTitulo().equalsIgnoreCase(titulo)) {
                JOptionPane.showMessageDialog(null, "Película encontrada:\n" +
                        "Título: " + actual.getPelicula().getTitulo() + "\n" +
                        "Género: " + actual.getPelicula().getGenero() + "\n" +
                        "Productora: " + actual.getPelicula().getProductora() + "\n" +
                        "Director: " + actual.getPelicula().getDirector());
                return;
            }
            actual = actual.getNext();
        }

        JOptionPane.showMessageDialog(null, "Película no encontrada.");
    }
}

