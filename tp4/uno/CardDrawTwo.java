package uno;

public class CardDrawTwo extends Card {

    public CardDrawTwo(String color) {
        super(color, -2); // -2 denotes a draw two card
    }

    public boolean canBePlayedOn(Card topCard) {
        return this.color.equals(topCard.getColor());
    }
}