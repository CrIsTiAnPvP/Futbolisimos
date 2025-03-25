package cristianac.live.personas;

public class Persona {

    private String nombre;
    private String dni;
    private int edad;


    public Persona(String nombre, String dni, int edad) {

        if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        } else if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        } else {
            this.nombre = nombre;
        }

        // Comprobamos que el dni sea (12345678A)
        String dni_reg = "^[0-9]{8}[A-Z]$";
        if (!dni.matches(dni_reg)) {
            throw new IllegalArgumentException("El DNI no es válido");
        } else {
            this.dni = dni;
        }

        if (edad < 16) {
            throw new IllegalArgumentException("La edad no puede ser menor de 16 años");
        } else if (edad >80 ){
            throw new IllegalArgumentException("La edad no puede ser mayor de 80 años");
        } else {
            this.edad = edad;
        }

    }

    // Getters
    public String getNombre() {
        return nombre;
    }
    public String getDni(){
        return dni;
    }
    public int getEdad() {
        return edad;
    }

}
