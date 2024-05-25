package drones;

public class ComandoIncrementarVelocidad extends Comando {

    private String comandoAEjecutar = "i";

    public boolean ejecutaElComando(String comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando() {
        axiom.getControlVelocidad().incrementarVelocidad()
        ;
    }

}
