/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private static final Logger LOG = Logger.getLogger(AppTest.class.getName());

    enum Especies {
        Perro, Gato, Hamster
    }
    
    enum Razas {
        Labrador, Bulldog, Beagle, Poodle, Chihuahua, Boxer, Siames, Persa, Bengala, Ragdoll, Sirio, Roborovski, Chino, EnanoRuso, Otro
    }
    
    enum Genero {
        Masculino, Femenino
    }
    
    enum Color {
        Blanco, Negro, Gris, Cafe, Combinado, Otro
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        LOG.info("Iniciado test shouldAnswerWithTrue");
        assertTrue(true);
        LOG.info("Finalizando test shouldAnswerWithTrue");
    }

    /**
     * Prueba para verificar datos completos.
     */
    @Test
    public void datosCompletos() {
        LOG.info("Iniciado test datosCompletos");
        Mascotas mascota = new Mascotas("Firulais", "Perro", "Chihuahua", 2, "Masculino", "Negro", 22.5, 1);

        assertAll("Mascota",
        () -> assertEquals("Firulais", mascota.nombre()),
        () -> assertEquals(Especies.Perro, Especies.valueOf(mascota.especie())),
        () -> assertEquals(Razas.Chihuahua, Razas.valueOf(mascota.raza())),
        () -> assertEquals(2, mascota.edad()),
        () -> assertEquals(Genero.Masculino, Genero.valueOf(mascota.genero())),
        () -> assertEquals(Color.Negro, Color.valueOf(mascota.color())),
        () -> assertEquals(22.5, mascota.peso())
        );

        LOG.info("Finalizando test datosCompletos");
    }

    /**
     * Prueba para verificar que los datos de una mascota no estén nulos.
     */
    @Test
    public void datosNulos() {
        LOG.info("Inicio datosNulos");
        assertThrows(Throwable.class, () -> new Mascotas(null, null, null, 2, null, null, 18, 1));
        LOG.info("Finalización datosNulos");
    }

    /**
     * Prueba para verificar que los datos de una mascota no estén vacios.
     */
    @Test
    public void datosVacios() {
        LOG.info("Inicio datosVacios");
        assertThrows(Throwable.class, () -> new Mascotas("", "", "", 1, "", "", 18, 1));
        LOG.info("Finalización datosVacios");
    }

    /**
     * Prueba para verificar que la edad de la mascota no sea negativa.
     */
    @Test
    public void edadNegativa() {
        LOG.info("Inicio edadNegativa");
        assertThrows(Throwable.class, () -> new Mascotas("Garfield", "Gato", "Siames", -1, "Femenino", "Blanco", 12.5, 1));
        LOG.info("Finalización edadNegativa");
    }

        /**
     * Prueba para verificar que la edad de la mascota no sea negativa.
     */
    @Test
    public void pesoNegativo() {
        LOG.info("Inicio pesoNegativo");
        assertThrows(Throwable.class, () -> new Mascotas("Garfield", "Gato", "Siames", 1, "Femenino", "Blanco", -12.5, 1));
        LOG.info("Finalización pesoNegativo");
    }
}