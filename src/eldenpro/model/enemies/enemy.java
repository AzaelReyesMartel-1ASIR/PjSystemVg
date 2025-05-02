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
    private String name;
    private damageTypes damageType;

    public enemy(int healthPoints, int physicalArmor, int magicalArmor, int level, int physicalDamage, int magicalDamage, String name, damageTypes damageType) {
        this.healthPoints = healthPoints;
        this.physicalArmor = physicalArmor;
        this.magicalArmor = magicalArmor;
        this.level = level;
        this.physicalDamage = physicalDamage;
        this.magicalDamage = magicalDamage;
        this.name = name;
        this.damageType = damageType;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public damageTypes getTipo() {
        return this.damageType;
    }

    public void setName(String name) {
        this.name = name;
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

    public damageTypes getDamageType() {
        return damageType;
    }

    public void setDamageType(damageTypes damageType) {
        this.damageType = damageType;
    }

    // Método abstracto para atacar
    public abstract void attack(character character, damageTypes damageType);

    // Método para recibir daño con validación de armadura
    public void receiveDamage(int damage, damageTypes damageType) {
        double reduction = 0.0;
        if (damageType == damageTypes.PSY_DMG) {
            reduction = this.physicalArmor / 100.0;
        } else if (damageType == damageTypes.MAG_DMG) {
            reduction = this.magicalArmor / 100.0;
        }
        double finalDamage = damage - (damage * reduction);
        int roundedDamage = (int) Math.round(finalDamage);
        this.healthPoints -= roundedDamage;
        if (this.healthPoints < 0) {
            this.healthPoints = 0; // Evitar valores negativos
        }
    }

    @Override
    public String toString() {
        return "Enemy [name=" + getName() + ", healthPoints=" + getHealthPoints() + ", physicalArmor=" + getPhysicalArmor()
                + ", magicalArmor=" + getMagicalArmor() + ", level=" + getLevel() + "]";
    }
}