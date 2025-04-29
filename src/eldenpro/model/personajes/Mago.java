package eldenpro.model.personajes;

import eldenpro.model.habilidades.*;

public class Mago extends PersonajeMagico implements Magico, Curable{
    private int magia;
    private int mana;
    private int sabiduria;

    public Mago(String nombre, int nivel, int salud, int magia, int mana, int sabiduria) {
        super(nombre, nivel, salud);
        this.magia= magia;
        this.mana = mana;
        this.sabiduria = sabiduria;
    }



    // Metodo toString para mostrar mana y sabiduria
    @Override
    public String toString() {
        return "Personaje Mágico: -- nombre=" + getNombre() + ", nivel=" + getNivel() + ", salud=" + getSalud() + ", magia=" + magia + ", mana="+ mana +", sabiduria="+ sabiduria +" --";
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " lanza un hechizo mágico común!");
    }

    public void lanzarHechizo(){

        System.out.println(getNombre() + " lanza una bola de fuego!");

    }
     
    public void regenerarMana(){

        System.out.println(getNombre() + " aprovecha para recuperar maná para el siguiente ataque!");

    }

    @Override
    public void regeneracionVida() {
        System.out.println(getNombre() +" ¡¡¡UTILIZA SU HABILIDAD Y REGENERA VIDA!!!");
    }

    @Override
    public void magiArcana() {
        System.out.println(getNombre() +"¡¡¡UTILIZA SU MAGIA ARCANA Y LANZA UNA LLUVIA DE METEORITOS GIGANTES!!!");
    }
}
