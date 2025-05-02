package eldenpro.model.characters.magicalCharacters;

import java.util.Random;
import java.util.Scanner;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;
import eldenpro.model.abilities.healable;
import eldenpro.model.abilities.magical;

public class mage extends magicalCharacter implements magical, healable {
    private int intelligencePoints;

    public mage(String name, int level, int healthPoints, int magicalPoints, int intelligencePoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, magicalPoints, intelligencePoints, armor);
        this.intelligencePoints = intelligencePoints;
    }

    public int getIntelligencePoints() {
        return intelligencePoints;
    }

    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }
    
    // Metodo abstracto heredado de la clase character
    @Override
    public void attack(enemy enemy, damageTypes damageTypes){
        Scanner sc = new Scanner(System.in);
        int op = 5;
        System.out.println("¿qué decides hacer?\n 1.Atacar \n 2. Defenderse \n 3.Regenerar maná\n 4. Curarse");
        op = sc.nextInt();
        switch (op) {
            case 1:
            if (canCast()){
                System.out.println("El personaje "+name+" realiza su ataque con "+getMagicalDamage()+" puntos de daño al enemigo "+enemy+".");
                intelligencePoints -=2; // El coste de cada casteo es de 2 puntos de maná
                Random rand = new Random();
                int damage = rand.nextInt(getMagicalDamage()) + 1;
                enemy.receiveDamage(damage, damageTypes.MAG_DMG);    
            } else {
                // Al no tener puntos de maná, se regeneran automaticamente los puntos por el coste de un turno
                System.out.println("¡No puede hacer daño!"); 
                System.out.println("Regenerando puntos de inteligencia...");
                manaRegen();
            }
                break;
            case 2:
            if (enemy.getTipo() == damageTypes.PSY_DMG) {
                defense(enemy.getPhysicalDamage());
            } else {
                defense(enemy.getMagicalDamage());
            }
            case 3:
                manaRegen();
                break;
            case 4:
                healing();
            default:
                System.out.println("Por favor elije que hacer");
                break;
        }
    }

    // Comprobar si hay puntos de inteligencia para castear hechizos
    public boolean canCast(){
        System.out.println("¡Puedes castear! Tienes "+getIntelligencePoints()+" puntos de inteligencia");
        if (intelligencePoints > 0) return true;
        return false;
    }

    public void manaRegen(){
        intelligencePoints +=10;
    }

    @Override
    public void magicTrick(enemy enemy){
        double chance = Math.random();

        if (chance <= 0.1) {
            System.out.println("¡El truco de magia salió, un rayo gigante del cielo salió y ha matado al enemigo!");
            enemy.setHealthPoints(0);
            intelligencePoints -= 20;
        }
    }

    @Override
    public void healing() {
        System.out.println("El asesino recupera 20 puntos de vida");
        healthPoints+=20;
    }

}
