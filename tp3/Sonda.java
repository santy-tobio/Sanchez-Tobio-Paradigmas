package drones;

public interface Sonda {
    void incrementarVelocidad(Dron dron);
    void disminuirVelocidad(Dron dron);
    void  deternerse(Dron dron);
    void rotarIzquierda(Dron dron);
    void rotarDerecha(Dron dron);
    void desplegar(Dron dron);
    void recuperar(Dron dron);
}
