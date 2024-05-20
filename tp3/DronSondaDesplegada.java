package drones;

public class DronSondaDesplegada extends Dron{

    public DronSondaDesplegada(int velocidad, boolean sondaDesplegada, Brujula brujula) {
        super(velocidad, sondaDesplegada, brujula);
        this.sondaDesplegada = true;
    }

    public void incrementarVelocidad() {
        this.velocidad++;
    }

    public void disminuirVelocidad() {
        if (this.velocidad == 1){
            throw new RuntimeException("El dron no se puede detener con la sonda desplegada");
        }
        this.velocidad--;
    }

    public void rotarIzquierda() {
        throw new RuntimeException("El dron no puede rotar con la sonda desplegada");
    }

    public void rotarDerecha() {
        throw new RuntimeException("El dron no puede rotar con la sonda desplegada");
    }

    public void desplegarSonda() {
        throw new RuntimeException("La sonda ya está desplegada");
    }

    public void recuperarSonda() {
        this.sondaDesplegada = false;
    }

}
