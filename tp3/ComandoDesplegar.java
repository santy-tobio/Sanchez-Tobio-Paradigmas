package drones;

public abstract class ComandoDesplegar extends Comando {

    private String comandoAEjecutar = "d";

    public boolean ejecutaElComando(String comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando(Dron dron) {
        dron.desplegar();
    }
}
