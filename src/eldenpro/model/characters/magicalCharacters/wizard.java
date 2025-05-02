package eldenpro.model.characters.magicalCharacters;

import java.util.Scanner;

import eldenpro.model.enemies.*;
import eldenpro.model.enums.damageTypes;
import eldenpro.model.abilities.defendible;
import eldenpro.model.abilities.magical;

public class wizard extends magicalCharacter implements magical, defendible {

    public int manaPoints;

    public wizard(String name, int level, int healthPoints, int magicalPoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, magicalPoints, armor, magicalDamage);
    }

    // Comprobar si hay puntos de maná para castear esbirros
    public boolean canSummon() {
        if (manaPoints > 0)
            return true;
        return false;
    }

    
    // Metodo para summonear un esbirro
    public void summon(enemy enemy, damageTypes damageTypes) {
        if (canSummon()) {
            int op = 4;
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué tipo de esbirro quieres elegir?");
            System.out.println("1. Esbirro tanque \n 2. Esbirro sanador \n 3. Esbirro asesino");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Has elegido el Esbirro mago, hace 300 de daño mágico");
                    manaPoints--;
                    enemy.receiveDamage(300, damageTypes.MAG_DMG);
                    break;
                case 2:
                    System.out.println("Has elegido el Esbirro sanador, cura 250 puntos de vida");
                    manaPoints--;
                    healthPoints += 250;
                    break;
                case 3:
                    System.out.println("Has elegido el Esbirro asesino, realiza 3 cortes y quita 175 de vida extra");
                    manaPoints--;
                    enemy.receiveDamage(175, damageTypes.PSY_DMG);
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

    @Override
    public void shieldDefense(enemy enemy, int incomingDamage){
        System.out.println("El hechicero crea un escudo protector de hielo.");
        double chance = Math.random();

        if (chance <= 0.25) {
            System.out.println("¡Contraataca con su esbirro asesino!");
            if (enemy.getTipo() == damageTypes.PSY_DMG) {
                enemy.receiveDamage(175, damageTypes.PSY_DMG); // Aplica el mismo daño físico al enemigo
            } else {
                enemy.receiveDamage(300, damageTypes.MAG_DMG); // Aplica el mismo daño mágico al enemigo
            }
        } else {
            System.out.println("Bloquea el ataque con su escudo mágico.");
            incomingDamage = 0;
        }
    }

    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy, damageTypes damageTypes){
        Scanner sc = new Scanner(System.in);
        int op = 5;
        System.out.println("¿qué decides hacer?\n 1.Atacar \n 2. Defenderse \n 3.Regenerar inteligencia \n 4. Usar tu escudo mágico");
        op = sc.nextInt();
        switch (op) {
            case 1:
                summon(enemy, damageTypes);
                break;
            case 2:
            if (enemy.getTipo() == damageTypes.PSY_DMG) {
                defense(enemy.getPhysicalDamage());
            } else {
                defense(enemy.getMagicalDamage());
            }
            case 3:
                regenManaPoints();
                break;
            case 4:
                shieldDefense(enemy, enemy.getPhysicalDamage());
            default:
                break;
        }
        

    }

    
}