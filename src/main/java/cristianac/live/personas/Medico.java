package cristianac.live.personas;

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
            System.out.println("El jugador no está lesionado");
        }

        int r_inicial = jugador.getResistencia_inicial();
        jugador.setResistencia(r_inicial);
    }

}
