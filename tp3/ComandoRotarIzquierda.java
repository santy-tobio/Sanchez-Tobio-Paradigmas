package drones;

public abstract class ComandoRotarIzquierda extends Comando {

        private String comandoAEjecutar = "i";

        public boolean ejecutaElComando(String comando) {
            return this.comandoAEjecutar.equals(comando);
        }

        public void ejecutarComando(Dron dron) {
            dron.rotarIzquierda();
        }
}
