package drones;

public class BrujulaAlEste extends Brujula{

    public BrujulaAlEste() {super("Este");}

    public Brujula girarDerecha() {return new BrujulaAlSur();}

    public Brujula girarIzquierda() {return new BrujulaAlNorte();}
}
