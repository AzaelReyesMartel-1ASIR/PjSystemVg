package eldenpro;

import java.util.ArrayList;
import eldenpro.model.personajes.*;

public class Juego {
    
    public static void main(String[] args) {
        // Creacion de personajes
        Guerrero guerrero = new Guerrero("Josue", 10, 2000, 15, 150, 50);
        Mago mago = new Mago("Azael", 27, 1000, 20, 40, 15);

        ArrayList<Personaje> personajes = new ArrayList<>();
        personajes.add(guerrero);
        personajes.add(mago);

        // Creacion del juego y mostramos las acciones
        Juego juego = new Juego();
        juego.mostrarAcciones(personajes); // LLamamos al metodo mostrarAcciones
    }

    // Metodo para mostrar las acciones de todos los personajes
    public void mostrarAcciones(ArrayList<Personaje> personajes) {
        for (Personaje p : personajes) {
            System.out.println(p); // Mostramos la informacion del personaje
            p.atacar(); // Llamamos al metodo atacar()

            // Usamos instanceof para verificar la clase concreta y ejecutar habilidades especificas
            if (p instanceof Guerrero) {
                Guerrero g = (Guerrero) p; // Hacemos un cast a Guerrero

                // Llamamos a metodos especificos de Guerrero
                g.defender();
                g.cargarAtaque();

            } 
            
            if (p instanceof Mago) {
                Mago m = (Mago) p; // Hacemos un cast a Mago
                
                // Llamamos a metodos especficos de Mago
                m.regenerarMana();
                m.lanzarHechizo();
            }

            System.out.println("\n");
        }
    }
}
