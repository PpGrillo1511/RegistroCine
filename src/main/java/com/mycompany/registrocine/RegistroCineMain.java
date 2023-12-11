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
                                                    4. Reservar asiento
                                                    5. Mostrar mapa de asientos
                                                    6. Salir""");

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
                    String tituloPelicula = JOptionPane.showInputDialog("Ingrese el título de la película:");
                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila del asiento:"));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna del asiento:"));

                    if (listaPeliculas.reservarAsiento(tituloPelicula, fila, columna)) {
                        JOptionPane.showMessageDialog(null, "Asiento reservado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El asiento está ocupado o la película no se encuentra en el registro.");
                    }
                    break;
                case "5":
                    // Lógica para mostrar el mapa de asientos
                    break;
                case "6":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
