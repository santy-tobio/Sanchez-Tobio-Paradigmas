package drones;

public class ComandoDisminuirVelocidad extends Comando {

    public boolean ejecutaElComando(String comando) {
        return false;
    }

    public void ejecutarComando() {
        axiom.getControlVelocidad().disminuirVelocidad();
    }

}
