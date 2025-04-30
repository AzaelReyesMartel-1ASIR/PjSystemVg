package eldenpro.model.enemies;

import eldenpro.model.characters.character;
import eldenpro.model.enums.damageTypes;

public abstract class enemy {
    private int healthPoints;
    private int physicalArmor;
    private int magicalArmor;
    private int level;
    private int physicalDamage;
    private int magicalDamage;


    public enemy(int healthPoints, int physicalArmor, int magicalArmor, int level, int physicalDamage, int magicalDamage) {
        this.healthPoints = healthPoints;
        this.physicalArmor = physicalArmor;
        this.magicalArmor = magicalArmor;
        this.level = level;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
    }


    public void receiveDamage(int damage, damageTypes damageTypes){
        healthPoints -= damage;
    }

    public int getHealthPoints() {
        return healthPoints;
    }



    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }



    public int getPhysicalArmor() {
        return physicalArmor;
    }



    public void setPhysicalArmor(int physicalArmor) {
        this.physicalArmor = physicalArmor;
    }



    public int getMagicalArmor() {
        return magicalArmor;
    }



    public void setMagicalArmor(int magicalArmor) {
        this.magicalArmor = magicalArmor;
    }



    public int getLevel() {
        return level;
    }



    public void setLevel(int level) {
        this.level = level;
    }



    public int getPhysicalDamage() {
        return physicalDamage;
    }



    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }



    public int getMagicalDamage() {
        return magicalDamage;
    }



    public void setMagicalDamage(int magicalDamage) {
        this.magicalDamage = magicalDamage;
    }

    public abstract void attack(character character);

    @Override
    public String toString() {
        return "enemy [healthPoints=" + healthPoints + ", physicalArmor=" + physicalArmor + ", MagicalArmor="
                + magicalArmor + ", getHealthPoints()=" + getHealthPoints() + ", getPhysicalArmor()="
                + getPhysicalArmor() + ", getMagicalArmor()=" + getMagicalArmor() + "]";
    }
}