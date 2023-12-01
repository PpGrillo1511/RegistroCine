/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
public class Nodo {
    private Pelicula pelicula;
    private Nodo prev;
    private Nodo next;

    // Constructor que recibe una Pelicula como argumento
    public Nodo(Pelicula pelicula) {
        this.pelicula = pelicula;
        this.prev = null;
        this.next = null;
    }

    // Getters y Setters
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
