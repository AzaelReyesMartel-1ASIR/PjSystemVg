package eldenpro.model.characters.physicalCharacters;

import java.util.Scanner;

import eldenpro.model.abilities.flying;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class archer extends physicalCaracter implements flying {
    public int arrows;
    public int agilityPoints; // Velocidad de ataque


    public archer(String name, int level, int healthPoints, int armor, int physicalDamage, int arrows, int agilityPoints) {
        super(name, level, healthPoints, armor, physicalDamage);
        this.arrows = arrows;
        this.agilityPoints = agilityPoints;
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

    // Cada batalla se puede disparar una flecha que tiene probabilidad de impactar en la cabeza o en el cuerpo
    public void shootingArrows(enemy enemy){
        int finalDamage;
        if(arrows > 0){
            if (Math.random() <= 0.10) {
                System.out.println("Tiro en la cabeza! El enemigo se queda inconsciente y recuperas tu flecha.");
                finalDamage = physicalDamage * 2;
                enemy.receiveDamage(finalDamage, damageTypes.PSY_DMG);
                agilityPoints += 100;
            } else {
                System.out.println("Falló. Pierdes una flecha y el turno.");
                arrows-=2;
                agilityPoints += 5;
            }
            
        } else {
            System.out.println("No tienes flechas disponibles. ¡Intenta recargar!");
        }
    }

    // Recarga de flechas, si tiene puntos de agilidad puede cargar varias flechas en un turno
    public void reloadArrows(){
        if (arrows < 5) {
            System.out.println("Te quedan pocas flechas. Recargando...");
            arrows += 10;
        } else {
            System.out.println("Tienes bastantes flechas: "+getArrows()+" ¿quieres recargar? Perderás un turno. \n 1.Sí \n 2. No");
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
            setArrows(getArrows() + 20);
            return true;
        }
        return false;
    }

    // TODO: añadir el metodo volar en el mapa
    @Override
    public void fly() {
        System.out.println("El arquero puede volar, revisa el mapa");
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        Scanner sc = new Scanner(System.in);
        int op = 5;
        System.out.println("¿qué decides hacer?\n 1.Disparar flechas \n 2. Defenderse \n 3.Recargar flechas \n 4. Carga rápida");
        op = sc.nextInt();
        switch (op) {
            case 1:
                shootingArrows(enemy);
                break;
            case 2:
            if (enemy.getTipo() == damageTypes.PSY_DMG) {
                defense(enemy.getPhysicalDamage());
            } else {
                defense(enemy.getMagicalDamage());
            }
                break;
            case 3:
                reloadArrows();
                break;
            case 4:
                fastCharge();
                break;
            default:
                System.out.println("Por favor elije que hacer");
                break;
        }
    }


}