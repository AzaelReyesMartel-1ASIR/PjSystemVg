package eldenpro.model.characters.magicalCharacters;

import eldenpro.model.characters.*;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

// Clase personaje magico
public abstract class magicalCharacter extends character {
    private int magicalPoints;
    private int magicalDamage;
    
    public magicalCharacter(String name, int level, int healthPoints, int magicalPoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, armor);
        this.magicalPoints = magicalPoints;
        this.armor = armor;
        this.magicalDamage = magicalDamage;
    }



    public int getMagicalPoints() {
        return magicalPoints;
    }




    public void setMagicalPoints(int magicalPoints) {
        this.magicalPoints = magicalPoints;
    }




    public int getMagicalDamage() {
        return magicalDamage;
    }




    public void setMagicalDamage(int magicalDamage) {
        this.magicalDamage = magicalDamage;
    }


   
    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy, damageTypes damageTypes){
            System.out.println("El personaje "+name+" realiza su ataque con "+magicalDamage+" puntos de daño al enemigo "+enemy+".");
    }

    public void magicTrick(enemy enemy){
        double chance = Math.random();

        if (chance <= 0.1) {
            System.out.println("¡El truco de magia salió, un rayo gigante del cielo salió y ha matado al enemigo!");
            enemy.setHealthPoints(0);
        }
    }
    // Metodo heredado de la clase character
    public void analize(enemy enemy) {
        System.out.println(enemy);
    }



}
