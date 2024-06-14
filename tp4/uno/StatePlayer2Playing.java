package uno;

public class StatePlayer2Playing extends GameStatus {
    @Override
    public GameStatus playPlayer1At(Game game, Card card) {
        throw new RuntimeException("It is not player 1's turn");
    }

    @Override
    public GameStatus playPlayer2At(Game game, Card card) {
        game.playCard(card);
        if (game.checkWin()) {
            return new StateFinished("Player 2 wins!");
        }
        return nextStatus();
    }

    @Override
    public GameStatus nextStatus() {
        return new StatePlayer1Playing();
    }

    @Override
    public boolean finished() {
        return false;
    }
}