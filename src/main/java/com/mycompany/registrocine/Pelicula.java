/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
// Representa una película en el cine
public class Pelicula {
    private String titulo;
    private String genero;
    private String productora;
    private String director;
    private Sala sala; // La película está asociada a una sala específica

    // Constructor que crea una nueva película con su información y sala asociada
    public Pelicula(String titulo, String genero, String productora, String director, int filas, int columnas) {
        this.titulo = titulo;
        this.genero = genero;
        this.productora = productora;
        this.director = director;
        this.sala = new Sala(filas, columnas);
    }

    // Getter para obtener la sala asociada a la película
    public Sala getSala() {
        return sala;
    }

    // Getters para los atributos de la película (título, género, etc.)
    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getProductora() {
        return productora;
    }

    public String getDirector() {
        return director;
    }
}
