package uno;

public class CardDrawTwo extends Card {

    public CardDrawTwo(String color) {
        super(color, -2); // -2 denotes a draw two card
    }

    public boolean canBePlayedOn(Card topCard) {
        return this.color.equals(topCard.getColor());
    }

    public void action(UnoGame game, String player) {
        game.setCurrentState(game.getCurrentState().getNext());
        game.drawCard(player);
        game.drawCard(player);
    }
}