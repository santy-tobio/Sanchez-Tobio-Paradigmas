package drones;

public class ComandoDesplegar extends Comando {

    private String comandoAEjecutar = "d";

    public boolean ejecutaElComando(String comando) {
        return this.comandoAEjecutar.equals(comando);
    }

    public void ejecutarComando() {

    }

    public void ejecutarComando(Axiom axiom) {
        Sonda.desplegar();
    }

}
