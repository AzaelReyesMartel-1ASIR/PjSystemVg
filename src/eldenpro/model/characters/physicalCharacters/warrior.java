package eldenpro.model.characters.physicalCharacters;

import eldenpro.model.enemies.enemy;
import eldenpro.model.enums.damageTypes;

public class warrior extends physicalCaracter {
    public boolean defensivePosture;
    public int strengthPoints; // Aumento de ataque temporal

    public warrior(String name, int level, int healthPoints, int armor, int physicalDamage, boolean defensivePosture, int strengthPoints) {
        super(name, level, healthPoints, armor, physicalDamage);
        this.defensivePosture = defensivePosture;
        this.strengthPoints = strengthPoints;
    }

    public void chargeAttack(){
        physicalDamage *=2;
        // TODO: El daño tiene que durar solo 2 turnos
    }

    public void shieldDefense(){
        // TODO: Si el tanque decide usar el escudo como defensa, probabilidad de contraataque
    }
    
    public void defensivePosture() {
    System.out.println(name + " adopta una Postura Defensiva, levantando su escudo firmemente.");
    this.armor += 20;
    this.physicalDamage -= 5;  // Reduce ataque mientras está en postura
    this.defensivePosture = true;  // Podrías usar este flag para condicionar daño reducido
    }

    public void offensivePosture() {
        System.out.println(name + " adopta una Postura Ofensiva, baja su escudo y sube su espada, aumento de ataque y fuerza.");
        this.armor -= 20;
        this.physicalDamage += 50;  // aumenta ataque mientras está en postura
        this.strengthPoints += 20;  // Acumulable, pero solo se puede usar una vez cada 5 turnos 
        strengthCalculator(); // Aplica bono por fuerza acumulada
    }

    // Calcula y aplica automáticamente el bono de daño físico basado en fuerza
    public void strengthCalculator() {
        if (strengthPoints > 0) {
            int bonusDamage = (int) (this.strengthPoints * 0.25);
            this.physicalDamage += bonusDamage;
            System.out.println(name + " canaliza su fuerza. El daño físico aumenta en " + bonusDamage + " puntos.");
        } else {
            System.out.println("Aún no tienes la suficiente fuerza.");
        }
    
    }

    @Override
    public void attack(enemy enemy, damageTypes damageTypes) {
        // TODO Auto-generated method stub
    }

}
