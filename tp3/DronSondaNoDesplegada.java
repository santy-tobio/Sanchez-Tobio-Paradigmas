package drones;

public class DronSondaNoDesplegada extends Dron{



    public DronSondaNoDesplegada(int velocidad, String direccion, boolean sondaDesplegada) {
        super(velocidad, direccion, sondaDesplegada);
        this.sondaDesplegada = false;
    }

    public void incrementarVelocidad() {
        this.velocidad++;
    }

    public void disminuirVelocidad() {
        this.velocidad--;
    }


    //double dispatchear ambas rotaciones
    //
    public void rotarIzquierda() {
        if (this.direccion.equals("N")) {
            this.direccion = "O";
        } else if (this.direccion.equals("O")) {
            this.direccion = "S";
        } else if (this.direccion.equals("S")) {
            this.direccion = "E";
        } else if (this.direccion.equals("E")) {
            this.direccion = "N";
        }
    }

    public void rotarDerecha() {
        if (this.direccion.equals("N")) {
            this.direccion = "E";
        } else if (this.direccion.equals("E")) {
            this.direccion = "S";
        } else if (this.direccion.equals("S")) {
            this.direccion = "O";
        } else if (this.direccion.equals("O")) {
            this.direccion = "N";
        }
    }

    public void desplegarSonda() {
        this.sondaDesplegada = true;
    }

    public void recuperarSonda() {
        throw new RuntimeException("No se puede recuperar la sonda si no está desplegada");
    }



}
