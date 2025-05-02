package eldenpro.model.characters.physicalCharacters;

import eldenpro.model.characters.*;
import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

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
    public void attack(enemy enemy, damageTypes damageTypes){

        int Damage = getPhysicalDamage();

        enemy.receiveDamage(Damage, eldenpro.model.enums.damageTypes.PSY_DMG);
    }

    public void analize(enemy enemy) {
        System.out.println(enemy);
    }
    @Override
    // Metodo para recibir daño
    public void receiveDamage(int damage, damageTypes damageTypes){
        if (damageTypes == eldenpro.model.enums.damageTypes.PSY_DMG) {
            double reduction = this.armor / 100.0;
            double finalDamage = damage - (damage * reduction);
            int roundedDamage = (int) Math.round(finalDamage);
            this.healthPoints -= roundedDamage; 
        } else {
            double reduction = this.magicalArmor / 100.0;
            double finalDamage = damage - (damage * reduction);
            int roundedDamage = (int) Math.round(finalDamage);
            this.healthPoints -= roundedDamage; 
        }
               
    }

}
