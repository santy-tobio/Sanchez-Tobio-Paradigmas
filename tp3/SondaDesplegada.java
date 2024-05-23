package drones;

public class SondaDesplegada extends Sonda{
    public void incrementarVelocidad(Dron dron) {
        dron.setVelocidad(dron.getVelocidad() + 1);
    }

    public void disminuirVelocidad(Dron dron) {
        if (dron.getVelocidad() > 0) {
            dron.setVelocidad(dron.getVelocidad() - 1);
        } else {
            throw new IllegalStateException("La velocidad no puede ser menor a 0");
        }
    }

    public void deternerse(Dron dron) {
        // esto nos va a costar otro if
    }

    public void rotarIzquierda(Dron dron) {
        dron.setDireccion(dron.getDireccion().girarIzquierda());
    }
    public void rotarDerecha(Dron dron) {
        dron.setDireccion(dron.getDireccion().girarDerecha());
    }

    public void desplegar(Dron dron) {
        dron.setSonda(new SondaDesplegada()); //deberiamos poner un if?
    }

    public void recuperar(Dron dron) {
        dron.setSonda(new SondaNoDesplegada()); //deberiamos poner un if?
    }
}
