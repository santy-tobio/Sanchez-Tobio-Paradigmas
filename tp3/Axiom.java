package drones;

import java.util.Queue;

public class Axiom {
    private Brujula direccion = new BrujulaAlNorte();
    private Sonda sonda = new SondaNoDesplegada();
    private Velocidad velocidad = new Velocidad();

    public Axiom recibirMensaje(String mensaje) {
        return Comando.procesarComandos(mensaje, this);
    }

    public void setVelocidad(Velocidad velocidad) {
        this.velocidad = velocidad;
    }

    public Velocidad getVelocidad() {return velocidad;}

    public void setSonda(Sonda sonda) {
        this.sonda = sonda;
    }

    public Sonda getSonda() {
        return sonda;
    }

    public void setDireccion(Brujula brujula) {
        this.direccion = brujula;
    }

    public Brujula getDireccion() {
        return direccion;
    }

}
