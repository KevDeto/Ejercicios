package ejercicio5;

public enum CategoriaGasto {
    MEDICO("Gastos Médicos"),
    DOMESTICO("Gastos Domésticos"),
    OCIO("Ocio"),
    AHORRO("Ahorro"),
    EDUCACION("Educación");

    private final String nombre;

    CategoriaGasto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
