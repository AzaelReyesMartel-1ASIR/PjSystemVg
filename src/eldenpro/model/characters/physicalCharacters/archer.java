package eldenpro.model.characters.physicalCharacters;

import java.util.Scanner;

import eldenpro.model.abilities.flying;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class archer extends physicalCaracter implements flying {
    public int arrows; // Flechas disponibles
    public int agilityPoints; // Velocidad de ataque
    private boolean isFlying = false; // Estado de vuelo

    public archer(String name, int level, int healthPoints, int armor, int physicalDamage, int arrows, int agilityPoints) {
        super(name, level, healthPoints, armor, physicalDamage);
        this.arrows = arrows;
        this.agilityPoints = agilityPoints;
    }

    public void atacar(){
        // Implementación del ataque
        System.out.println(getName() + " - ARQUERO ataca al enemigo.");
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = arrows;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void resetFlying() {
        isFlying = false; // Restablece el estado de vuelo
    }

    // Método para disparar flechas
    public void shootingArrows(enemy enemy) {
        if (arrows > 0) {
            if (Math.random() <= 0.10) {
                System.out.println("¡Tiro en la cabeza! El enemigo queda inconsciente.");
                enemy.receiveDamage(physicalDamage * 2, damageTypes.PSY_DMG); // Daño crítico
            } else {
                System.out.println("Fallaste el tiro.");
                arrows--; // Pierdes una flecha
            }
        } else {
            System.out.println("No tienes flechas disponibles.");
        }
    }

    // Método para recargar flechas
    public void reloadArrows() {
        if (arrows < 5) {
            System.out.println("Recargando flechas...");
            arrows += 10;
        } else {
            System.out.println("Tienes suficientes flechas.");
        }
    }

    @Override
    public void fly() {
        System.out.println(getName() + " vuela hacia una posición elevada.");
        isFlying = true; // Activa el estado de vuelo
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Qué decides hacer?");
        System.out.println("1. Disparar flechas");
        System.out.println("2. Defenderse");
        System.out.println("3. Recargar flechas");
        System.out.println("4. Volar (Esquivar el próximo ataque)");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                shootingArrows(enemy);
                break;
            case 2:
                System.out.println("Defendiéndote del ataque.");
                break;
            case 3:
                reloadArrows();
                break;
            case 4:
                fly();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}