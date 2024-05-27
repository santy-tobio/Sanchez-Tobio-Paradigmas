package drones;

public class SondaNoDesplegada extends Sonda {
    public void incrementarVelocidad(Axiom axiom) {
        axiom.getVelocidad().incrementarVelocidad(axiom);
    }

    public void disminuirVelocidad(Axiom axiom) {
        axiom.getVelocidad().disminuirVelocidad(axiom);
    }

    public void girarIzquierda(Axiom axiom) {
        axiom.setDireccion(axiom.getDireccion().girarIzquierda());
    }

    public void girarDerecha(Axiom axiom) {
        axiom.setDireccion(axiom.getDireccion().girarDerecha());
    }

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
