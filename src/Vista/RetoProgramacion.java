package Vista;

import java.util.Scanner;
import modelo.Gestion;

/**
 * Author Hugo García de la Plaza Menor
 * Clase principal del programa que gestiona usuarios, eventos e inscripciones.
 */
public class RetoProgramacion {
    
    /**
     * Método principal que ejecuta el programa.
     * 
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        // Arreglos para almacenar información de usuarios
        String[] nombres = new String[10];
        String[] usuarios = new String[10];
        String[] passwords = new String[10];
        int contadorUsuarios = 0;

        // Arreglos para almacenar información de eventos
        String[] nombresEventos = new String[10];
        String[] fechasEventos = new String[10];
        String[] ubicacionesEventos = new String[10];
        int contadorEventos = 0;

        // Matriz para almacenar inscripciones de usuarios en eventos
        int[][] inscripciones = new int[10][2];
        int contadorInscripciones = 0;

        // Bucle principal del programa
        do {
            opcion = Gestion.mostrarMenu(sc); // Muestra el menú y obtiene la opción del usuario

            switch (opcion) {
                case 1:
                    // Registro de usuario
                    if (!Gestion.registrarUsuario(nombres, usuarios, passwords, sc, contadorUsuarios)) {
                        System.out.println("No se pudo completar el registro del usuario");
                    } else {
                        contadorUsuarios++; // Incrementa el contador si el registro fue exitoso
                    }
                    break;
                case 2:
                    // Registro de evento
                    if (!Gestion.registrarEvento(nombresEventos, fechasEventos, ubicacionesEventos, sc, contadorEventos)) {
                        System.out.println("No se pudo completar el registro del evento");
                    } else {
                        contadorEventos++;
                    }
                    break;
                case 3:
                    // Inscripción de usuario en evento
                    if (!Gestion.realizarInscripcion(usuarios, nombresEventos, inscripciones, sc, contadorUsuarios, contadorEventos, contadorInscripciones)) {
                        System.out.println("No se pudo completar la inscripción");
                    } else {
                        contadorInscripciones++;
                    }
                    break;
                case 4:
                    // Mostrar lista de usuarios registrados
                    Gestion.mostrarUsuarios(nombres, usuarios, contadorUsuarios);
                    break;
                case 5:
                    // Mostrar lista de eventos registrados
                    Gestion.mostrarEventos(nombresEventos, fechasEventos, ubicacionesEventos, contadorEventos);
                    break;
                case 6:
                    // Mostrar inscripciones realizadas
                    Gestion.mostrarInscripciones(inscripciones, nombres, nombresEventos, contadorInscripciones);
                    break;
                case 0:
                    // Salida del programa
                    System.out.println("Adiós");
                    break;
                default:
                    // Manejo de opción no válida
                    System.out.println("Opción no válida");
            }
        } while (opcion != 0); // Repite hasta que el usuario elija salir
    }
}
