package drones;

public class BrujulaAlSur extends Brujula {

    public BrujulaAlSur() {
        super("S");
    }

    public Brujula girarDerecha() {
        return new BrujulaAlOeste();
    }

    public Brujula girarIzquierda() {
        return new BrujulaAlEste();
    }
    
}
