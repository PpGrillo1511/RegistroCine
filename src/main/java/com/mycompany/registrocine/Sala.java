/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author jloza
 */
public class Sala {
    private Asiento[][] asientos;

    public Sala(int filas, int columnas) {
        this.asientos = new Asiento[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.asientos[i][j] = new Asiento();
            }
        }
    }

    public boolean reservarAsiento(int fila, int columna) {
        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
            return false; // Asiento fuera de los límites
        }

        if (asientos[fila][columna].isOcupado()) {
            return false; // El asiento ya está ocupado
        }

        asientos[fila][columna].reservarAsiento(); // Reservar el asiento
        return true;
    }

    public boolean liberarAsiento(int fila, int columna) {
        if (fila < 0 || fila >= asientos.length || columna < 0 || columna >= asientos[0].length) {
            return false; // Asiento fuera de los límites
        }

        if (!asientos[fila][columna].isOcupado()) {
            return false; // El asiento no estaba ocupado
        }

        asientos[fila][columna].liberarAsiento(); // Liberar el asiento
        return true;
    }
}

