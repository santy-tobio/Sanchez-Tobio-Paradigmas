package drones;

public class DronSondaNoDesplegada extends Dron{

    public DronSondaNoDesplegada(int velocidad, boolean sondaDesplegada, Brujula brujula) {
        super(velocidad, sondaDesplegada, brujula);
        this.sondaDesplegada = false;
        this.direccion = brujula.direccion;
    }

    public void incrementarVelocidad() {
        this.velocidad++;
    }

    public void disminuirVelocidad() {
        this.velocidad--;
    }


    //double dispatchear ambas rotaciones
    //
    public void rotarIzquierda() {
        brujula = brujula.girarIzquierda();
        this.direccion = brujula.direccion;
    }

    public void rotarDerecha() {
        brujula = brujula.girarDerecha();
        this.direccion = brujula.direccion;
    }

    public void desplegarSonda() {
        this.sondaDesplegada = true;
    }

    public void recuperarSonda() {
        throw new RuntimeException("No se puede recuperar la sonda si no está desplegada");
    }



}
