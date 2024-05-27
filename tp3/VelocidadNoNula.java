package drones;

public class VelocidadNoNula extends Velocidad {



    public void incrementarVelocidad(Axiom axiom) {
        axiom.setVelocidad(new VelocidadNoNula());
        velocidad++;

    }

    public void disminuirVelocidad(Axiom axiom) {
        velocidad--;
        if (velocidad == 0) {
            axiom.setVelocidad(new VelocidadNula());
        }
    }
}