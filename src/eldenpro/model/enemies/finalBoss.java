package eldenpro.model.enemies;

import eldenpro.model.characters.character;
import eldenpro.model.enums.damageTypes;

public class finalBoss extends enemy {

    // Constructor del jefe final
    public finalBoss(int healthPoints, int physicalArmor, int magicalArmor, int level, String name, damageTypes tipo) {
        // Llama al constructor de la clase padre (enemy)
        super(healthPoints, physicalArmor, magicalArmor, level, level, level, name, tipo);
    }

    // Habilidad: Barrido de espada
    public void sweepingEdge(character character) {
        System.out.println("El jefe " + getName() + " ataca con un barrido de espada.");
        // Aplica daño físico al personaje
        character.receiveDamage(getPhysicalDamage(), damageTypes.PSY_DMG);
    }

    // Habilidad: Lanza celestial
    public void celestialSpear(character character) {
        System.out.println("El jefe " + getName() + " ataca con una lanza celestial.");
        // Aplica daño mágico al personaje
        character.receiveDamage(getMagicalDamage(), damageTypes.MAG_DMG);
    }

    // Habilidad: Cortada final
    public void finalSlash(character character) {
        System.out.println("El jefe " + getName() + " ataca con una cortada final.");
        // Aplica el doble de daño físico al personaje
        character.receiveDamage(getPhysicalDamage() * 2, damageTypes.PSY_DMG);
    }

    @Override
    public void attack(character character, damageTypes damageTypes) {
        // Genera un número aleatorio entre 1 y 4 para elegir el ataque
        int opcion = (int) (Math.random() * 4) + 1;

        // Según el número, realiza un ataque diferente
        switch (opcion) {
            case 1:
                sweepingEdge(character); // Barrido de espada
                break;
            case 2:
                celestialSpear(character); // Lanza celestial
                break;
            case 3:
                finalSlash(character); // Cortada final
                break;
            case 4:
                System.out.println("El jefe " + getName() + " ataca con un ataque básico: " + getPhysicalDamage() + " puntos de daño.");
                // Ataque básico con daño físico
                character.receiveDamage(getPhysicalDamage(), eldenpro.model.enums.damageTypes.PSY_DMG);
                break;
            default:
                System.out.println("El jefe " + getName() + " no realiza ningún ataque.");
        }
    }

    @Override
    public void receiveDamage(int damage, damageTypes damageTypes) {
        if (damageTypes == eldenpro.model.enums.damageTypes.MAG_DMG) {
            // Si el daño es mágico, se duplica
            setHealthPoints(getHealthPoints() - damage * 2);
        } else {
            // Si el daño es físico, se reduce según la armadura y se aumenta un 50%
            int reducedDamage = (int) (damage * (1 - getPhysicalArmor() / 100.0));
            int finalDamage = (int) (reducedDamage * 1.5);
            setHealthPoints(getHealthPoints() - finalDamage);
        }
    }
}