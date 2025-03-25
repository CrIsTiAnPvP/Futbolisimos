package cristianac.live.personas;

public class Entrenador extends Persona{

    private String estrategia;

    public Entrenador(String nombre, String dni, int edad, String estrategia) {
        super(nombre, dni, edad);
        this.estrategia = estrategia;
    }

    // Getters
    public String getEstrategia() {
        return estrategia;
    }
    public String rolEnEquipo(){
        return "Entrenador";
    }

    // Setters
    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

}
