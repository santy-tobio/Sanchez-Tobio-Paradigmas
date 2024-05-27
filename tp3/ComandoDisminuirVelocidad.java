package drones;

public class ComandoDisminuirVelocidad extends Comando {
    private String comandoAEjecutar = "s";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getVelocidad().disminuirVelocidad(axiom);
    }
}