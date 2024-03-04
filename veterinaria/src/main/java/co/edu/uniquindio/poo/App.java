package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */
enum Razas {
    Labrador, Bulldog, Pastor_Aleman, Beagle, Poodle, Chihuahua, Boxer
}

public class App {
    public static void main(String[] args) {
        System.out.println("Inicio de secuencia\n");
        Mascotas mascota1 = new Mascotas("Firulais", "Perro", "Chihuahua", 2, "Masculino", "Negro", 22.5);
        System.out.println(mascota1);
    }
}