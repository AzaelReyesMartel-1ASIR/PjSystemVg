package eldenpro.controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import eldenpro.model.characters.character;
import eldenpro.model.characters.physicalCharacters.archer;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class battleController {

    private static final Scanner scanner = new Scanner(System.in);

    // Método para iniciar una batalla entre un personaje y un enemigo
    public void startBattle(character player, enemy enemy) {
        System.out.println("¡La batalla comienza entre " + player.getName() + " y " + enemy.getName() + "!");

        // Mientras ambos tengan vida, continúa la batalla
        while (player.gethealthPoints() > 0 && enemy.getHealthPoints() > 0) {
            int choice = 0;
            boolean validInput = false; // Bandera para validar la entrada del usuario

            // Turno del jugador
            while (!validInput) {
                try {
                    System.out.println("Es tu turno. Elige tu tipo de ataque:");
                    System.out.println("1. Ataque físico");
                    System.out.println("2. Ataque mágico");
                    System.out.print("Introduce tu elección (1 o 2): ");

                    choice = scanner.nextInt(); // Leer la opción del usuario
                    scanner.nextLine(); // Consumir el salto de línea

                    if (choice == 1 || choice == 2) {
                        validInput = true; // Entrada válida
                    } else {
                        System.out.println("Opción no válida. Por favor, elige 1 o 2.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Entrada no válida. Por favor, introduce un número (1 o 2).");
                    scanner.nextLine();
                }
            }

            // Determina el tipo de ataque según la elección del usuario
            damageTypes attackType;
            if (choice == 1) {
                attackType = damageTypes.PSY_DMG; // Ataque físico
            } else {
                attackType = damageTypes.MAG_DMG; // Ataque mágico
            }

            // Ejecutamos el ataque del jugador
            player.attack(enemy, attackType);

            // Si el enemigo muere, termina la batalla
            if (enemy.getHealthPoints() <= 0) {
                System.out.println(enemy.getName() + " ha sido derrotado.");
                break;
            }

            // Turno del enemigo
            System.out.println("Turno del enemigo...");
            if (player instanceof archer archerPlayer && archerPlayer.isFlying()) {
                // Si el jugador es un arquero y está volando, esquiva el ataque
                System.out.println(player.getName() + " esquivó el ataque mientras volaba.");
                archerPlayer.resetFlying(); // Restablece el estado de vuelo
            } else {
                // El enemigo ataca al jugador
                enemy.attack(player, enemy.getDamageType());
            }

            // Si el jugador muere, termina la batalla
            if (player.gethealthPoints() <= 0) {
                System.out.println(player.getName() + " ha sido derrotado.");
                break;
            }
        }
    }
}