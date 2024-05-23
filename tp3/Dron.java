package drones;
public class Dron {
    private Sonda sonda;
    private int velocidad;
    private Brujula direccion;

    public Dron() {
        this.sonda = new SondaNoDesplegada();
        this.velocidad = 0;
        this.direccion = new BrujulaAlNorte();
    }

    public void setSonda(Sonda sonda) {
        this.sonda = sonda;
    }

    public void setDireccion(Brujula direccion) {
        this.direccion = direccion;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public Brujula getDireccion() {
        return direccion;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void incrementarVelocidad() {
        sonda.incrementarVelocidad(this);
    }

    public void disminuirVelocidad() {
        sonda.disminuirVelocidad(this);
    }

    public void deternerse() {
        sonda.deternerse(this);
    }

    public void rotarIzquierda() {
        sonda.rotarIzquierda(this);
    }

    public void rotarDerecha() {
        sonda.rotarDerecha(this);
    }

    public void desplegar() {
        sonda.desplegar(this);
    }

    public void recuperar() {
        sonda.recuperar(this);
    }

    //acá ahi que implementar los comandos 
}

