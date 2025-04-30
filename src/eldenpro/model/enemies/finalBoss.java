package eldenpro.model.enemies;

import eldenpro.model.characters.character;

public class finalBoss extends enemy {

    public finalBoss(int healthPoints, int physicalArmor, int magicalArmor, int level) {
        super(healthPoints, physicalArmor, magicalArmor, level, level, level);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void attack(character character) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'attack'");
    }
    
}
