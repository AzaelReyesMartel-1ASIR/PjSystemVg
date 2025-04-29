package eldenpro.model.personajes;

import eldenpro.model.habilidades.*;

public class Guerrero extends PersonajeFisico implements Defendible{

    private int fuerza;
    private int armadura;
    private int escudo;

    public Guerrero(String nombre, int nivel, int salud, int fuerza, int armadura, int escudo) {
        super(nombre, nivel, salud);
        this.fuerza = fuerza;
        this.armadura = armadura;
        this.escudo = escudo;
    }

    // Metodo toString para mostrar Fuerza y armadura
    @Override
    public String toString() {
        return "Personaje Físico: -- nombre=" + getNombre() + ", nivel=" + getNivel() + ", salud=" + getSalud() + ", fuerza="+ fuerza +", armadura="+ armadura +", escudo="+ escudo +" --";
    }

    @Override
    public void atacar() {
        System.out.println(getNombre() + " ataca con un golpe físico!");
    }

    public void cargarAtaque(){

        System.out.println(getNombre() + " está cargando su próximo ataque...");

    }

    @Override
    public void aumentarResistencia() {
        System.out.println("El Guerrero "+getNombre()+" aumenta su resistencia!");
    }

    public void defender() {
        System.out.println(getNombre() + " se defiende usando su armadura!");
    }

    @Override
    public void defensaParry() {
        System.out.println(getNombre()+" ¡¡¡UTILIZA SU HABILIDAD `PARRY` Y LANZA UN CONTRAGOLPE!!!");
    }
}
