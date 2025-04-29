package eldenpro.model.personajes;

// Superclase abstracta Personaje
public abstract class Personaje {
    private String nombre;
    private int nivel;
    private int salud;

    // Constructor para inicializar atributos comunes
    public Personaje(String nombre, int nivel, int salud){
        this.nombre = nombre;
        this.nivel = nivel;
        this.salud = salud;
    }

    // Método abstracto que implementarán las subclases
    public abstract void atacar();

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getSalud() {
        return salud;
    }

    // Método para mostrar la información del personaje
    public String toString() {
        return "Personaje [nombre=" + nombre + ", nivel=" + nivel + ", salud=" + salud + "]";
    }

    // Método hashCode() para generar código único del objeto
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + nivel;
        result = prime * result + salud;
        return result;
    }

    // Método equals() para comparar si dos personajes son iguales
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Personaje other = (Personaje) obj;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (nivel != other.nivel)
            return false;
        if (salud != other.salud)
            return false;
        return true;
    }
}