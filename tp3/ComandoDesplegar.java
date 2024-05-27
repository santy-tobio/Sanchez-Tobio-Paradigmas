package drones;

public class ComandoDesplegar extends Comando {
    private String comandoAEjecutar = "d";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().desplegarSonda(axiom);
    }
}