package drones;

public class SondaNoDesplegada extends Sonda{

    void ejecutarComando() {
    }

    boolean estaDesplegada() {
        return false;
    }

    //

//    public void incrementarVelocidad(Axiom axiom) {; //
//    }
//
//    public void disminuirVelocidad(Axiom axiom) {
//        if (axiom.getVelocidad() > 0) {
//            axiom.setVelocidad(axiom.getVelocidad() - 1); //
//        } else {
//            throw new IllegalStateException("La velocidad no puede ser menor a 0");
//        }
//    }
//
//    public void rotarIzquierda(Axiom axiom) {
//        axiom.getBrujula().girarIzquierda();
//    }
//
//    public void rotarDerecha(Axiom axiom) {
//        axiom.getBrujula().girarDerecha();
//    }
//
//    public void desplegar(Axiom axiom) {
//        axiom.setSonda(new SondaDesplegada());
//    }
//
//    public void recuperar(Axiom axiom) {
//        throw new IllegalStateException("La sonda ya está en estado no desplegado");
//    }
//
//    public void deternerse(Axiom axiom) {
//        axiom.setVelocidad(0);
//    }//

}
