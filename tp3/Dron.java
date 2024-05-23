package drones;

import java.util.HashMap;
import java.util.Map;

public class Dron {
    private Sonda sonda;
    private int velocidad;
    private Brujula brujula;
    //crea un stream para mapear los comandos con sus letras
    private Map<String, Runnable> comandos = new HashMap<>();

    public Dron() {
        this.sonda = new SondaNoDesplegada();
        this.velocidad = 0;
        this.brujula = new BrujulaAlNorte();
    }

    public void setSonda(Sonda sonda) {
        this.sonda = sonda;
    }

    public void setBrujula(Brujula brujula) {
        this.brujula = brujula;
    }

    public Brujula getBrujula() {
        return brujula;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }


    public int getVelocidad() {
        return velocidad;
    }

    public void incrementarVelocidad() {
        sonda.incrementarVelocidad(this);
    }

    public void disminuirVelocidad() {
        sonda.disminuirVelocidad(this);
    }


    // ver si tiene sentido crear una funcion para detenerse si esto va apara el manejo de excepciones
    public void detenerse() {
        sonda.deternerse(this);
    }

    public void rotarIzquierda() {
        sonda.rotarIzquierda(this);
    }

    public void rotarDerecha() {
        sonda.rotarDerecha(this);
    }

    public void desplegar() {
        sonda.desplegar(this);
    }

    public void recuperar() {
        sonda.recuperar(this);
    }

    //acá ahi que implementar los comandos
    public void ejecutarComando(String comando) {
    }


}

