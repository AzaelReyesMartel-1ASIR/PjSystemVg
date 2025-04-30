package eldenpro.model.characters.magicalCharacters;

import java.util.Random;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class mage extends magicalCharacter {
    private int intelligencePoints;

    public mage(String name, int level, int healthPoints, int magicalPoints, int intelligencePoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, magicalPoints, intelligencePoints, armor);
        this.intelligencePoints = intelligencePoints;
    }

    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy, damageTypes damageTypes){
        if (canCast()){
            System.out.println("El personaje "+name+" realiza su ataque con "+getMagicalDamage()+" puntos de daño al enemigo "+enemy+".");
            intelligencePoints -= 5; // El coste de cada casteo es de 5 puntos de maná
            Random rand = new Random();
            int damage = rand.nextInt(getMagicalDamage()) + 1;
            enemy.receiveDamage(damage, damageTypes.MAG_DMG);    
        } else {
            // Al no tener puntos de maná, se regeneran automaticamente los puntos por el coste de un turno
            System.out.println("¡No puede hacer daño!"); 
            System.out.println("Regenerando puntos de inteligencia...");
            manaRegen();
        }

    }

    // Comprobar si hay puntos de inteligencia para castear hechizos
    public boolean canCast(){
        if (intelligencePoints > 0) return true;
        return false;
    }

    public void manaRegen(){
        intelligencePoints +=10;
    }

    @Override
    public void magicTrick(enemy enemy){
        double chance = Math.random();

        if (chance <= 0.1) {
            System.out.println("¡El truco de magia salió, un rayo gigante del cielo salió y ha matado al enemigo!");
            enemy.setHealthPoints(0);
            intelligencePoints -= 20;
        }
    }

}
