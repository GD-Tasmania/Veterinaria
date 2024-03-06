package co.edu.uniquindio.poo;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public record Mascotas(String nombre, String especie, String raza, int edad, String genero, String color, double peso, int NumeroIdentificacion) {

    public Mascotas {
    
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (especie == null || especie.isBlank()) {
            throw new IllegalArgumentException("La especie no puede ser nula o vacía");
        }
        if (raza == null || raza.isBlank()) {
            throw new IllegalArgumentException("La raza no puede ser nula o vacía");
        }
        if (genero == null || genero.isBlank()) {
            throw new IllegalArgumentException("El género no puede ser nulo o vacío");
        }
        if (edad <= 0) {
            throw new IllegalArgumentException("La edad debe ser mayor a cero");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero");
        }
    }

    @Override
    public String toString() {
        return String.format("Mascota:\n" +
                "Nombre: %s\n" +
                "Especie: %s\n" +
                "Raza: %s\n" +
                "Edad: %d\n" +
                "Genero: %s\n" +
                "Color: %s\n" +
                "Peso: %.2f", nombre, especie, raza, edad, genero, color, peso);
    }
}

class Veterinaria {
    private List<Mascotas> listaMascotas;
    private String nombre;

    public Veterinaria(String nombre) {
        assert nombre != null : "El nombre no puede ser nulo";
        this.nombre = nombre;
        this.listaMascotas = new ArrayList<>();
    }

    /**
     * @return Nombre de la veterinaria
     */
    public String getNombre() {
        return nombre;
    }

    public void registrarMascota(Mascotas mascotas) {
        assert validarNumeroIdentificacionExiste(mascotas.NumeroIdentificacion()) == false : "El número de identificación ya existe.";
        listaMascotas.add(mascotas);
    }

    /**
     * Método privado para determinar si ya existe un estudiante registro en el
     * mismo número de identificación
     * @param numeroIdentificacion Número de identificación a buscar
     * @return Valor boolean que indica si el número de identificación ya está o no
     *         registrado.
     */
    private boolean validarNumeroIdentificacionExiste(int numeroIdentificacion) {
        Predicate<Mascotas> condicion = listaMascotas -> listaMascotas.NumeroIdentificacion() == numeroIdentificacion;
        return listaMascotas.stream().filter(condicion).findAny().isPresent();
    }

    public List<Mascotas> mascotasMayoresDe10Años() {
        List<Mascotas> mascotasMayoresDe10Años = new ArrayList<>();
        for (Mascotas mascota : listaMascotas) {
            if (mascota.edad() > 10) {
                mascotasMayoresDe10Años.add(mascota);
            }
        }
        return mascotasMayoresDe10Años;
    }

    public List<Mascotas> getListaMascotas() {
        return listaMascotas;
    }

    public void mostrarMascotas(List<Mascotas> mascotas) {
        for (Mascotas mascota : mascotas) {
            System.out.println(mascota);
        }
    }
}