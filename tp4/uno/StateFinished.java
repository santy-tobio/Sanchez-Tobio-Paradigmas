package uno;

public class StateFinished extends StatusUno {
    private String message;

    public StateFinished(UnoGame currentGame) {
        super(currentGame);
    }

    public void playPlayer1At(UnoGame game, Card card) {
        throw new RuntimeException("Game is finished");
    }

    public void playPlayer2At(UnoGame game, Card card) {
        throw new RuntimeException("Game is finished");
    }

    public boolean isValid() {
        return currentGame.isGameFinished();

    }

    public boolean isGameFinished(){
        return true;
    }

}
