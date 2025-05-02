package eldenpro.view;

import java.util.Scanner;

import eldenpro.model.characters.character;
import eldenpro.model.characters.magicalCharacters.*;
import eldenpro.model.characters.physicalCharacters.*;

public class characterSelection {

    private static final Scanner scanner = new Scanner(System.in);

    // Método para seleccionar un personaje
    public character selectCharacter() {
        System.out.println("Selecciona tu clase de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");
        System.out.println("3. Arquero");
        System.out.println("4. Hechicero");
        System.out.println("5. Asesino");

        int choice = 0;

        while (choice < 1 || choice > 5) {
            try {
                System.out.print("Introduce el número de tu elección: ");
                choice = scanner.nextInt(); 
                scanner.nextLine(); // Consumir el salto de línea

                if (choice < 1 || choice > 5) {
                    // Mensaje para opciones fuera del rango
                    System.out.println("Opción no válida. Se seleccionará un Guerrero por defecto.");
                    System.out.print("Introduce el nombre de tu personaje: ");
                    String defaultName = scanner.nextLine(); // Leer el nombre del personaje
                    return new warrior(defaultName, 10, 2000, 15, 150, false, 15);
                }

                System.out.print("Introduce el nombre de tu personaje: ");
                String name = scanner.nextLine(); // Leer el nombre del personaje

                // Creamos el personaje según la elección del usuario
                switch (choice) {
                    case 1:
                        System.out.println("Has elegido Guerrero.");
                        return new warrior(name, 10, 2000, 15, 150, false, 15);
                    case 2:
                        System.out.println("Has elegido Mago.");
                        return new mage(name, 27, 1000, 40, 15, 10, 200);
                    case 3:
                        System.out.println("Has elegido Arquero.");
                        return new archer(name, 30, 950, 10, 175, 10, 30);
                    case 4:
                        System.out.println("Has elegido Hechicero.");
                        return new wizard(name, 30, 950, 60, 10, 200);
                    case 5:
                        System.out.println("Has elegido Asesino.");
                        return new assassin(name, 20, 1250, 5, 100);
                    default:
                    System.out.println("Selección no válida. Se seleccionará un Guerrero por defecto.");
                }
            } catch (Exception e) {
                // Manejo de excepciones para entradas no válidas
                System.out.println("Entrada no válida. Por favor, introduce un número entre 1 y 5.");
                scanner.nextLine(); // Limpiar el buffer del scanner
            }
        }

        // Este return nunca se ejecutará debido al bucle while
        return null;
    }
}