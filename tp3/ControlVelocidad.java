package drones;

public class ControlVelocidad {

    // haz que esta clase consulte a la clase de sonda si es posible incrementar la velocidad
    public void incrementarVelocidad(Axiom axiom) {
        axiom.getSonda().incrementarVelocidad(axiom);
    }


}
