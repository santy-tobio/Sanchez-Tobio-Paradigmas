package uno;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UnoGame {

    private Map<String, List<Card>> playersCards;
    private List<Card> deck;
    private Card topCard;
    private GameState currentState;


    public UnoGame(List<Card> deck, List<String> players, int initialHandSize) {
        this.deck = deck;
        dealCards(players, initialHandSize);
        if (deck.isEmpty()) {
            throw new IllegalArgumentException("Not enough cards in the deck to start the game");
        }
        this.topCard = deck.removeFirst();
        createCircularStates(players);
    }

    public void playCard(Card card, String player) {
        if (!playersCards.get(player).contains(card)) {
            throw new RuntimeException("Player does not have this card");
        }
        if (!card.canBePlayedOn(topCard)) {
            throw new RuntimeException("Card cannot be played on top card");
        }

        playersCards.get(player).remove(card);

        if (playersCards.get(player).size() == 1 && !card.uno) {
            drawCard(player);
            drawCard(player);
        }

        currentState.playCard(card, player);
        card.action(this, currentState.getNext().getPlayer());
        topCard = card;


        if (playersCards.get(player).isEmpty()) {
            throw new RuntimeException(player + " has won!");
        }
    }

    public Card getTopCard() {
        return topCard;
    }

    private void createCircularStates(List<String> players) {
        List<GameState> states = players.stream()
                .map(player -> new GameState(this, player))
                .collect(Collectors.toList());

        IntStream.range(0, states.size()).forEach(i -> {
            GameState currentState = states.get(i);
            GameState nextState = states.get((i + 1) % states.size());
            GameState prevState = states.get((i - 1 + states.size()) % states.size());
            currentState.setRight(nextState);
            currentState.setLeft(prevState);
        });

        this.currentState = states.get(0);
    }

    private void dealCards(List<String> players, int initialHandSize) {
        if (deck.size() < players.size() * initialHandSize) {
            throw new IllegalArgumentException("Not enough cards in the deck to deal initial hands");
        }

        this.playersCards = players.stream().collect(Collectors.toMap(
                player -> player,
                player -> IntStream.range(0, initialHandSize)
                        .mapToObj(i -> deck.remove(0))
                        .collect(Collectors.toList())
        ));
    }

    public GameState getCurrentState() {
        return currentState;
    }

    //set gamestate
    public void setCurrentState(GameState currentState) {
        this.currentState = currentState;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public void drawCard(String player) {
        Card card = deck.removeFirst();
        playersCards.get(player).add(card);
    }

}