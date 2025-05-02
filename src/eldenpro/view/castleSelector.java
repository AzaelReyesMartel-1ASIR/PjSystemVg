package eldenpro.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class castleSelector {

    private static final Scanner scanner = new Scanner(System.in);

    // Opciones del menú del castillo
    public int showCastleMenu() {
        int choice = 0;

        while (choice < 1 || choice > 3) {
            try {
                System.out.println("Estás en el castillo. ¿Qué deseas hacer?");
                System.out.println("1. Explorar el torreón");
                System.out.println("2. Ir a la entrada");
                System.out.println("3. Enfrentar al jefe final");
                System.out.print("Introduce una opción válida (1-3): ");

                choice = scanner.nextInt();

                if (choice < 1 || choice > 3) {
                    System.out.println("Opción no válida. Por favor, elige una opción entre 1 y 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 3.");
                scanner.nextLine(); 
            }
        }
        return choice;
    }
}