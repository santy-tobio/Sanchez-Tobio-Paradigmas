package drones;

public class Axiom {

    private int velocidad = 0;
    private String direccion = "N";
    private boolean sondaDesplegada = false;
    private ControlVelocidad controlVelocidad = new ControlVelocidad();
    private Brujula controlBrujula = new BrujulaAlNorte();
    private Sonda controlSonda = new SondaNoDesplegada();

    public void recibirMensaje(String mensaje){
        Comando.ejecucion(mensaje, this);
    }
     public Sonda getSonda() {
         return controlSonda;
     }

     //implementar los getters y setters
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
}
