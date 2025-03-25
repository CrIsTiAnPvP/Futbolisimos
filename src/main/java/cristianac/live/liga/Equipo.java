package cristianac.live.liga;

import cristianac.live.personas.Entrenador;
import cristianac.live.personas.Futbolista;
import cristianac.live.personas.Medico;
import cristianac.live.utils.Colors;

import java.util.List;

public class Equipo {

    private String nombre;
    private String localidad;
    private Entrenador entrenador;
    private Medico medico;
    private List<Futbolista> jugadores;

    public Equipo(String nombre, String localidad, Entrenador entrenador, Medico medico, List<Futbolista> jugadores) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.entrenador = entrenador;
        this.medico = medico;
        this.jugadores = jugadores;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getLocalidad() { return localidad; }
    public Entrenador getEntrenador() { return entrenador; }
    public Medico getMedico() { return medico; }
    public List<Futbolista> getJugadores() { return jugadores; }
    public List<Futbolista> getLesionados() { return jugadores.stream().filter(f -> f.getNum_lesiones() > 0).toList(); }
    public List<Futbolista> getNoLesionados() { return jugadores.stream().filter(f -> f.getNum_lesiones() == 0).toList();}

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setLocalidad(String localidad) { this.localidad = localidad; }
    public void setEntrenador(Entrenador entrenador) { this.entrenador = entrenador; }
    public void setMedico(Medico medico) { this.medico = medico; }
    public void setJugadores(List<Futbolista> jugadores) { this.jugadores = jugadores; }

    public void Entrenar(String tipo){
        int counter = 0;
        switch (tipo.toLowerCase()) {
            case "correr":
                // Hacemos que 1 de cada 15 veces que se entrene, un jugador se lesione
                for (Futbolista f : jugadores) {
                    f.entrenar(5);
                    counter++;
                    if (counter == 15) {
                        f.lesionarse();
                        counter = 0;
                    }
                }
                break;
            case "saltar":
                // Hacemos que 1 de cada 20 veces que se entrene, un jugador se lesione
                for (Futbolista f : jugadores) {
                    f.entrenar(2.5f);
                    counter++;
                    if (counter == 20) {
                        f.lesionarse();
                        counter = 0;
                    }
                }
                break;
            case "estirar":
                // Hacemos que 1 de cada 30 veces que se entrene, un jugador se lesione
                for (Futbolista f : jugadores) {
                    f.entrenar(1);
                    counter++;
                    if (counter == 30) {
                        f.lesionarse();
                        counter = 0;
                    }
                }
                break;
            default:
                System.out.println(Colors.RED+"No se puede realizar el entrenamiento: " + Colors.CYAN + tipo + Colors.RESET);
        }

    }


}
