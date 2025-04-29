package eldenpro.model.personajes.personajesMagicos;

import eldenpro.model.enemigos.enemy;
// TODO: import eldenpro.model.habilidades.magical;
import eldenpro.model.personajes.*;

// Clase personaje magico
abstract class magicalCharacter extends character {
    public int magicalPoints;
    public int manaPoints;
    public int intelligencePoints;
    public int magicalDamage;
    
    public magicalCharacter(String name, int level, int healthPoints, int magicalPoints, int manaPoints, int intelligencePoints, int armor, int magicalDamage) {
        super(name, level, healthPoints, armor);
        this.intelligencePoints = intelligencePoints;
        this.magicalPoints = magicalPoints;
        this.manaPoints = manaPoints;
        this.armor = armor;
        this.magicalDamage = magicalDamage;
    }


    public int getMagicalPoints() {
        return magicalPoints;
    }


    public void setMagicalPoints(int magicalPoints) {
        this.magicalPoints = magicalPoints;
    }


    public int getManaPoints() {
        return manaPoints;
    }


    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }


    public int getIntelligencePoints() {
        return intelligencePoints;
    }


    public void setIntelligencePoints(int intelligencePoints) {
        this.intelligencePoints = intelligencePoints;
    }


   
    // Metodo abstracto heredado
    @Override
    public void attack(enemy enemy){
        System.out.println("El personaje "+name+" realiza su ataque con "+magicalDamage+" puntos de daño al enemigo "+enemy+".");
        intelligencePoints --;
        // TODO: finalBoss.recieveDamage(finalDamage);

    }

    // Comprobar si hay puntos de inteligencia para castear hechizos
    public boolean canCast(){
        if (intelligencePoints > 0) return true;
        return false;
    }

    // Comprobar si hay puntos de maná para castear esbirros
    public boolean canSummon(){
        if (manaPoints > 0) return true;
        return false;
    }

    public void summon(){
        if (canSummon()){
            System.out.println("El personaje "+name+" castea un esbirro que cura");
            healthPoints += 10;
        } else {
            System.out.println("la invocación ha sido fallida!");
        }

    }
}
