package drones;

public class BrujulaAlOeste extends Brujula {
    
    public BrujulaAlOeste() {
        super("Oeste");
    }

    public Brujula girarDerecha() {
        return new BrujulaAlNorte();
    }

    public Brujula girarIzquierda() {
        return new BrujulaAlSur();
    }
    
}
