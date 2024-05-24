package drones;

public class ComandoRecuperar extends Comando {

        private String comandoAEjecutar = "r";

        public boolean ejecutaElComando(String comando) {
            return this.comandoAEjecutar.equals(comando);
        }

        public void ejecutarComando(Dron dron) {
            dron.recuperar();
        }
}
