package eldenpro.model.characters.physicalCharacters;

import java.util.Scanner;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class archer extends physicalCaracter {
    public int arrows;
    public int agilityPoints; // Velocidad de ataque


    public archer(String name, int level, int healthPoints, int armor, int physicalDamage, int arrows, int agilityPoints) {
        super(name, level, healthPoints, armor, physicalDamage);
        this.arrows = arrows;
        this.agilityPoints = agilityPoints;
    }

    // Cada batalla se puede disparar una flecha que tiene probabilidad de impactar en la cabeza o en el cuerpo
    public void shootingArrows(enemy enemy){
        int finalDamage;
        if(arrows > 0){
            if (Math.random() < 0.10) {
                System.out.println("Tiro en la cabeza! El enemigo se queda inconsciente y recuperas tu flecha.");
                finalDamage = physicalDamage * 2;
                enemy.receiveDamage(finalDamage, damageTypes.PSY_DMG);
            } else {
                System.out.println("Falló. Pierdes una flecha y el turno.");
                arrows-=2;
            }
            
        } else {
            System.out.println("No tienes flechas disponibles. ¡Intenta recargar!");
        }
    }

    // Recarga de flechas, si tiene puntos de agilidad puede cargar varias flechas en un turno
    public void reloadArrows(){
        if (arrows < 5) {
            System.out.println("Te quedan pocas flechas. Recargando...");
        } else {
            System.out.println("Tienes bastantes flechas: "+arrows+" ¿quieres recargar? Perderás un turno. \n 1.Sí \n 2. No");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    arrows += 5;
                    System.out.println("Encontrando flechas de enemigos caidos encontraste 5 flechas.");
                    break;
                case 2:
                    System.out.println("No recargaste.");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }

    // Carga rápida, si tiene puntos de agilidad puede cargar varias flechas en un turno
    public boolean fastCharge(){
        if (agilityPoints > 10) {
            System.out.println("¡Puedes cargar varias flechas!");
            return true;
        }
        return false;
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        // TODO: Implementar ataque con flechas
    }
}