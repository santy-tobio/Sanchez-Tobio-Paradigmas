package drones;

public class ComandoRecuperar extends Comando {
    private char comandoAEjecutar = 'f';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().recuperarSonda(axiom);
    }
}
