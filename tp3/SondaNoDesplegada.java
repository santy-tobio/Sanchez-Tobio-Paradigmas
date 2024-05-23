package drones;

public class SondaNoDesplegada extends Sonda{
    //implementate esta clase como sondaDesplegada
    public void incrementarVelocidad(Dron dron) {
        dron.setVelocidad(dron.getVelocidad() + 1); //
    }

    public void disminuirVelocidad(Dron dron) {
        if (dron.getVelocidad() > 0) {
            dron.setVelocidad(dron.getVelocidad() - 1); //
        } else {
            throw new IllegalStateException("La velocidad no puede ser menor a 0");
        }
    }

    public void rotarIzquierda(Dron dron) {
        dron.getBrujula().girarIzquierda();
    }

    public void rotarDerecha(Dron dron) {
        dron.getBrujula().girarDerecha();
    }

    public void desplegar(Dron dron) {
        dron.setSonda(new SondaDesplegada());
    }

    public void recuperar(Dron dron) {
        throw new IllegalStateException("La sonda ya está en estado no desplegado");
    }

    public void deternerse(Dron dron) {
        dron.setVelocidad(0);
    }//

}
