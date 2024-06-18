package uno;

public class CardSkip extends Card {
    protected String color;

    public CardSkip(String color) {
        this.color = color;
    }

    @Override
    public boolean likesColor(String color) {
        return this.color.equals(color);
    }

    @Override
    public boolean likesNumber(int number) {
        return false;
    }

    public boolean canBePlayedOn(Card topCard) {
        return topCard.likesColor(this.color) || topCard.canGetOnTopOfSkipCard();
    }

    @Override
    public void processCard(UnoGame game) {
        game.processCardAsSkip();
    }

    public boolean canGetOnTopOfSkipCard(){
        return true;
    }
}
