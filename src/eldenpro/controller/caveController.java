package eldenpro.controller;

import eldenpro.model.characters.character;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enemies.thief;
import eldenpro.model.enums.damageTypes;
import eldenpro.view.caveSelector;

public class caveController {

    private final caveSelector view = new caveSelector();

    public void exploreCave(character player) {
        int choice = view.showCaveMenu(); // Mostrar menú y obtener elección del usuario

        // Opciones de exploración de la cueva
        switch (choice) {
            case 1:
                System.out.println("Encuentras un tesoro, pero un ladrón te ataca.");
                enemy thief = new thief(1000, 5, 0, 5, 50, 10, "Ladrón", damageTypes.PSY_DMG);
                battleController battle = new battleController();
                battle.startBattle(player, thief);
                System.out.println("¡Has derrotado al ladrón y obtienes una armadura mejorada!");
                player.setArmor(player.getArmor() + 5); // Mejora la armadura del jugador
                break;
            case 2:
                System.out.println("Te enfrentas al ladrón.");
                enemy caveThief = new thief(1000, 5, 0, 5, 50, 10, "Ladrón", damageTypes.PSY_DMG);
                battleController thiefBattle = new battleController();
                thiefBattle.startBattle(player, caveThief);
                break;
            case 3:
                int shopChoice = view.showShopMenu(); // Mostrar menú de la tienda
                handleShopChoice(player, shopChoice);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    // Método con opciones de la tienda
    private void handleShopChoice(character player, int choice) {
        try {
            switch (choice) {
                case 1:
                    System.out.println("Compraste el Medallón de ámbar.");
                    player.healthPoints += player.healthPoints * 0.07;
                    break;
                case 2:
                    System.out.println("Compraste el Icono de mago.");
                    break;
                case 3:
                    System.out.println("Compraste la Daga del asesino.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Vuelva a introducir la opción.");
        }
    }
}