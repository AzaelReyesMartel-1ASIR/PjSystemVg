package eldenpro.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

import eldenpro.model.characters.character;
import eldenpro.view.characterSelection;

public class gameController {

    // Controlador del juego que gestiona la interacción con el usuario y el flujo del juego
    private static final Scanner scanner = new Scanner(System.in);
    private final castleController castle = new castleController();
    private final caveController cave = new caveController();
    private character player;

    // Método para obtener la elección del usuario
    public int getUserChoice() {
        while (true) {
            try {
                System.out.println("¿Qué deseas hacer?");
                System.out.println("1. Explorar el castillo");
                System.out.println("2. Explorar la cueva");
                System.out.println("3. Hablar con un NPC");
                System.out.println("4. Salir del juego");

                int choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea
                return choice;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, introduce un número válido.");
                scanner.nextLine(); // Limpiar la entrada no válida
            }
        }
    }

    // Método para iniciar el juego
    public void startGame() {
        System.out.println("Bienvenido a Elden PRO: Expedition DAW.");

        // Selección del personaje antes de iniciar el juego
        characterSelection selection = new characterSelection();
        player = selection.selectCharacter(); // Inicializa el personaje

        System.out.println("¡Tu aventura comienza ahora, " + player.getName() + "!");
        boolean playing = true;

        // Bucle principal del juego
        while (playing) {
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    castle.exploreCastle(player);
                    break;
                case 2:
                    cave.exploreCave(player);
                    break;
                case 3:
                    System.out.println("Hablas con un NPC y aprendes más sobre el mundo.");
                    break;
                case 4:
                    System.out.println("Gracias por jugar. ¡Hasta la próxima!");
                    playing = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}