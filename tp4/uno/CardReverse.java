package uno;

public class CardReverse extends Card {
    protected String color;

    public CardReverse(String color) {
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
        return topCard.likesColor(this.color) || canGetOnTopOfReverseCard();
    }

    @Override
    public void processCard(UnoGame game) {
        game.processCardAsReverse();
    }

    public boolean canGetOnTopOfReverseCard(){
        return true;
    }

}
