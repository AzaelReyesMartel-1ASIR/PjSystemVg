package eldenpro.view;

import java.util.Scanner;

public class startMenu {

    private static final Scanner scanner = new Scanner(System.in);

    // Opciones del menú inicial
    public void showMenu() {
        int choice = 0;
        System.out.println("Bienvenido a Elden PRO: Expedition DAW.");
        System.out.println("Por favor, elige una opción:");
        while (choice != 1 && choice != 2) {
            try {
                System.out.println("1. Comenzar juego");
                System.out.println("2. Salir");
                System.out.print("Por favor, elige una opción válida (1 o 2): ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("¡Comencemos la aventura!");
                        break;
                    case 2:
                        System.out.println("Saliendo del juego... ¡Gracias por jugar!");
                        System.exit(0); // Salimos del programa
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtalo de nuevo.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ha introducido una opción incorrecta, elija (1 o 2).");
                scanner.nextLine(); // Limpiamos el buffer del scanner
            }
        }
    }
}