package drones;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.function.Executable;

public class AxiomTest {
    @Test void testIncrementarVelocidad() {
        assertEquals(1, new Axiom().recibirMensaje("i").getVelocidad().getVelocidad());
    }

    @Test void testDisminuirVelocidad() {
        assertEquals(0, axiomEnMovimiento().recibirMensaje("s").getVelocidad().getVelocidad());
    }

    @Test void testGirarIzquierda() {
        assertTrue(new Axiom().recibirMensaje("l").getDireccion() instanceof BrujulaAlOeste);
    }

    @Test void testGirarDerecha() {
        assertTrue(new Axiom().recibirMensaje("r").getDireccion() instanceof BrujulaAlEste);
    }

    @Test void testRecibirTiraDeComandos() {
        Axiom axiom = new Axiom().recibirMensaje("ilr");
        assertTrue(axiom.getDireccion() instanceof BrujulaAlNorte);
        assertTrue(axiom.getVelocidad().getVelocidad() == 1);
    }

    @Test void testGiroCompleto() {
        assertTrue(new Axiom().recibirMensaje("llll").getDireccion() instanceof BrujulaAlNorte);
    }

    @Test void testDesplegarSondaEnMovimiento() {
        assertTrue(axiomEnMovimiento().recibirMensaje("d").getSonda() instanceof SondaDesplegada);
    }

    @Test void testDesplegarSondaQuieto() {
        assertThrowsLike(() -> new Axiom().recibirMensaje("d"),
                "La sonda solo se puede desplegar mientras se avanza");
    }

    @Test void testRecuperarSonda() {
        assertTrue(axiomEnMovimiento().recibirMensaje("df").getSonda() instanceof SondaNoDesplegada);
    }

    @Test void testComandoVacio() {
        assertThrowsLike(() -> new Axiom().recibirMensaje("Comando no reconocido"),
                "Comando no reconocido");
    }

    @Test void testComandoDesconocido() {
        assertThrowsLike(() -> new Axiom().recibirMensaje("Comando no reconocido"),
                "Comando no reconocido");
    }

    @Test void testDesplegarSondaDesplgada() {
        assertThrowsLike(()->axiomEnMovimiento().recibirMensaje("d").recibirMensaje("d"),
                "La sonda ya está desplegada");
    }

    @Test void testDisminuirVelocidadMenorACero() {
        assertThrowsLike(()->new Axiom().recibirMensaje("s"),
                "No se puede disminuir la velocidad");
    }

    @Test void testGirarConSondaDesplegada() {
        assertThrowsLike(()->axiomEnMovimiento().recibirMensaje("dl"),
                "Error catastrofico");
    }

    @Test void testDetenerseConSondaDesplegada(){
        assertThrowsLike(()-> axiomEnMovimiento().recibirMensaje("ds"),
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




