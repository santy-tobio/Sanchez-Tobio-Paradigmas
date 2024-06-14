package uno;

public class StateFinished extends GameStatus {
    private String message;

    public StateFinished(String message) {
        this.message = message;
    }

    @Override
    public GameStatus playPlayer1At(Game game, Card card) {
        throw new RuntimeException("Game is finished");
    }

    @Override
    public GameStatus playPlayer2At(Game game, Card card) {
        throw new RuntimeException("Game is finished");
    }

    @Override
    public boolean finished() {
        return true;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public GameStatus nextStatus() {
        throw new RuntimeException("Game is finished");
    }
}
