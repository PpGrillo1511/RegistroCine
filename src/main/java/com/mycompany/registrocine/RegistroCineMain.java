package com.mycompany.registrocine;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RegistroCineMain {
    public static void main(String[] args) {
        ListaPeliculas listaPeliculas = new ListaPeliculas();

        while (true) {
            String opcion = (String) JOptionPane.showInputDialog(null,
                    "Seleccione una opción:",
                    "Menú",
                    JOptionPane.PLAIN_MESSAGE,
                    new ImageIcon("logo.png/"),  // Ruta de la imagen
                    new String[]{"Agregar película", "Eliminar película", "Buscar película",
                            "Reservar asiento", "Mostrar todas las películas", "Mostrar mapa de asientos", "Salir"},
                    "Agregar película");

            switch (opcion) {
                case "Agregar película":
                    listaPeliculas.agregarPelicula();
                    break;
                case "Eliminar película":
                    listaPeliculas.eliminarPelicula();
                    break;
                case "Buscar película":
                    listaPeliculas.buscarPelicula();
                    break;
                case "Reservar asiento":
                    String tituloPelicula = JOptionPane.showInputDialog("Ingrese el título de la película:");
                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de fila del asiento:"));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de columna del asiento:"));

                    if (listaPeliculas.reservarAsiento(tituloPelicula, fila, columna)) {
                        JOptionPane.showMessageDialog(null, "Asiento reservado correctamente.");
                    } else {
                        JOptionPane.showMessageDialog(null, "El asiento está ocupado o la película no se encuentra en el registro.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Mostrar todas las películas":
                    listaPeliculas.mostrarTodasLasPeliculas();
                    break;
                case "Mostrar mapa de asientos":
                    // Lógica para mostrar el mapa de asientos
                    JOptionPane.showMessageDialog(null, "Funcion no implementada :(", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
                case "Salir":
                    JOptionPane.showMessageDialog(null, "Saliendo del programa.", "Saliendo", JOptionPane.CLOSED_OPTION);
                    System.exit(0);
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        }
    }
}
