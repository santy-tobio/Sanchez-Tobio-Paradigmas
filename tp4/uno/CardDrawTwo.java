package uno;

public class CardDrawTwo extends Card {
    protected String color;

    public CardDrawTwo(String color) {
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
        return topCard.likesColor(this.color) || topCard.canGetOnTopOfDrawTwoCard();
    }

    @Override
    public void processCard(UnoGame game) {
        game.processCardAsDrawTwo();
    }

    public boolean canGetOnTopOfDrawTwoCard(){
        return true;
    }
}