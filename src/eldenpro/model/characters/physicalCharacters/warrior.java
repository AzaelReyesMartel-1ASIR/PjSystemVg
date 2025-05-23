package eldenpro.model.characters.physicalCharacters;

import java.util.Scanner;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;
import eldenpro.model.abilities.defendible;

public class warrior extends physicalCaracter implements defendible {
    public boolean defensivePosture;
    public int strengthPoints; // Aumento de ataque temporal

    public warrior(String name, int level, int healthPoints, int armor, int physicalDamage, boolean defensivePosture, int strengthPoints) {
        super(name, level, healthPoints, armor, physicalDamage);
        this.defensivePosture = defensivePosture;
        this.strengthPoints = strengthPoints;
    }

    public void atacar(){
        // Implementación del ataque
        System.out.println(getName() + " - GUERRERO ataca al enemigo.");
    }

    public void setDefensivePosture(boolean defensivePosture) {
        this.defensivePosture = defensivePosture;
    }

    public void setStrengthPoints(int strengthPoints) {
        this.strengthPoints = strengthPoints;
    }

    public int getStrengthPoints(){
        return strengthPoints;
    }
    public void chargeAttack(){
        System.out.println("El GUERRERO carga su ataque.");
        physicalDamage *=2;
    }

    @Override
    public void shieldDefense(enemy enemy, int incomingDamage){
        double chance = Math.random();

        if (chance <= 0.25) {
            System.out.println("¡Contraataca con su espada!");
            if (enemy.getTipo() == damageTypes.PSY_DMG) {
                enemy.receiveDamage(incomingDamage, damageTypes.PSY_DMG); // Aplica el mismo daño al enemigo
            } else {
                enemy.receiveDamage(incomingDamage, damageTypes.MAG_DMG); // Aplica el mismo daño al enemigo
            }
        } else {
            System.out.println("Bloquea el ataque con su escudo.");
            incomingDamage = 0;
        }
    }
    
    public void defensivePosture() {
    System.out.println(name + " adopta una Postura Defensiva, levantando su escudo firmemente.");
    setArmor(getArmor() + 20);
    setPhysicalDamage(getPhysicalDamage() - 20);  // Reduce ataque mientras está en postura
    setDefensivePosture(true);  // Podrías usar este flag para condicionar daño reducido
    }

    

    public void offensivePosture() {
        System.out.println(name + " adopta una Postura Ofensiva, baja su escudo y sube su espada, aumento de ataque y fuerza.");
        setArmor(getArmor() - 20);
        setPhysicalDamage(getPhysicalDamage() - 50);   // aumenta ataque mientras está en postura
        setStrengthPoints(getStrengthPoints() + 20);  // Acumulable
        strengthCalculator(); // Aplica bono por fuerza acumulada
    }

    // Calcula y aplica automáticamente el bono de daño físico basado en fuerza
    public void strengthCalculator() {
        if (strengthPoints > 0) {
            int bonusDamage = (int) (this.strengthPoints * 0.25);
            setPhysicalDamage(getPhysicalDamage() + bonusDamage);
            System.out.println(name + " canaliza su fuerza. El daño físico aumenta en " + bonusDamage + " puntos.");
        } else {
            System.out.println("Aún no tienes la suficiente fuerza.");
        }
    
    }

    public void swordAttack(enemy enemy, int damage, damageTypes damageTypes){ 
        System.out.println("Atacas con la espada a tu enemigo.");
        enemy.receiveDamage(damage, damageTypes);
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        Scanner sc = new Scanner(System.in); // Crear un Scanner para leer la entrada del usuario
        System.out.println("¿Qué decides hacer?");
        System.out.println("1. Adoptar postura defensiva");
        System.out.println("2. Adoptar postura ofensiva");
        System.out.println("3. Defensa de escudo");
        System.out.println("4. Cargar ataque");
        System.out.println("5. Ataque con espada");
        System.out.println("6. Defensa");
        System.out.print("Elige una opción: ");
        
        int op = sc.nextInt(); // Leer la opción del usuario

        switch (op) {
            case 1:
                defensivePosture();
                break;
            case 2:
                offensivePosture();
                break;
            case 3:
                if (enemy.getTipo() == eldenpro.model.enums.damageTypes.PSY_DMG) {
                    shieldDefense(enemy, enemy.getPhysicalDamage());
                } else {
                    shieldDefense(enemy, enemy.getMagicalDamage());
                }
                break;
            case 4:
                chargeAttack();
                break;
            case 5:
                swordAttack(enemy, physicalDamage, damageTypes);
                break;
            case 6:
                if (enemy.getTipo() == eldenpro.model.enums.damageTypes.PSY_DMG) {
                    defense(enemy.getPhysicalDamage());
                } else {
                    defense(enemy.getMagicalDamage());
                }
                break;
            default:
                System.out.println("Por favor selecciona una opción válida.");
                break;
        }
    }
}
