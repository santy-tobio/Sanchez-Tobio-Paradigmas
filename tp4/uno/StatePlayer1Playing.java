package uno;

public class StatePlayer1Playing extends GameStatus {
    @Override
    public GameStatus playPlayer1At(Game game, Card card) {
        game.playCard(card);
        if (game.checkWin()) {
            return new StateFinished("Player 1 wins!");
        }
        return nextStatus();
    }

    @Override
    public GameStatus playPlayer2At(Game game, Card card) {
        throw new RuntimeException("It is not player 2's turn");
    }

    @Override
    public GameStatus nextStatus() {
        return new StatePlayer2Playing();
    }

    @Override
    public boolean finished() {
        return false;
    }
}
