package uno;

public abstract class Card {
    protected String color;
    protected int number;
    protected boolean uno = false;

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

    public void nextState(GameState currentState) {
        currentState.setNext(currentState.getRight());
    }

    public Card gritoUno() {
        this.uno = true;
        return this;
    }

    public abstract boolean canBePlayedOn(Card topCard);

    public abstract void action(UnoGame game, String player);
}



