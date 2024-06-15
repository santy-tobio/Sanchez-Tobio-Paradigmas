package uno;

public class CardSkip extends Card {

    public CardSkip(String color) {
        super(color, -3); // -3 denotes a skip card
    }

    public boolean canBePlayedOn(Card topCard) {
        return this.color.equals(topCard.getColor());
    }

    public void nextState(GameState currentState) {
        currentState.setNext(currentState.getRight().getRight());
    }

}
