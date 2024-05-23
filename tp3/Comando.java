package drones;

public abstract class Comando {
    public Dron dron;
    public String comando;

    public abstract boolean ejecutaElComando(String comando);

    public abstract void ejecutarComando(Dron dron);

}

