package com.mycompany.registrocine;

import javax.swing.JOptionPane;

public class RegistroCineMain {
    public static void main(String[] args) {
        ListaPeliculas listaPeliculas = new ListaPeliculas();

        while (true) {
            String opcion = JOptionPane.showInputDialog("""
                                                    Seleccione una opción:
                                                    1. Agregar película
                                                    2. Eliminar película
                                                    3. Buscar película
                                                    4. Salir""");

            switch (opcion) {
                case "1":
                    listaPeliculas.agregarPelicula();
                    break;
                case "2":
                    listaPeliculas.eliminarPelicula();
                    break;
                case "3":
                    listaPeliculas.buscarPelicula();
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
