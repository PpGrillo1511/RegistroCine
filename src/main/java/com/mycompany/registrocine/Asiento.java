/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author jloza
 */
// Representa un asiento en la sala de cine
public class Asiento {
    private boolean ocupado; // Indica si el asiento está ocupado o no

    // Constructor para inicializar el asiento como no ocupado
    public Asiento() {
        this.ocupado = false;
    }

    // Devuelve true si el asiento está ocupado, false si está libre
    public boolean isOcupado() {
        return ocupado;
    }

    // Reserva el asiento, marcándolo como ocupado
    public void reservarAsiento() {
        this.ocupado = true;
    }

    // Libera el asiento, marcándolo como libre
    public void liberarAsiento() {
        this.ocupado = false;
    }
}

