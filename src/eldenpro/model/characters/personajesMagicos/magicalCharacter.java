package eldenpro.model.characters.personajesMagicos;

import eldenpro.model.characters.*;
import eldenpro.model.enemies.enemy;

// Clase personaje magico
public abstract class magicalCharacter extends character {
    public int magicalPoints;
    public int magicalDamage;
    
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

   
    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy){
            System.out.println("El personaje "+name+" realiza su ataque con "+magicalDamage+" puntos de daño al enemigo "+enemy+".");
    }

    public void magicTrick(){
        double chance = Math.random();

        if (chance <= 0.1) {
            System.out.println("¡El truco de magia salió, un rayo gigante del cielo salió y ha matado al enemigo!");
            // TODO: enemy.healthPoints == 0;
        }
    }

}
