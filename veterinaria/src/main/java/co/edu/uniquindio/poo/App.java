package co.edu.uniquindio.poo;

import java.util.List;

    enum Especies {
        Perro, Gato, Hamster
    }

    enum Razas {
        Labrador, Bulldog, Beagle, Poodle, Chihuahua, Boxer, Siames, Persa, Bengala, Ragdoll, Sirio, Roborovski, Chino, EnanoRuso, Otro
    }

    enum Genero {
        Macho, Hembra
    }

    enum Color {
        Blanco, Negro, Gris, Cafe, Combinado, Otro
    }

public class App {
    public static void main(String[] args) {
        Veterinaria amigosPeludos = new Veterinaria("Mis mascoticas");

        // Registrar mascotas con valores reales.
        amigosPeludos.registrarMascota(new Mascotas("Firulais", "Perro", "Labrador", 5, "Macho", "Café", 20.5, 1));
        amigosPeludos.registrarMascota(new Mascotas("Mochi", "Gato", "Siames", 12, "Hembra", "Blanco", 5.2, 2));
        amigosPeludos.registrarMascota(new Mascotas("Rocko", "Perro", "Bulldog", 11, "Macho", "Atigrado", 18.0, 3));

        // Obtener y mostrar mascotas mayores de 10 años
        List<Mascotas> mascotasMayoresDe10Años = amigosPeludos.mascotasMayoresDe10Años();
        System.out.println("Mascotas mayores de 10 años:");
        amigosPeludos.mostrarMascotas(mascotasMayoresDe10Años);
    }
}