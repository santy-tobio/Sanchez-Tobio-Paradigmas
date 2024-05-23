package drones;

public abstract class ComandoDeternerse extends Comando {

        private String comandoAEjecutar = "s";

        public boolean ejecutaElComando(String comando) {
            return this.comandoAEjecutar.equals(comando);
        }

        public void ejecutarComando(Dron dron) {
            dron.detenerse();
        }
}
