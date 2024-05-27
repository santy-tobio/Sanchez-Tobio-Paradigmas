package drones;

public class SondaNoDesplegada extends Sonda {
    public void incrementarVelocidad(Axiom axiom) {}

    public void disminuirVelocidad(Axiom axiom) {}

    public void girarIzquierda(Axiom axiom) {}

    public void girarDerecha(Axiom axiom) {}

    public void desplegarSonda(Axiom axiom) {
        if(axiom.getVelocidad().velocidad > 0){
            axiom.setSonda(new SondaDesplegada());
        }
        else{
            throw new IllegalStateException("La sonda solo se puede desplegar mientras se avanza");
        }
    }

    public void recuperarSonda(Axiom axiom) {}
}
