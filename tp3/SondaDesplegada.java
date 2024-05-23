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

    public void deternerse(Dron dron) {throw new IllegalStateException("No se puede detener con la sonda desplegada");}

    public void rotarIzquierda(Dron dron) {errorAlRotar();}

    public void rotarDerecha(Dron dron) {errorAlRotar();}

    public void desplegar(Dron dron) {throw new IllegalStateException("La sonda ya está desplegada") ;}

    public void recuperar(Dron dron) {dron.setSonda(new SondaNoDesplegada());} //deberiamos poner un if?

    private static void errorAlRotar() {
        throw new IllegalStateException("No se puede rotar con la sonda desplegada");
    }
}
