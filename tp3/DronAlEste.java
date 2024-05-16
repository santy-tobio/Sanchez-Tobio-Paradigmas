package drones;

public class DronAlEste extends DronSondaNoDesplegada{

    public DronAlEste(int velocidad, String direccion, boolean sondaDesplegada) {
        super(velocidad, direccion, sondaDesplegada);
        this.direccion = "E";
    }

}
