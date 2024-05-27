package drones;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Comando {

    public static List<Comando> comandos = Arrays.asList(
            new ComandoIncrementarVelocidad(),
            new ComandoDisminuirVelocidad(),
            new ComandoRotarDerecha(),
            new ComandoRotarIzquierda(),
            new ComandoDesplegar(),
            new ComandoRecuperar()
    );

    public static void ejecucion(char mensaje, Axiom axiom){
        Comando.comandos.stream()
                .filter(comando -> comando.ejecutaElComando(mensaje))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comando no reconocido"))
                .ejecutarComando(axiom);
    }

    public static Axiom procesarComandos(String comandos, Axiom axiom) {
        comandos.chars().mapToObj(c -> (char) c).forEach(c -> ejecucion(c, axiom));
        return axiom;
    }

    public abstract boolean ejecutaElComando(char mensaje);

    public abstract void ejecutarComando(Axiom axiom);
}




