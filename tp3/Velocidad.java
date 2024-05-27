package drones;

public class Velocidad {

    public Velocidad() {this.velocidad = 0;}

    public void incrementarVelocidad(Axiom axiom) {
        this.velocidad++;
    }

    public void disminuirVelocidad(Axiom axiom) {
        if (this.velocidad == 0)
        {
            throw new RuntimeException("No se puede disminuir la velocidad");
        }
        else {this.velocidad--;}
    }

    public int getVelocidad() {
        return this.velocidad;
    }

    public int velocidad = 0;
}
