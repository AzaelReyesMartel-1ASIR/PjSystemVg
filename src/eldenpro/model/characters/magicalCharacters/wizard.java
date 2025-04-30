package eldenpro.model.characters.magicalCharacters;

import java.util.Scanner;

import eldenpro.model.enemies.*;
import eldenpro.model.enums.damageTypes;

public class wizard extends magicalCharacter {

    public int manaPoints;

    public wizard(String name, int level, int healthPoints, int magicalPoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, magicalPoints, armor, magicalDamage);
    }

    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy, damageTypes damageTypes){
        if (canSummon()){
            System.out.println("El personaje realiza un summon de uno de los esbirros disponibles.");
            manaPoints -= 5; // El coste de cada casteo es de 5 puntos de maná
        } else {
            // Al no tener puntos de maná, se regeneran automaticamente los puntos por el coste de un turno
            System.out.println("¡No puede hacer summon!"); 
            System.out.println("Regenerando puntos de maná...");
            manaPoints += 40;
        }

    }

    // Comprobar si hay puntos de maná para castear esbirros
    public boolean canSummon() {
        if (manaPoints > 0)
            return true;
        return false;
    }

    // TODO: Crear objetos de clase esbirro, añadir los esbirros a un arraylist de
    // máximo 3 esbirros
    // Metodo para summonear un esbirro
    public void summon() {
        if (canSummon()) {
            int op = 4;
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué tipo de esbirro quieres elegir?");
            System.out.println("1. Esbirro tanque \n 2. Esbirro sanador \n 3. Esbirro asesino");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Has elegido el Esbirro tanque, este tiene 100 puntos de vida y 30 de armadura");
                    manaPoints--;
                    break;
                case 2:
                    System.out.println("Has elegido el Esbirro sanador, este tiene 50 puntos de vida y cura 250 puntos de vida");
                    manaPoints--;
                    healthPoints += 250;
                    break;
                case 3:
                    System.out.println("Has elegido el Esbirro asesino, tiene 100 puntos de vida, realiza 3 cortes y quita 175 de vida extra");
                    manaPoints--;
                    break;
                default:
                    System.out.println("Elije uno de los 3 esbirros.");
                    break;
            }
        } else {
            System.out.println("la invocación ha sido fallida!");
        }
    }

    @Override
    public void magicTrick(enemy enemy) {
        double chance = Math.random();

        if (chance <= 0.1) {
            if (!(enemy instanceof finalBoss)) {
                System.out.println("¡El truco de magia salió, un rayo gigante del cielo ha matado al enemigo!");
                enemy.setHealthPoints(0);
                manaPoints -= 20;
            } else {
                System.out.println("¡El rayo no afecta al Jefe Final!");
            }
        }
    }

    public void regenManaPoints(){
        if (manaPoints >= 5) {
            System.out.println("Tienes puntos de maná suficientes para summonear un esbirro, ¿quieres recargarlos igualmente? \n 1. Sí \n 2. No \n NOTA: PERDERÁS UN TURNO SI RECARGAS.");
            Scanner sc = new Scanner(System.in);
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    manaPoints = Math.min(manaPoints + 20, 40);
                    System.out.println("Has recargado tus puntos de maná.");
                    break;
                case 2:
                    System.out.println("No recargaste.");
                    break;
                default:
                    System.out.println("Elije una opción.");
                    break;
            }
        } else {
            System.out.println("No tienes puntos de maná suficientes, recargando automaticamente...");
            manaPoints = Math.min(manaPoints + 20, 40);
        }
    }
}