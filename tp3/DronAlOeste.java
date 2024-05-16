package drones;

public class DronAlOeste extends DronSondaNoDesplegada{

    public DronAlOeste(int velocidad, String direccion, boolean sondaDesplegada) {
        super(velocidad, direccion, sondaDesplegada);
        this.direccion = "O";
    }

    public void rotarIzquierda() {

    }

}
