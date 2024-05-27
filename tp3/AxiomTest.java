package drones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.function.Executable;

public class AxiomTest {
    @Test void testIncrementarVelocidad() {
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("i");
        assertEquals(1, axiom.getVelocidad());
    }

    @Test void testDisminuirVelocidad() {
        Axiom axiom = axiomEnMovimiento();
        axiom.recibirMensaje("s");
        assertEquals(0, axiom.getVelocidad());
    }

    @Test void testGirarIzquierda() {
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("l");
        assertTrue(axiom.getDireccion() instanceof BrujulaAlOeste);
    }

    @Test void testRecibirTiraDeComandos

    @Test void testGirarDerecha() {
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("r");
        assertTrue(axiom.getDireccion() instanceof BrujulaAlEste);
    }

    @Test void testDesplegarSondaEnMovimiento() {
        Axiom axiom = axiomEnMovimiento();
        axiom.recibirMensaje("d");
        assertTrue(axiom.getSonda() instanceof SondaDesplegada);
    }

    @Test void testDesplegarSondaQuieto() {
        Axiom axiom = new Axiom();
        assertThrowsLike(() -> axiom.recibirMensaje("d"),
                "La sonda solo se puede desplegar mientras se avanza");
    }

    @Test void testRecuperarSonda() {
        Axiom axiom = axiomEnMovimiento();
        axiom.recibirMensaje("d");
        axiom.recibirMensaje("f");
        assertTrue(axiom.getSonda() instanceof SondaNoDesplegada);
    }

    @Test void testComandoVacio

    @Test void testComandoDesconocido() {
        Axiom axiom = new Axiom();
        assertThrowsLike(() -> axiom.recibirMensaje("x"),
                "Comando desconocido");
    }

    @Test void testDesplegarSondaDesplgada() {
        Axiom axiom = axiomEnMovimiento();
        axiom.recibirMensaje("d");
        assertThrowsLike(()->axiom.recibirMensaje("d"),
                "La sonda ya está desplegada");
    }

    @Test void testDisminuirVelocidadMenorACero() {
        Axiom axiom = new Axiom();
        assertThrowsLike(()->axiom.recibirMensaje("s"),
                "La velocidad no puede ser menor a 0");
    }

    @Test void testGirarConSondaDesplegada() {
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("i");
        axiom.recibirMensaje("d");
        assertThrowsLike(()->axiom.recibirMensaje("l"),
                "Error catastrofico");
    }

    @Test void testDetenerseConSondaDesplegada(){
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("i");
        axiom.recibirMensaje("d");
        assertThrowsLike(()->axiom.recibirMensaje("s"),
                "Error catastrofico");
    }

    private void assertThrowsLike( Executable executable, String msg ) {
        assertEquals(
                assertThrows( Exception.class, executable )
                        .getMessage() , msg);
    }

    private Axiom axiomEnMovimiento(){
        Axiom axiom = new Axiom();
        axiom.recibirMensaje("i");
        return axiom;
    }
}




