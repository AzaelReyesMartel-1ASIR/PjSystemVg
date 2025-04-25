package eldenpro.model.personajes;

// Subclase abstracta PersonajeFisico que hereda de Personaje
public abstract class PersonajeFisico extends Personaje {

    // Constructor que llama al de la superclase
    public PersonajeFisico(String nombre, int nivel, int salud) {
        super(nombre, nivel, salud);
    }

    // Metodo propio de los personajes fisicos
    public void aumentarResistencia() {
        this.salud += 250;
    }

    // Metodo abstracto que debe implementar cada personaje concreto
    @Override
    public abstract void atacar();
}
