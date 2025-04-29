package eldenpro.model.personajes;

// Subclase abstracta PersonajeMagico que hereda de Personaje
public abstract class PersonajeMagico extends Personaje {

    public PersonajeMagico(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    public void regenerarMana() {
        System.out.println(getNombre() + " regenera maná con energía arcana.");
    }

    @Override
    public abstract void atacar();
}