package eldenpro.controller;

import eldenpro.model.characters.character;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enemies.finalBoss;
import eldenpro.model.enemies.thief;
import eldenpro.model.enums.damageTypes;
import eldenpro.view.castleSelector;

public class castleController {

    private final castleSelector view = new castleSelector();

    public void exploreCastle(character player) {
        int choice = view.showCastleMenu(); // Mostrar menú y obtener elección del usuario
        
        // Opciones de exploración del castillo
        switch (choice) {
            case 1:
                System.out.println("Encuentras un cofre con una daga mágica y 200 de oro.");
                // Aquí podrías mejorar las estadísticas del jugador
                break;
            case 2:
                System.out.println("Te enfrentas a un Caballero Oscuro.");
                enemy darkKnight = new thief(500, 10, 5, 10, 50, 20, "Caballero Oscuro (Actualmente ladrón)", damageTypes.PSY_DMG);
                battleController battle = new battleController();
                battle.startBattle(player, darkKnight);
                break;
            case 3:
                System.out.println("Te enfrentas al Jefe Final.");
                enemy boss = new finalBoss(2500, 10, 15, 20, "Jefe Final", damageTypes.MAG_DMG);
                battleController bossBattle = new battleController();
                bossBattle.startBattle(player, boss);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}