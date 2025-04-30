package eldenpro.model.characters.physicalCharacters;

import eldenpro.model.characters.*;
import eldenpro.model.enemies.enemy;

public abstract class physicalCaracter extends character {
    public int physicalDamage;

    public physicalCaracter(String name, int level, int healthPoints, int armor, int physicalDamage) {
        super(name, level, healthPoints, armor);
        this.physicalDamage = physicalDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    @Override
    public void attack(enemy enemy){

        int Damage = getPhysicalDamage();

        // TODO: enemy.recieveDamage(finalDamage);
    }

    public void analize(enemy enemy) {
        //System.out.println(name + " analiza a " + enemy.getNombre() + ". Nivel: " + enemy.getNivel() + ", Salud: " + enemy.getSalud());
    }
    

}
