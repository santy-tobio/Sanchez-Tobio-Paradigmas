package uno;

public class StatePlayer2Playing extends StatusUno {

    public StatePlayer2Playing(UnoGame currentGame) {
        super(currentGame);
    }

    @Override
    public void playPlayer1At(UnoGame game, Card card) {
        throw new RuntimeException("It is not player 1's turn");
    }

    @Override
    public void playPlayer2At(UnoGame game, Card card) {
        game.playCard(card);
        currentGame.modifyState(selectStatus());
    }

    @Override
    public boolean isValid() {
        return !currentGame.isGameFinished()
                && currentGame.isPlayingPlayer1()
                && !currentGame.isPlayingPlayer2();

    }

    public boolean isPlayingPlayer2() {
        return true;
    }

}