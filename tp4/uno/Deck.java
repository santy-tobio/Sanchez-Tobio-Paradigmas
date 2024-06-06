package uno;

import java.util.Stack;

public abstract class Deck {

    private Stack<Card> cards;

    public Deck(Stack<Card> cards) {
        this.cards = cards;
    }

    public abstract void addCard(Card card);

    public abstract Card getTopCard();

    public abstract void removeCard(Card card);

    public Stack<Card> getCards() {
        return cards;
    }


//    private Stack<Card> cards;
//
//    public Deck(Stack<Card> cards) {
//        this.cards = cards;
//    }
//
//    public Deck createDeck() {
//        return new Deck(cards);
//    }
//
//    public Card getTopCard() {
//        return cards.pop();
//    }

}
