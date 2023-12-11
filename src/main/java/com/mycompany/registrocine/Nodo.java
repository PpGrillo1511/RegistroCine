/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
// Representa un nodo en una lista enlazada de películas
public class Nodo {
    private Pelicula pelicula; // Almacena una película
    private Nodo prev; // Referencia al nodo previo
    private Nodo next; // Referencia al nodo siguiente

    // Constructor para crear un nodo con una película
    public Nodo(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.prev = null;
        this.next = null;
    }

    // Getters y setters para acceder a la película y a los nodos previo y siguiente
    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Nodo getPrev() {
        return prev;
    }

    public void setPrev(Nodo prev) {
        this.prev = prev;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
}

