package eldenpro.model.enemies;

import eldenpro.model.characters.character;
import eldenpro.model.enums.damageTypes;

public class finalBoss extends enemy {



    public finalBoss(int healthPoints, int physicalArmor, int magicalArmor, int level, String name) {
        super(healthPoints, physicalArmor, magicalArmor, level, level, level, name);

    }

    @Override
    public void attack(character character, damageTypes damageTypes) {
        
    }

    public void sweepingEdge(character character){
        System.out.println("El jefe "+getName()+" ataca con un barrido de espada");
        attackWithType(character, damageTypes.PSY_DMG);
    }
 
    public void celestialSpear(character character){
        System.out.println("El jefe"+getName()+" ataca con una lanza celestial");
        attackWithType(character, damageTypes.MAG_DMG);
    }

    public void finalSlash(character character){
        System.out.println("El jefe "+getName()+" ataca con una cortada final");
        attackWithType(character, damageTypes.PSY_DMG);
    }

    @Override
    public void attackWithType(character character, damageTypes damageTypes) {
        if (damageTypes == damageTypes.MAG_DMG) {
            int magicalDamage = getMagicalDamage();
            character.receiveDamage(magicalDamage, damageTypes.MAG_DMG);
        } else {
            int physicalDamage = getPhysicalDamage();
            character.receiveDamage(physicalDamage, damageTypes.PSY_DMG);
        }
    }

}
