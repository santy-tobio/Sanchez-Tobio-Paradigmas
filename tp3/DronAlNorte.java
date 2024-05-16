package drones;

public class DronAlNorte extends DronSondaNoDesplegada{

    public DronAlNorte(int velocidad, String direccion, boolean sondaDesplegada) {
        super(velocidad, direccion, sondaDesplegada);
        this.direccion = "N";
    }
}
