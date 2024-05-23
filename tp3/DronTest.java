package drones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;

public class DronTest {

    @Test void test01IncrementarVelocidad() {
    }

    private void assertThrowsLike(Executable executable, String msg) {
        assertEquals(assertThrows(Exception.class, executable).getMessage(), msg);
    }

}



