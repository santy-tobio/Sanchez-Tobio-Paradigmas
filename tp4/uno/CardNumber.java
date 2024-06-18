package uno;

public class CardNumber extends Card {
    protected String color;
    protected int number;

    public CardNumber(String color, int number) {
        this.color = color;
        this.number = number;
    }

    @Override
    public boolean likesColor(String color) {
        return this.color.equals(color);
    }

    @Override
    public boolean likesNumber(int number) {
        return this.number == number;
    }

    public boolean canBePlayedOn(Card topCard) {
        return topCard.likesColor(this.color)|| topCard.likesNumber(this.number);
    }

    public void processCard(UnoGame game) {
        game.processCardAsNumber();
    }
}

