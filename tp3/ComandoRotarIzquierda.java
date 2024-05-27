package drones;

public class ComandoRotarIzquierda extends Comando {
    private String comandoAEjecutar = "l";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getDireccion().girarIzquierda();
    }
}