package uno;

public class CardWild extends Card {
    protected String color;

    @Override
    public boolean likesColor(String color) {
        return true;
    }

    @Override
    public boolean likesNumber(int number) {
        return true;
    }

    public boolean canBePlayedOn(Card topCard) {
        return true;
    }

    @Override
    public void processCard(UnoGame game) {
        game.processCardAsWild();
    }

    public Card chooseColor(String color) {
        this.color = color;
        return this;
    }
}









