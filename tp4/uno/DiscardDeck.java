package uno;

import java.util.Stack;

public class DiscardDeck extends Deck {

    public DiscardDeck(int numCards, Stack<Card> cards) {
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
    }

}
