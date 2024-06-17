package uno;

public class CardNumber extends Card {
    public CardNumber(String color, int number) {
        super(color, number);
    }

    public boolean canBePlayedOn(Card topCard) {
        return this.color.equals(topCard.getColor()) || this.number == topCard.getNumber();
    }

    public void action(UnoGame game, String player) {
        game.setCurrentState(game.getCurrentState().getNext());
        //game.setCurrentState(game.getCurrentState().getNext());
    }
}

