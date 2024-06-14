package uno;

public abstract class Card {
    protected String color;
    protected int number;

    public Card(String color, int number) {
        this.color = color;
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public abstract boolean canBePlayedOn(Card topCard);
}



