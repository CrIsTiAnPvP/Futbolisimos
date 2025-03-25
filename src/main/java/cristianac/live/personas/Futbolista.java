package cristianac.live.personas;

import java.util.Random;
import java.util.random.*;

public class Futbolista extends Persona {

    private int numero;
    private String posicion;
    private int resistencia;
    private int resistencia_inicial;
    private int num_lesiones;

    public Futbolista(String nombre, String dni, int edad, int numero, String posicion, int resistencia, int num_lesiones, int resistencia_inicial) {
        super(nombre, dni, edad);
        this.numero = numero;
        this.posicion = posicion;
        this.resistencia = resistencia;
        this.resistencia_inicial = resistencia_inicial;
        this.num_lesiones = num_lesiones;
    }

    // Hacer que el futbolista entrene y aumente su resistencia
    public void entrenar() {
        Random rand = new Random();
        int nueva_r = rand.nextInt(8);
        this.resistencia += nueva_r;
    }

    // Hacemos que al lesionarse, el futbolista pierda resistencia y sume una lesión
    public void lesionarse() {
        Random rand = new Random();
        int nueva_r = rand.nextInt(4);
        this.resistencia -= nueva_r;
        this.num_lesiones++;
    }

    // Getters
    public int getNum_lesiones() {
        return num_lesiones;
    }
    public int getResistencia() {
        return resistencia;
    }
    public int getNumero() {
        return numero;
    }
    public String getPosicion() {
        return posicion;
    }
    public int getResistencia_inicial() {
        return resistencia_inicial;
    }

    // Setters
    public void setNum_lesiones(int num_lesiones) {
        this.num_lesiones = num_lesiones;
    }
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }



}
