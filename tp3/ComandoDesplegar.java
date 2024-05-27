package drones;

public class ComandoDesplegar extends Comando {
    private char comandoAEjecutar = 'd';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().desplegarSonda(axiom);
    }
}