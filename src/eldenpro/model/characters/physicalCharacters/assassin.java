package eldenpro.model.characters.physicalCharacters;

import java.util.Random;
import java.util.Scanner;

import eldenpro.model.abilities.healable;
import eldenpro.model.abilities.mobilizable;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class assassin extends physicalCaracter implements healable, mobilizable {

    public assassin(String name, int level, int healthPoints, int armor, int physicalDamage) {
        super(name, level, healthPoints, armor, physicalDamage);

    }

    public void atacar(){
        // Implementación del ataque
        System.out.println(getName() + " - ASESINO ataca al enemigo.");
    }

    // Clase de atacar por la espalda
    public void attackFromBehind(enemy enemy, damageTypes damageTypes) {
        double chance = Math.random();

        if (chance <= 0.10) {
            System.out.println("¡Ataque por la espalda, duplica el daño!");
            physicalDamage *= 2;
            enemy.receiveDamage(physicalDamage, damageTypes);
        } else {
            System.out.println("¡El enemigo te ha visto, tienes desventaja!");
            physicalDamage = 0;
        }
    }

    // Clase ocultar
    public void hide(enemy enemy) {
        Scanner sc = new Scanner(System.in);
        int op = 3;
        System.out.println("Te has ocultado en plena vista frente al enemigo, ¿qué quieres hacer?");
        System.out.println("1. Atacar \n 2. Huir");
        op = sc.nextInt();
        sc.nextLine();
        switch (op) {
            case 1:
                System.out.println("Te acercas al enemigo " + enemy
                        + ", tienes la posibilidad de atacarlo por la espalda o por el frente, ¿qué decides?");
                System.out.println("1. Atacar por la espalda \n 2. Atacar de frente");
                op = sc.nextInt();
                if (op == 1) {
                    attackFromBehind(enemy, damageTypes.PSY_DMG);
                } else {
                    attack(enemy, damageTypes.PSY_DMG);
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
    public void throwingKnives(enemy enemy, damageTypes damageTypes) {
        Random random = new Random();
        int totalDamage = random.nextInt(101) + 100;

        System.out.println(
                "Lanzas cuchillos arrojadizos al enemigo " + enemy + ", quitas un total de: " + totalDamage + ".");

    }

    // Clase opcional - Parry: el asesino cuenta con un parry de 10% de probabilidad
    // de evitar un ataque del enemigo
    public boolean parry(enemy enemy) {
        double chance = Math.random();
        if (chance < 0.1) {
            System.out.println("¡Has realizado un parry! Evitaste el ataque del enemigo y contraatacas.");
            return true;
        } else {
            System.out.println("¡El parry no se ha realizado, recibes daño!");
            receiveDamage(enemy.getPhysicalDamage(), damageTypes.PSY_DMG); // Si es daño físico
            receiveDamage(enemy.getMagicalDamage(), damageTypes.MAG_DMG); // Si es mágico
        }

        return false;
    }

    public void daggerAndStagger(enemy enemy, damageTypes damageTypes) {
        System.out.println("Realizas un combo de cortes con tu daga");
        receiveDamage(getPhysicalDamage(), eldenpro.model.enums.damageTypes.PSY_DMG); // Daño físico
    }

    @Override
    public void healing() {
        System.out.println("El asesino recupera 20 puntos de vida");
        healthPoints+=20;
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        Scanner sc = new Scanner(System.in);
        int op = 10;
        System.out.println("¿qué decides hacer?\n 1.Lanzar cuchillos \n 2. Defenderse \n 3.Hacer un parry al enemigo \n 4. Ataque por la espalda\n 5. Cortar con la daga y golpear al enemigo\n 6. Recuperar vida");
        op = sc.nextInt();
        switch (op) {
            case 1:
                throwingKnives(enemy, eldenpro.model.enums.damageTypes.PSY_DMG);
                break;
            case 2:
                if (enemy.getTipo() == eldenpro.model.enums.damageTypes.PSY_DMG) {
                    defense(enemy.getPhysicalDamage());
                } else {
                    defense(enemy.getMagicalDamage());
                }
            case 3:
                parry(enemy);
                break;
            case 4:
                attackFromBehind(enemy, damageTypes);
                break;
            case 5:
                daggerAndStagger(enemy, damageTypes);
                break;
            case 6:
                healing();
                break;
            default:
                System.out.println("Por favor, realiza un acción válida");
                break;
        }
    }


    
    @Override
    public void climb() {
        System.out.println(getName() + " trepa hábilmente por superficies verticales.");
    }

    @Override
    public void sneak(enemy enemy) {
        System.out.println(getName() + " se mueve sigilosamente, reduciendo las posibilidades de ser detectado.");
        hide(enemy);
    }

    @Override
    public void shadowStep(enemy enemy) {
        System.out.println(getName() + " se desvanece en las sombras y reaparece en una posición cercana.");
        hide(enemy);
    }

    public void useMovementAbility(enemy enemy) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Elige una habilidad de movimiento:");
        System.out.println("1. Trepar");
        System.out.println("2. Sigilo");
        System.out.println("3. Paso de sombra");
        int choice = sc.nextInt();
        
        switch(choice) {
            case 1:
                climb();
                break;
            case 2:
                sneak(enemy);
                break;
            case 3:
                shadowStep(enemy);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
