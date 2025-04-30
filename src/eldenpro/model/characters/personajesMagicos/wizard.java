package eldenpro.model.characters.personajesMagicos;

import java.util.Scanner;

import eldenpro.model.enemies.enemy;

public class wizard extends magicalCharacter {
    
    public int manaPoints;

    public wizard(String name, int level, int healthPoints, int magicalPoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, magicalPoints, armor, magicalDamage);
    }

    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy){
        System.out.println("El personaje "+name+" realiza su ataque con "+magicalDamage+" puntos de daño al enemigo "+enemy+".");
    }

    // Comprobar si hay puntos de maná para castear esbirros
    public boolean canSummon(){
        if (manaPoints > 0) return true;
        return false;
    }

    // TODO: Crear objetos de clase esbirro, añadir los esbirros a un arraylist de máximo 3 esbirros
    // Metodo para summonear un esbirro
    public void summon(){
        if (canSummon()){
            int op = 4;
            Scanner sc = new Scanner(System.in);
            System.out.println("¿Qué tipo de esbirro quieres elegir?");
            System.out.println("1. Esbirro tanque \n 2. Esbirro sanador \n 3. Esbirro asesino");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Has elegido el Esbirro tanque, este tiene 100 puntos de vida y 30 de armadura");
                    manaPoints --;
                    break;
                case 2:
                    System.out.println("Has elegido el Esbirro sanador, este tiene 50 puntos de vida y cura 250 puntos de vida");
                    manaPoints --;
                    break;
                case 3:
                    System.out.println("Has elegido el Esbirro asesino, tiene 100 puntos de vida, realiza 3 cortes y quita 175 de vida extra");
                    manaPoints --;
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
    public void magicTrick(){
        double chance = Math.random();

        if (chance <= 0.1) {
            System.out.println("¡El truco de magia salió, un rayo gigante del cielo salió y ha matado al enemigo!");
            // TODO: enemy.healthPoints == 0;
            manaPoints -= 20;
        }
    }
}
