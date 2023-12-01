/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
public class Pelicula {

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
    private String titulo;
    private String genero;
    private String productora;
    private String director;

    // Constructor
    public Pelicula(String titulo, String genero, String productora, String director) {
        this.titulo = titulo;
        this.genero = genero;
        this.productora = productora;
        this.director = director;
    }

}
