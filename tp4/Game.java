public class Game {

    private Deck deck;
    private Pile pile;

    public Game() {
        deck = new Deck();
        pile = new Pile(deck.getCards());
    }

    public void start() {
        deck.shuffle();
        pile.add(deck.draw());
    }



}
