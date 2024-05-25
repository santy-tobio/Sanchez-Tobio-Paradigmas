package drones;

public class ControlEjecucion {

    public boolean errorDeEjecucion(String comando, Axiom axiom){
        return axiom.getControlSonda().estaDesplegada();
    };


}

