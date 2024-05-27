package drones;

public class ComandoIncrementarVelocidad extends Comando {
    private String comandoAEjecutar = "i";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getVelocidad().incrementarVelocidad(axiom);
    }
}
