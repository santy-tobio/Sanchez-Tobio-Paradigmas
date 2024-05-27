package drones;

public class ComandoRotarIzquierda extends Comando {
    private char comandoAEjecutar = 'l';

    public boolean ejecutaElComando(char comando) {
        return this.comandoAEjecutar == comando;
    }

    public void ejecutarComando(Axiom axiom) {
        axiom.getSonda().girarIzquierda(axiom);
        axiom.setDireccion(axiom.getDireccion().girarIzquierda());
    }
}