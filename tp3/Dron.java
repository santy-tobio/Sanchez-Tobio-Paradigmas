package drones;
public class Dron {
    private Sonda sonda;
    private int velocidad;
    private Brujula direccion;

    public Dron() {
        this.sonda = new SondaNoDesplejada();
        this.velocidad = 0;
        this.direccion = new BrujulaAlNorte();
    }

    public void incrementarVelocidad() {
        sonda.incrementarVelocidad(this);
    }

    public void disminuirVelocidad() {
        sonda.disminuirVelocidad(this);
    }

    public void rotarIzquierda() {
        sonda.rotarIzquierda(this);
    }

    public void rotarDerecha() {
        sonda.rotarDerecha(this);
    }

    public void desplegarSonda() {
        sonda.desplegar(this);
    }

    public void recuperarSonda() {
        sonda.recuperar(this);
    }
}
