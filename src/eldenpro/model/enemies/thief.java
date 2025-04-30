package eldenpro.model.enemies;

import eldenpro.model.characters.character;
import eldenpro.model.enums.damageTypes;

public class thief extends enemy {
    private int physicalDamage;
    private int agilityPoints; // Velocidad de ataque

    public thief(int healthPoints, int physicalArmor, int magicalArmor, int level, int physicalDamage, int agilityPoints) {
        super(healthPoints, physicalArmor, magicalArmor, level, agilityPoints, agilityPoints);
        this.agilityPoints = agilityPoints;
        this.physicalDamage = physicalDamage;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public int getAgilityPoints() {
        return agilityPoints;
    }

    public void setAgilityPoints(int agilityPoints) {
        this.agilityPoints = agilityPoints;
    }

    // El ladrón solo cuenta con daño físico, tiene una daga, bombas y mucha
    // agilidad pero poca vida
    @Override
    public void attack(character character) {
        int maxDamage = (int) ((int) physicalDamage + agilityPoints * (0.1));
        character.receiveDamage(maxDamage, damageTypes.PSY_DMG);
        agilityPoints ++;
    }

    public void throwingBombs(character character) {
        double chance = Math.random();
        if (chance <= 0.05) {
            System.out.println("El ladrón lanza una bomba que explota y afecta a todos los enemigos cercanos.");
            character.receiveDamage(100, damageTypes.PSY_DMG); // Daño fijo de la bomba explosión
        } else {
            System.out.println("El ladrón no puede lanzar una bomba.");
        }
    }

    // Al set el ladrón de las cuevas le aumenta el daño recibido un 50% y si recibe daño mágico se duplica sin contar su armadura
    @Override
    public void receiveDamage(int damage, damageTypes damageTypes) {
        if (this instanceof thief) { // Uso del instanceof para detectar el tipo específico
            if (damageTypes == damageTypes.MAG_DMG) {
                // Doble daño mágico
                setHealthPoints(getHealthPoints() - damage * 2);
            } else {
                // Reducción por armadura y luego + 50%
                int reducedDamage = (int) (damage * (1 - getPhysicalArmor() / 100.0));
                int finalDamage = (int) (reducedDamage * 1.5);
                setHealthPoints(getHealthPoints() - finalDamage * 2);
            }
        } else {
            // Lógica genérica para otros personajes
            if (damageTypes == damageTypes.MAG_DMG) {
                setHealthPoints(getHealthPoints() - damage * 2);
            } else {
                int reducedDamage = (int) (damage * (1 - getPhysicalArmor() / 100.0));
                setHealthPoints(getHealthPoints() - reducedDamage * 2);
            }
        }
    }

    @Override
    public String toString() {
        return  "===== ESTADO DEL LADRÓN =====\n" +
        "• Salud:           " + getHealthPoints() + "\n" +
        "• Daño físico:     " + getPhysicalDamage() + "\n" +
        "• Armadura física: " + getPhysicalArmor() + "\n" +
        "• Agilidad:        " + getAgilityPoints() + "\n" +
        "• Armadura mágica: " + getMagicalArmor() + "\n" +
        "• Nivel:           " + getLevel() + "\n" +
        "=============================";
    }

}
