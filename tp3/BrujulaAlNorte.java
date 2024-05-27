package drones;

public class BrujulaAlNorte extends  Brujula{

    public BrujulaAlNorte() {super("Norte");}

    public Brujula girarDerecha() {return new BrujulaAlEste();}

    public Brujula girarIzquierda() {return new BrujulaAlOeste();}
}
