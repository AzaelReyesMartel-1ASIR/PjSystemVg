package eldenpro.view;

import java.util.Scanner;

public class caveSelector {

    private static final Scanner scanner = new Scanner(System.in);

    // Opciones del menú de la cueva
    public int showCaveMenu() {
        int choice = 0; 

        while (choice < 1 || choice > 3) {
            try {
                System.out.println("Estás en la cueva. ¿Qué deseas hacer?");
                System.out.println("1. Buscar el tesoro");
                System.out.println("2. Enfrentar al ladrón");
                System.out.println("3. Visitar la tienda");
                System.out.print("Introduce una opción válida (1-3): ");

                choice = scanner.nextInt();

                if (choice < 1 || choice > 3) {
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 3.");
                scanner.nextLine(); 
            }
        }

        return choice;
    }

    public int showShopMenu() {
        int choice = 0;

        while (choice < 1 || choice > 3) {
            try {
                System.out.println("Visitas la tienda y compras objetos.");
                System.out.println("1. Medallón de ámbar (+7% vida, 50 de oro)");
                System.out.println("2. Icono de mago (Concentración siempre activa, 75 de oro)");
                System.out.println("3. Daga del asesino (Golpes críticos restauran 10% de vida, 100 de oro)");
                System.out.print("Introduce una opción válida (1-3): ");

                choice = scanner.nextInt();

                if (choice < 1 || choice > 3) {
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 3.");
                scanner.nextLine(); 
            }
        }

        return choice;
    }
}