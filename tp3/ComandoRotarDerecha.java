package drones;

public class ComandoRotarDerecha extends Comando {
    private char comandoAEjecutar = 'r';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().girarDerecha(axiom);
        axiom.setDireccion(axiom.getDireccion().girarDerecha());
    }
}