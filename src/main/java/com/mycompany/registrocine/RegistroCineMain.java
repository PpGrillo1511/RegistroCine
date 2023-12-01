/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrocine;

/**
 *
 * @author PC 17
 */
import javax.swing.JOptionPane;

public class RegistroCineMain {
    public static void main(String[] args) {
        ListaPeliculas listaPeliculas = new ListaPeliculas();

        while (true) {
            String opcion = JOptionPane.showInputDialog("""
                                                        Seleccione una opci\u00f3n:
                                                        1. Agregar pel\u00edcula
                                                        2. Eliminar pel\u00edcula
                                                        3. Buscar pel\u00edcula por t\u00edtulo
                                                        4. Salir""");

            switch (opcion) {
                case "1":
                    listaPeliculas.agregarPelicula();
                    break;
                case "2":
                    listaPeliculas.eliminarPelicula();
                    break;
                case "3":
                    listaPeliculas.buscarPorTitulo();
                    break;
                case "4":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}

