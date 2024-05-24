package drones;

public abstract class Sonda {

    public Dron dron;
    abstract void incrementarVelocidad(Axiom axiom);
    abstract void disminuirVelocidad(Axiom axiom);
    abstract void deternerse(Axiom axiom);
    abstract void rotarIzquierda(Axiom axiom);
    abstract void rotarDerecha(Axiom axiom);
    abstract void desplegar(Axiom axiom);
    abstract void recuperar(Axiom axiom);
}
