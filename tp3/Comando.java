package drones;

import java.util.ArrayList;
import java.util.Arrays;

//falta agregar el handleo correcto en cada clase

public abstract class Comando {

    public Axiom axiom;
    public String comando;
    private static ArrayList<Comando> comandos = new ArrayList<Comando>(Arrays.asList(
            new ComandoDesplegar(),
            new ComandoRecuperar(),
            new ComandoDeternerse(),
            new ComandoRotarIzquierda(),
            new ComandoRotarDerecha(),
            new ComandoIncrementarVelocidad(),
            new ComandoDisminuirVelocidad()));

    public static Axiom ejecucion(String instrucciones, Axiom axiom){
        instrucciones
                .chars()
                .mapToObj(i -> (char) i)
                .forEach(i -> Comando.associatedFunction(i, axiom));
        return axiom;
    }

    public static void associatedFunction(char chars, Axiom axiom){
        comandos.stream()
                .filter(comando -> comando.ejecutaElComando(String.valueOf(chars)))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Comando no valido"))
                .ejecutarComando();
    }

    public abstract boolean ejecutaElComando(String comando);

    public abstract void ejecutarComando();

}

