package drones;

public class ComandoDisminuirVelocidad extends Comando {
    private char comandoAEjecutar = 's';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().disminuirVelocidad(axiom);
        axiom.getVelocidad().disminuirVelocidad(axiom);
    }
}