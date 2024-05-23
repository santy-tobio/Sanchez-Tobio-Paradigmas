package drones;

public class SondaNoDesplegada implements Sonda {
    @Override
    public void incrementarVelocidad(Dron dron) {
        dron.setVelocidad(dron.getVelocidad() + 1);
    }

    @Override
    public void disminuirVelocidad(Dron dron) {
        if (dron.getVelocidad() > 0) {
            dron.setVelocidad(dron.getVelocidad() - 1);
        } else {
            throw new IllegalStateException("La velocidad no puede ser menor a 0");
        }
    }

    @Override
    public void rotarIzquierda(Dron dron) {
        return new BrujulaAlOeste();
    }

    @Override
    public void rotarDerecha(Dron dron) {
        return new BrujulaAlEste();
    }

    @Override
    public void desplegar(Dron dron) {
        dron.setSonda(new SondaDesplegada());
    }

    @Override
    public void recuperar(Dron dron) {
        throw new IllegalStateException("La sonda ya está en estado no desplegado");
    }

    public void deternerse(Dron dron) {
        dron.setVelocidad(0);
    }
}
