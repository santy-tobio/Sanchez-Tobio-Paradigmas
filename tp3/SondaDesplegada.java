package drones;

public class SondaDesplegada extends Sonda {

    public void incrementarVelocidad(Axiom axiom) {
        axiom.getVelocidad().incrementarVelocidad(axiom);
    }

    public void disminuirVelocidad(Axiom axiom) {
        if(axiom.getVelocidad().velocidad == 1)
        {
            throw new IllegalStateException("Error catastrofico");
        }
        else {
            axiom.getVelocidad().disminuirVelocidad(axiom);
        }
    }

    public void girarIzquierda(Axiom axiom) {
        throw new IllegalStateException("Error catastrofico");
    }

    public void girarDerecha(Axiom axiom) {
        throw new IllegalStateException("Error catastrofico");
    }

    public void desplegarSonda(Axiom axiom) {
        throw new IllegalStateException("La sonda ya está desplegada");
    }

    public void recuperarSonda(Axiom axiom) {
        axiom.setSonda(new SondaNoDesplegada());
    }
}