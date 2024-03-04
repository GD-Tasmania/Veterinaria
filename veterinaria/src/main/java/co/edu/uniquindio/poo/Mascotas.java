package co.edu.uniquindio.poo;

public record Mascotas (String nombre, String especie, String raza, int edad, String genero, String color, double peso) {
    
    public Mascotas {
        assert nombre != null && !nombre.isBlank() : "El nombre no puede ser nulo o vacio";
        assert especie != null && !especie.isBlank() : "La especie no puede ser nulo o vacio";
        assert raza != null && !raza.isBlank() : "La raza no puede ser nulo o vacio";
        assert genero != null && !genero.isBlank() : "El genero no puede ser nulo o vacio";
        assert color != null && !color.isBlank() : "El color no puede ser nulo o vacio";
        assert edad > 0 : "La edad debe ser mayor a cero";
        assert peso > 0 : "El peso debe ser mayor a cero";
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