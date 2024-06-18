package uno;

public abstract class Card {

    protected boolean uno = false;

    public abstract boolean likesColor(String color);

    public abstract boolean likesNumber(int number);

    public abstract boolean canBePlayedOn(Card topCard);

    public abstract void processCard(UnoGame game);

    public Card chooseColor(String color) {
        return this;
    }

    public boolean canGetOnTopOfSkipCard() {
        return false;
    }

    public boolean canGetOnTopOfReverseCard() {
        return false;
    }

    public boolean canGetOnTopOfDrawTwoCard() {
        return false;
    }

    public Card gritoUno() {
        this.uno = true;
        return this;
    }

}

