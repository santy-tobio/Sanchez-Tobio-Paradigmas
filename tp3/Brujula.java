package drones;

public class Brujula {

    public String direccion;

        public Brujula(String direccion) {
            this.direccion = direccion;
        }

        public Brujula girarDerecha() {
            return new Brujula(direccion);
        }

        public Brujula girarIzquierda() {
            return new Brujula(direccion);
        }

}

