package eldenpro.model.personajes;

public class Mago extends PersonajeMagico {
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
        return "Personaje Mágico: -- nombre=" + nombre + ", nivel=" + nivel + ", salud=" + salud + ", magia=" + magia + ", mana="+ mana +", sabiduria="+ sabiduria +" --";
    }

    @Override
    public void atacar() {
        System.out.println(nombre + " lanza un hechizo mágico común!");
    }

    public void lanzarHechizo(){

        System.out.println(nombre + " lanza una bola de fuego!");

    }
     
    public void regenerarMana(){

        System.out.println(nombre + " aprovecha para recuperar maná para el siguiente ataque!");

    }
}
