package eldenpro.model.characters;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

// Superclase abstracta Personaje
public abstract class character {
    public String name;
    private int level;
    public int healthPoints;
    public int armor;
    public int magicalArmor;

    // Constructor para inicializar atributos comunes
    public character(String name, int level, int healthPoints, int armor){
        this.name = name;
        this.level = level;
        this.healthPoints = healthPoints;
        this.armor = armor;
    }

    // Método abstracto que implementarán las subclases
    public abstract void attack(enemy enemy, damageTypes damageTypes);

    // Getters y Setters

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int gethealthPoints() {
        return healthPoints;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor){
        this.armor = armor;
    }

    // Método para mostrar la información del personaje
    public String toString() {
        return "Personaje [name=" + name + ", level=" + level + ", healthPoints=" + healthPoints + "]";
    }

    // Método hashCode() para generar código único del objeto
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + level;
        result = prime * result + healthPoints;
        return result;
    }

    // Método equals() para comparar si dos personajes son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        character character = (character) obj;
        return name == character.name && level == character.level && healthPoints == character.healthPoints;
    }

    // Metodo para recibir daño
    public void receiveDamage(int damage, damageTypes damageTypes){
        if (damageTypes == damageTypes.PSY_DMG) {
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

    // Metodo para defenderse
    public void defense(int damage){
        damage = 0;
    }

    public abstract void analize(enemy enemy);
}


