package drones;

public class ComandoRecuperar extends Comando {
    private String comandoAEjecutar = "f";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().recuperarSonda(axiom);
    }
}
