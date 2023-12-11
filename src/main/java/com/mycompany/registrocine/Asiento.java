/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author jloza
 */
public class Asiento {
    private boolean ocupado;

    public Asiento() {
        this.ocupado = false;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void reservarAsiento() {
        this.ocupado = true;
    }

    public void liberarAsiento() {
        this.ocupado = false;
    }
}
