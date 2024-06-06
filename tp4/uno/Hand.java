package uno;

import java.util.Stack;

public class Hand extends Deck {

    private int numCards = 7;

    public Hand(int numCards, Stack<Card> cards) {
        super(cards);
    }

    @Override
    public void addCard(Card card) {
        getCards().push(card);
    }

    @Override
    public Card getTopCard() {
        return getCards().peek();
    }

    @Override
    public void removeCard(Card card) {
        setNumCards(getNumCards() - 1);
    }

    public int getNumCards() {
        return numCards;
    }

    public void setNumCards(int numCards) {
        this.numCards = numCards;
    }

}
