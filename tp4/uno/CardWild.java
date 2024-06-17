package uno;

public class CardWild extends Card {

    public CardWild() {
        super("", -1); // Wild cards have no color or number
    }

    public boolean canBePlayedOn(Card topCard) {
        return true;
    }

    public void action(UnoGame game, String player) {
        game.setCurrentState(game.getCurrentState().getNext());
    }

    public void chooseColor(String color) {
        this.color = color;
    }

}