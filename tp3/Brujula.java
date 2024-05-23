package drones;

abstract class Brujula {

    public Brujula(String direccion) {this.direccion = direccion;}
    public abstract Brujula girarIzquierda();
    public abstract Brujula girarDerecha();
    protected String direccion;
}

