package drones;

public abstract class Sonda {
    public abstract void incrementarVelocidad(Axiom axiom);
    public abstract void disminuirVelocidad(Axiom axiom);
    public abstract void girarIzquierda(Axiom axiom);
    public abstract void girarDerecha(Axiom axiom);
    public abstract void desplegarSonda(Axiom axiom);
    public abstract void recuperarSonda(Axiom axiom);
}
