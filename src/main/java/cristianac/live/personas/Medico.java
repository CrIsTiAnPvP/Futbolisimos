package cristianac.live.personas;

import cristianac.live.utils.Colors;

public class Medico extends Persona {

    private String titulacion;
    private int experiencia;

    public Medico(String nombre, String dni, int edad, String titulacion, int experiencia) {
        super(nombre, dni, edad);
        this.titulacion = titulacion;
        this.experiencia = experiencia;
    }

    public void curar(Futbolista jugador){
        int lesiones = jugador.getNum_lesiones();
        if (lesiones > 0){
            jugador.setNum_lesiones(lesiones - 1);
        } else {
            System.out.println(Colors.RED + "El jugador ("+Colors.YELLOW_BACKGROUND+jugador+Colors.BLACK_BACKGROUND+") no está lesionado"+ Colors.RESET);
        }

        float r_inicial = jugador.getResistencia_inicial();
        jugador.setResistencia(r_inicial);
    }

    // Getters
    public String getTitulacion() { return titulacion; }
    public int getExperiencia() { return experiencia; }
    public String rolEnEquipo(){ return "Medico"; }

    // Setters
    public void setTitulacion(String titulacion) { this.titulacion = titulacion; }
    public void setExperiencia(int experiencia) { this.experiencia = experiencia; }

}
