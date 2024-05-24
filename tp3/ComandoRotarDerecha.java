package drones;

public class ComandoRotarDerecha extends Comando {

        private String comandoAEjecutar = "r";

        public boolean ejecutaElComando(String comando) {
            return this.comandoAEjecutar.equals(comando);
        }

        public void ejecutarComando(Dron dron) {
            dron.rotarDerecha();
        }
}
