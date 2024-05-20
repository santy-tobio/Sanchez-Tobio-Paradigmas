package drones;

public class BrujulaAlOeste extends Brujula {
    
    public BrujulaAlOeste() {
        super("O");
    }

    public Brujula girarDerecha() {
        return new BrujulaAlNorte();
    }

    public Brujula girarIzquierda() {
        return new BrujulaAlSur();
    }
    
}
