package uno;

public class CardReverse extends Card {

    public CardReverse(String color) {
        super(color, -4); // -4 denotes a reverse card
    }

    public boolean canBePlayedOn(Card topCard) {
        return this.color.equals(topCard.getColor());
    }

    public void action(UnoGame game, String player) {
        game.getCurrentState().setNext(game.getCurrentState().getLeft());
    }

    public void nextState(GameState currentState) {
        currentState.setNext(currentState.getLeft());
    }
}
