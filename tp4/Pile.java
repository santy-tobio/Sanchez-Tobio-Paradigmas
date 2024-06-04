

import java.util.List;

public class Pile {

    private List<Card> cards;

    public Pile(List<Card> cards) {
        this.cards = cards;
    }

    public void add(Card card) {
        cards.add(card);
    }

    public Card getTopCard() {
        return cards.getLast();
    }


}
