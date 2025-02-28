package modelo;

import java.util.*;

public class Gestion {
    public static int mostrarMenu(Scanner sc) {
        System.out.println("=== GESTIÓN DE EVENTOS SOSTENIBLES ===");
        System.out.println("1. Registrar usuario");
        System.out.println("2. Registrar evento");
        System.out.println("3. Realizar inscripción");
        System.out.println("4. Mostrar usuarios");
        System.out.println("5. Mostrar eventos");
        System.out.println("6. Mostrar inscripciones");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public static boolean registrarUsuario(String[] nombres, String[] usuarios, String[] passwords, Scanner sc, int contadorUsuarios) {
        if (contadorUsuarios >= 100) {
            System.out.println("Error: No hay espacio para más usuarios");
            return false;
        }

        sc.nextLine();
        System.out.println("\n=== REGISTRO DE USUARIO ===");
        System.out.print("Nombre completo: ");
        String nombre = sc.nextLine();
        System.out.print("Nombre de usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String password = sc.nextLine();

        if (buscarUsuario(usuarios, usuario, contadorUsuarios) != -1) {
            System.out.println("Error: El usuario ya existe");
            return false;
        }

        nombres[contadorUsuarios] = nombre;
        usuarios[contadorUsuarios] = usuario;
        passwords[contadorUsuarios] = password;
        System.out.println("Usuario registrado correctamente");
        return true;
    }

    public static boolean registrarEvento(String[] nombresEventos, String[] fechasEventos, String[] ubicacionesEventos, Scanner sc, int contadorEventos) {
        if (contadorEventos >= 100) {
            System.out.println("Error: No hay espacio para más eventos");
            return false;
        }

        sc.nextLine();
        System.out.println("\n=== REGISTRO DE EVENTO ===");
        System.out.print("Nombre del evento: ");
        String nombre = sc.nextLine();
        System.out.print("Fecha del evento: ");
        String fecha = sc.nextLine();
        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        nombresEventos[contadorEventos] = nombre;
        fechasEventos[contadorEventos] = fecha;
        ubicacionesEventos[contadorEventos] = ubicacion;
        System.out.println("Evento registrado correctamente");
        return true;
    }

    public static boolean realizarInscripcion(String[] usuarios, String[] nombresEventos, int[][] inscripciones, Scanner sc, int contadorUsuarios, int contadorEventos, int contadorInscripciones) {
        if (contadorInscripciones >= 100) {
            System.out.println("Error: No hay espacio para más inscripciones");
            return false;
        }

        sc.nextLine();
        System.out.println("\n=== REALIZAR INSCRIPCIÓN ===");
        System.out.print("Nombre de usuario: ");
        String usuario = sc.nextLine();

        int indiceUsuario = buscarUsuario(usuarios, usuario, contadorUsuarios);
        if (indiceUsuario == -1) {
            System.out.println("Error: Usuario no encontrado");
            return false;
        }

        System.out.println("\nEventos disponibles:");
        for (int i = 0; i < contadorEventos; i++) {
            System.out.println(i + ". " + nombresEventos[i]);
        }

        System.out.print("Seleccione el número del evento: ");
        int indiceEvento = sc.nextInt();

        if (indiceEvento >= contadorEventos || indiceEvento < 0) {
            System.out.println("Error: Evento no válido");
            return false;
        }

        inscripciones[contadorInscripciones][0] = indiceUsuario;
        inscripciones[contadorInscripciones][1] = indiceEvento;
        System.out.println("Inscripción realizada correctamente");
        return true;
    }

    public static void mostrarUsuarios(String[] nombres, String[] usuarios, int contadorUsuarios) {
        System.out.println("\n=== USUARIOS REGISTRADOS ===");
        for (int i = 0; i < contadorUsuarios; i++) {
            System.out.println("Usuario " + i + ": " + nombres[i] + " (" + usuarios[i] + ")");
        }
    }

    public static void mostrarEventos(String[] nombresEventos, String[] fechasEventos, String[] ubicacionesEventos, int contadorEventos) {
        System.out.println("\n=== EVENTOS REGISTRADOS ===");
        for (int i = 0; i < contadorEventos; i++) {
            System.out.println("Evento " + i + ": " + nombresEventos[i]);
            System.out.println("  Fecha: " + fechasEventos[i]);
            System.out.println("  Ubicación: " + ubicacionesEventos[i]);
        }
    }

    public static void mostrarInscripciones(int[][] inscripciones, String[] nombres, String[] nombresEventos, int contadorInscripciones) {
        System.out.println("\n=== INSCRIPCIONES REALIZADAS ===");
        for (int i = 0; i < contadorInscripciones; i++) {
            int indiceUsuario = inscripciones[i][0];
            int indiceEvento = inscripciones[i][1];
            System.out.println("Inscripción " + i + ":");
            System.out.println("  Usuario: " + nombres[indiceUsuario]);
            System.out.println("  Evento: " + nombresEventos[indiceEvento]);
        }
    }

    public static int buscarUsuario(String[] usuarios, String usuario, int contadorUsuarios) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].equals(usuario)) {
                return i;
            }
        }
        return -1;
    }
}