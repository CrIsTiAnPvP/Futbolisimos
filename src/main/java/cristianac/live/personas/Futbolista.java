package cristianac.live.personas;

import cristianac.live.utils.Colors;

import java.util.Random;

public class Futbolista extends Persona {

    private int numero;
    private String posicion;
    private float resistencia;
    private float resistencia_inicial;
    private int num_lesiones;

    public Futbolista(String nombre, String dni, int edad, int numero, String posicion, int num_lesiones, float resistencia_inicial) {
        super(nombre, dni, edad);
        this.numero = numero;
        this.posicion = posicion;
        this.resistencia = resistencia_inicial;
        this.resistencia_inicial = resistencia_inicial;
        this.num_lesiones = num_lesiones;
    }

    // Hacer que el futbolista entrene y aumente su resistencia
    public void entrenar(float res) { this.resistencia = res; }

    // Hacemos que al lesionarse, el futbolista pierda resistencia y sume una lesión
    public void lesionarse() {
        Random rand = new Random();
        int nueva_r = rand.nextInt(4);
        this.resistencia -= nueva_r;
        this.num_lesiones++;
        System.out.println(Colors.PURPLE+"El jugador: " +Colors.WHITE+this.getNombre()+Colors.PURPLE+" se ha lesionado"+Colors.RESET);
    }

    // Getters
    public int getNum_lesiones() { return num_lesiones; }
    public float getResistencia() { return resistencia; }
    public int getNumero() { return numero; }
    public String getPosicion() { return posicion; }
    public float getResistencia_inicial() { return resistencia_inicial; }
    public String rolEnEquipo(){ return "Jugador"; }

    // Setters
    public void setNum_lesiones(int num_lesiones) { this.num_lesiones = num_lesiones; }
    public void setResistencia(float res) { this.resistencia = res; }
    public void setNumero(int numero) { this.numero = numero; }
    public void setPosicion(String posicion) { this.posicion = posicion; }

}
