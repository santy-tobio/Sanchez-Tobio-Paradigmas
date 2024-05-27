package drones;

public class ComandoIncrementarVelocidad extends Comando {
    private char comandoAEjecutar = 'i';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getVelocidad().incrementarVelocidad(axiom);
    }
}
