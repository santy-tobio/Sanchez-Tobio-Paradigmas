package drones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DronTest {

    @Test
    public void test01DronSondaNoDesplegadaDesplegarSonda() {
        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, false, new Brujula("N"));
        dron.desplegarSonda();
        assertTrue(dron.sondaDesplegada);
    }

    @Test
    public void test02DronSondaNoDesplegadaRecuperarSonda() {
        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, false, new Brujula("N"));
        assertThrows(RuntimeException.class, () -> dron.recuperarSonda());
    }

    @Test
    public void test03DronSondaDesplegadaDesplegarSonda() {
        DronSondaDesplegada dron = new DronSondaDesplegada(1,  true, new Brujula("N"));
        assertThrows(RuntimeException.class, () -> dron.desplegarSonda());
    }

    @Test
    public void test04DronSondaDesplegadaRecuperarSonda() {
        DronSondaDesplegada dron = new DronSondaDesplegada(1, true, new BrujulaAlNorte());
        dron.recuperarSonda();
        assertFalse(dron.sondaDesplegada);
    }

    @Test
    public void test05DronSondaNoDesplegadaRotarIzquierda() {
        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, false, new BrujulaAlNorte());
        dron.rotarIzquierda();
        assertEquals("O", dron.direccion);
    }

//    @Test
//    public void test01DronSondaNoDesplegadaDesplegarSonda() {
//        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, "N", false, Brujula );
//        dron.desplegarSonda();
//        assertTrue(dron.sondaDesplegada);
//    }
//
//    @Test
//    public void test02DronSondaNoDesplegadaRecuperarSonda() {
//        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, "N", false);
//        assertThrows(RuntimeException.class, () -> dron.recuperarSonda());
//    }
//
//    @Test
//    public void test03DronSondaDesplegadaDesplegarSonda() {
//        DronSondaDesplegada dron = new DronSondaDesplegada(1, "N", true);
//        assertThrows(RuntimeException.class, () -> dron.desplegarSonda());
//    }
//
//    @Test
//    public void test04DronSondaDesplegadaRecuperarSonda() {
//        DronSondaDesplegada dron = new DronSondaDesplegada(1, "N", true);
//        dron.recuperarSonda();
//        assertFalse(dron.sondaDesplegada);
//    }
//
//    @Test
//    public void test05DronSondaNoDesplegadaRotarIzquierda() {
//        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, "N", false);
//        dron.rotarIzquierda();
//        assertEquals("O", dron.direccion);
//    }
//
//    @Test
//    public void test06DronSondaNoDesplegadaRotarDerecha() {
//        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, "N", false);
//        dron.rotarDerecha();
//        assertEquals("E", dron.direccion);
//    }
//
//    @Test
//    public void test07DronSondaDesplegadaRotarIzquierda() {
//        DronSondaDesplegada dron = new DronSondaDesplegada(1, "N", true);
//        assertThrows(RuntimeException.class, () -> dron.rotarIzquierda());
//    }
//
//    @Test
//    public void test08DronSondaDesplegadaRotarDerecha() {
//        DronSondaDesplegada dron = new DronSondaDesplegada(1, "N", true);
//        assertThrows(RuntimeException.class, () -> dron.rotarDerecha());
//    }
//
//    @Test
//    public void test09DronSondaDesplegadaDetener() {
//        DronSondaDesplegada dron = new DronSondaDesplegada(1, "N", true);
//        assertThrows(RuntimeException.class, () -> dron.disminuirVelocidad());
//    }
//
//    @Test
//    public void test10DronSondaNoDesplegadaDetener() {
//        DronSondaNoDesplegada dron = new DronSondaNoDesplegada(1, "N", false);
//        dron.disminuirVelocidad();
//        assertEquals(0, dron.velocidad);
//    }
}
