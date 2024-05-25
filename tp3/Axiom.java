package drones;

public class Axiom {

    private ControlVelocidad controlVelocidad = new ControlVelocidad();
    private Brujula controlBrujula = new BrujulaAlNorte();
    private Sonda controlSonda = new SondaNoDesplegada();

    public void recibirMensaje(String mensaje) {
        Comando.ejecucion(mensaje, this);
    }

    public Sonda getControlSonda() {
        return controlSonda;
    }

    public ControlVelocidad getControlVelocidad() {
        return controlVelocidad;
    }

    public Brujula getControlBrujula() {
        return controlBrujula;
    }


}


