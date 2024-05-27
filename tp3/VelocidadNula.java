package drones;

public class VelocidadNula extends Velocidad {
    public void incrementarVelocidad(Axiom axiom) {
        axiom.setVelocidad(new VelocidadNoNula());
        velocidad++;
    }

    public void disminuirVelocidad(Axiom axiom) {
        axiom.getSonda().disminuirVelocidad(axiom);
    }
}