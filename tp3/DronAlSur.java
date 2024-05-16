package drones;

public class DronAlSur extends DronSondaNoDesplegada{

    public DronAlSur(int velocidad, String direccion, boolean sondaDesplegada) {
        super(velocidad, direccion, sondaDesplegada);
        this.direccion = "S";
    }
    
}
