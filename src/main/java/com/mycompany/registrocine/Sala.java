/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author jloza
 */
// Representa la sala de cine con asientos
public class Sala {
    private Asiento[][] asientos; // Matriz de asientos

    // Constructor que crea una sala con asientos vacíos
    public Sala(int filas, int columnas) {
        this.asientos = new Asiento[filas][columnas];
        // Inicializa cada asiento en la sala como no ocupado
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                this.asientos[i][j] = new Asiento();
            }
        }
    }

    // Reserva un asiento específico si está disponible
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

    // Libera un asiento específico si está ocupado
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
