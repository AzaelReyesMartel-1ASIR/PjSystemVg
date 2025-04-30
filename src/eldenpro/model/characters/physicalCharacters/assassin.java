package eldenpro.model.characters.physicalCharacters;

import java.util.Random;
import java.util.Scanner;

import eldenpro.model.enemies.enemy;

public class assassin extends physicalCaracter {

    public assassin(String name, int level, int healthPoints, int armor, int physicalDamage) {
        super(name, level, healthPoints, armor, physicalDamage);
    
    }

    @Override
    public void attack(enemy enemy){
        double chance = Math.random();
        int finalDamage = getPhysicalDamage();

        if (chance == 0.25) {
            finalDamage *= 2;
            System.out.println("¡Golpe critico! ¡Se duplica el daño!");
        }

        // TODO: enemy.recieveDamage(finalDamage);

    }
    
    // Clase de atacar por la espalda
    public void attackFromBehind(enemy enemy){
        double chance = Math.random();

        if (chance == 0.50) {
            System.out.println("¡Ataque por la espalda, tienes la prioridad!");
            // TODO: "Ataque duplicado durante 3 turnos"
        } else {
            System.out.println("¡El enemigo te ha visto, tienes desventaja!");
            // TODO: El enemigo empieza primero el ataque
        }
    }

    // Clase ocultar
    public void hide(enemy enemy){
        Scanner sc = new Scanner(System.in);
        int op = 3;
        System.out.println("Te has ocultado en plena vista frente al enemigo, ¿qué quieres hacer?");
        System.out.println("1. Atacar \n 2. Huir");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.println("Te acercas al enemigo "+enemy+", tienes la posibilidad de atacarlo por la espalda o por el frente, ¿qué decides?");
                System.out.println("1. Atacar por la espalda \n 2. Atacar de frente");
                op = sc.nextInt();
                if (op == 1) {
                    attackFromBehind(enemy);
                } else {
                    attack(enemy);
                }
                break;
            case 2:
                System.out.println("Decides huir, no podrás volver a esconderte de nuevo");
                break;
            default:
            System.out.println("Por favor elije que hacer");
                break;
        }
    }

    // Clase opcional - Cuchillos arrojadizos
    public void throwingKnives(){
        Random random = new Random();
        int totalDamage = random.nextInt(101) + 100;

        System.out.println("Lanzas cuchillos arrojadizos al enemigo más próximo, quitas un total de: "+totalDamage+".");

        // Desde que se lanzen los cuchillos, empieza la batalla automaticamente
        // TODO: lanzar batalla
    }
}
