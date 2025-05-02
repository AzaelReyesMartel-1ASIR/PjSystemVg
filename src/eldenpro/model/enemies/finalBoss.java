package eldenpro.model.enemies;

import eldenpro.model.characters.character;
import eldenpro.model.enums.damageTypes;

public class finalBoss extends enemy {



    public finalBoss(int healthPoints, int physicalArmor, int magicalArmor, int level, String name, damageTypes tipo) {
        super(healthPoints, physicalArmor, magicalArmor, level, level, level, name, tipo);

    }

    public void sweepingEdge(character character){
        System.out.println("El jefe "+getName()+" ataca con un barrido de espada");
        attack(character, damageTypes.PSY_DMG);
    }
 
    public void celestialSpear(character character){
        System.out.println("El jefe"+getName()+" ataca con una lanza celestial");
        attack(character, damageTypes.MAG_DMG);
    }

    public void finalSlash(character character){
        System.out.println("El jefe "+getName()+" ataca con una cortada final");
        attack(character, damageTypes.PSY_DMG);
    }

    @Override
    public void attack(character character, damageTypes damageTypes) {
        int opciones = (int)(Math.random() * 4) + 1; // generar un ataque aleatorio entre 1 y 4
        switch(opciones){
            case 1:
                sweepingEdge(character);
            break;
            case 2:
                celestialSpear(character);
            break;
            case 3:
                finalSlash(character);
            break;
            case 4:
                System.out.println("El jefe "+getName()+" ataca con un ataque: "+getPhysicalDamage()+" puntos de daño al enemigo "+character.getName());
                character.receiveDamage(getPhysicalDamage(), damageTypes.PSY_DMG);
            break;
        }
    }

    @Override
    public void receiveDamage(int damage, damageTypes damageTypes) {
        if (this instanceof finalBoss) { // Uso del instanceof para detectar el tipo específico
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

}
