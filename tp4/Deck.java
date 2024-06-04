import java.util.List;

public class Deck{

    int size = 108;
    private List<Card> cards;
    private Card topCard;

    public Card draw(){
        return cards.removeFirst();
    }

    public List<Card> getCards() {
        return cards;
    }


    public void shuffle() {
    }
}
