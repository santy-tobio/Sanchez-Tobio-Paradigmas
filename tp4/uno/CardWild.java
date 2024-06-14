package uno;

public class CardWild extends Card {

    public CardWild() {
        super("", -1); // Wild cards have no color or number
    }

    public boolean canBePlayedOn(Card topCard) {
        return true;
    }

    public void chooseColor(String color) {
        this.color = color;
    }

}