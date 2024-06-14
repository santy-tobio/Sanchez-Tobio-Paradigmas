package uno;

public class StatePlayer1Playing extends StatusUno {

    public StatePlayer1Playing(UnoGame currentGame) {
        super(currentGame);
    }

    public void playPlayer1At(UnoGame game, Card card) {
        game.playCard(card);
        currentGame.modifyState(selectStatus());
    }

    public void playPlayer2At(UnoGame game, Card card) {
        throw new RuntimeException("It is not player 2's turn");
    }

    public boolean isValid() {
        return !currentGame.isGameFinished()
                && !currentGame.isPlayingPlayer1()
                && currentGame.isPlayingPlayer2();
    }

    public boolean isPlayingPlayer1() {
        return true;
    }

}
