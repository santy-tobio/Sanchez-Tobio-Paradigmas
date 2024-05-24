package drones;

public class ComandoDisminuirVelocidad extends Comando {

        private String comandoAEjecutar = "d";

        public boolean ejecutaElComando(String comando) {
            return this.comandoAEjecutar.equals(comando);
        }

        public void ejecutarComando(Dron dron) {
            dron.disminuirVelocidad();
        }
}
