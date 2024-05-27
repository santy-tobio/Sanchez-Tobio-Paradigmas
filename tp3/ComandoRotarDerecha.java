package drones;

public class ComandoRotarDerecha extends Comando {
    private String comandoAEjecutar = "r";

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getDireccion().girarDerecha();
    }
}