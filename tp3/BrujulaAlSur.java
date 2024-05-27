package drones;

public class BrujulaAlSur extends Brujula {

    public BrujulaAlSur() {
        super("Sur");
    }

    public Brujula girarDerecha() {
        return new BrujulaAlOeste();
    }

    public Brujula girarIzquierda() {
        return new BrujulaAlEste();
    }
    
}
