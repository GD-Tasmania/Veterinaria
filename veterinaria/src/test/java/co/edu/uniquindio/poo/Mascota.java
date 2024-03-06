package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class Mascota {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());
    
    /**
     * Prueba para verificar que se agregue una mascota
     */
    @Test
    public void agregarMascota() {
        LOG.info("Inicio agregarMascota");

        Veterinaria veterinaria = new Veterinaria("Mis mascoticas");
        Mascotas mascota = new Mascotas("Garfield", "Gato", "Siames", 1, "Femenino", "Blanco", 12.5, 001);

        veterinaria.registrarMascota(mascota);

        assertTrue(veterinaria.getListaMascotas().contains(mascota));
        assertEquals(1, veterinaria.getListaMascotas().size());

        LOG.info("Finalización agregarMascota");
    }

    /**
     * Prueba para verificar que los datos de un curso no estén nulos
     */
    @Test
    public void veterinariaNula() {
        LOG.info("Inicio veterinariaNula");

        assertThrows(Throwable.class, () -> new Veterinaria(null));

        LOG.info("Finalización veterinariaNula");
    }

    /**
     * Prueba para verificar que los datos de un curso no estén nulos
     */
    @Test
    public void agregarMascotaRepetida() {
        LOG.info("Inicio agregarMascotaRepetida");

        var veterinaria = new Veterinaria("Programación I");

        var mascota1 = new Mascotas("Garfield", "Gato", "Siames", 10, "Femenino", "Blanco", 8.5, 1);
        var mascota2 = new Mascotas("Gufi", "Perro", "Chihuahua", 12, "Masculino", "Negro", 12.5, 1);

        veterinaria.registrarMascota(mascota1);

        assertThrows(Throwable.class, () -> veterinaria.registrarMascota(mascota2));

        LOG.info("Finalización agregarMascotaRepetida");
    }
}
