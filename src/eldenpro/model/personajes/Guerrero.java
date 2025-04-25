package eldenpro.model.personajes;

public class Guerrero extends PersonajeFisico {

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
        return "Personaje Físico: -- nombre=" + nombre + ", nivel=" + nivel + ", salud=" + salud + ", fuerza="+ fuerza +", armadura="+ armadura +", escudo="+ escudo +" --";
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " ataca con un golpe físico!");
    }

    public void cargarAtaque(){

        System.out.println(nombre + " está cargando su próximo ataque...");

    }

    public void defender() {
        System.out.println(nombre + " se defiende usando su armadura!");
    }
}
