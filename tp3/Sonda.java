package drones;

public abstract class Sonda {

    public Dron dron;
    abstract void incrementarVelocidad(Dron dron);
    abstract void disminuirVelocidad(Dron dron);
    abstract void deternerse(Dron dron);
    abstract void rotarIzquierda(Dron dron);
    abstract void rotarDerecha(Dron dron);
    abstract void desplegar(Dron dron);
    abstract void recuperar(Dron dron);
}
