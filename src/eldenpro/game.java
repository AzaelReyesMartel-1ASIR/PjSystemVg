package eldenpro;

import eldenpro.controller.gameController;
import eldenpro.model.characters.character;
import eldenpro.model.characters.physicalCharacters.*;
import eldenpro.model.characters.magicalCharacters.*;
import eldenpro.view.startMenu;

import eldenpro.model.enemies.*;

import java.util.ArrayList;
import java.util.Scanner;

public class game {

    // Método para mostrar las acciones de los personajes
    public static void mostrarAcciones() {
        // Creamos una lista de personajes y agregamos un personaje de cada tipo
        ArrayList<character> personajes = new ArrayList<>();
        personajes.add(new warrior("GUERRERO", 10, 2000, 15, 150, false, 15));
        personajes.add(new archer("ARQUERO", 30, 950, 10, 175, 10, 30));
        personajes.add(new assassin("ASESINO", 20, 1250, 5, 100));
        personajes.add(new mage("HECHICERO", 27, 1000, 40, 15, 10, 200));
        personajes.add(new wizard("MAGO", 30, 950, 60, 10, 200));
    
        // Creamos un enemigo ficticio para las simulaciones
        enemy dummyEnemy = new thief(
            1000, 10, 10, 1, 50, 20, "Enemigo Ficticio", eldenpro.model.enums.damageTypes.PSY_DMG
        );
    
        // Recorremos la lista de personajes
        for (character p : personajes) {
            System.out.println("\n--- Acciones del personaje: " + p.getName() + " ---");
            p.atacar(); // Llamamos al método atacar (polimorfismo)
    
            // Usamos instanceof para ejecutar habilidades específicas según el tipo de personaje

            if (p instanceof mage) {
                mage m = (mage) p;
                m.magicTrick(dummyEnemy); // Simula un truco de magia
            }

            if (p instanceof archer) {
                archer a = (archer) p;
                a.shootingArrows(dummyEnemy); // Pasamos el enemigo ficticio
            }

            if (p instanceof assassin) {
                assassin as = (assassin) p;
                as.attackFromBehind(dummyEnemy, eldenpro.model.enums.damageTypes.PSY_DMG); // Simula un ataque por la espalda
            }

            if (p instanceof wizard) {
                wizard w = (wizard) p;
                w.summon(dummyEnemy, eldenpro.model.enums.damageTypes.MAG_DMG); // Simula invocar un esbirro
            }

            if (p instanceof warrior) {
                warrior w = (warrior) p;
                w.chargeAttack(); // Habilidad específica del guerrero
            } 
        }
    }

    public static void main(String[] args) {
        // Mostramos las acciones de los personajes al inicio del juego
        mostrarAcciones();

        System.out.println("\nQuieres empezar con la aventura y probar la parte opcional de BATALLA?");

        System.out.println("Escribe 'si' para empezar o 'no' para salir del juego.");
        Scanner sc = new Scanner(System.in);
        String op = sc.nextLine();

        // Si el usuario elige "si", mostramos el menú de inicio y comenzamos el juego
        if (op.equalsIgnoreCase("si")) {
            startMenu menu = new startMenu();
            menu.showMenu();
            gameController controller = new gameController();
            controller.startGame();
        } else {
            System.out.println("Goodbye! Esperamos que vuelvas pronto.");
        }
        sc.close(); // Cerramos el escaner
    }
}