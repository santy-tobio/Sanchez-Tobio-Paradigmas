package drones;

//Los comandos son:
//        - 'i' que le indica al Axiom incrementar la velocidad.
//        - 's' que le indica al Axiom disminuir la velocidad.
//        - 'l' que le indica al Axiom rotar 90 grados a izquierda.
//- 'r' que le indica al Axiom rotar 90 grados a derecha.
//- 'd' que le indica al Axiom desplegar la sonda.
//        - 'f' que le indica al Axiom recuperar la sonda.


/*
* para implementar polimorfismo:
* - dron con sonda desplegada
* - dron con sonda no desplegada
*
* y a partir de estos dos tipos de dron, implementar los comandos
*
*
* */

public class Dron {

    int velocidad;
    String direccion;
    boolean sondaDesplegada;

    public Dron(int velocidad, String direccion, boolean sondaDesplegada) {

        this.velocidad = velocidad;
        this.direccion = direccion;
        this.sondaDesplegada = sondaDesplegada;

    }

    public void incrementarVelocidad() {
    }

    public void disminuirVelocidad() {
    }

    public void rotarIzquierda() {
    }

    public void rotarDerecha() {
    }

    public void desplegarSonda() {
    }

    public void recuperarSonda() {
    }

    public void ejecutarComando(String comando) {

        switch (comando) {
            case "i":
                incrementarVelocidad();
                break;
            case "s":
                disminuirVelocidad();
                break;
            case "l":
                rotarIzquierda();
                break;
            case "r":
                rotarDerecha();
                break;
            case "d":
                desplegarSonda();
                break;
            case "f":
                recuperarSonda();
                break;
            default:
                throw new RuntimeException("comando no reconocido");
        }

    }

}


