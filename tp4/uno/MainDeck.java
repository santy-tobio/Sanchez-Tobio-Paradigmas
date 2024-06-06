package uno;

import java.util.Stack;

public class MainDeck extends Deck {

    public MainDeck(int numCards, Stack<Card> cards) {
        super(cards);
    }

    @Override
    public void addCard(Card card) {}

    @Override
    public Card getTopCard() {
        return getCards().pop();
    }

    @Override
    public void removeCard(Card card){}


}
