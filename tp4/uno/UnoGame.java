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

        if (playersCards.get(player).size() == 2 && !card.uno) {
            drawCard(player);
            drawCard(player);
        }

        currentState.playCard(card, player);
        topCard = card;

        if(isGameOver()){
            throw new RuntimeException("Game is over");
        }

        playersCards.get(player).remove(card);
    }

    public Card getTopCard() {
        return topCard;
    }

    public void processCardAsDrawTwo(){
        this.currentState = this.currentState.getNext();
        drawCard(this.currentState.getPlayer());
        drawCard(this.currentState.getPlayer());
        this.currentState = this.currentState.getNext();
    }

    public void processCardAsNumber(){
        this.currentState = this.currentState.getNext();
    }

    public void processCardAsReverse(){
        this.currentState.SwitchLeftAndRight();
        this.currentState.setNext(this.currentState.getRight());
        this.currentState = this.currentState.getNext();
    }

    public void processCardAsSkip(){
        this.currentState = this.currentState.getNext().getNext();
    }

    public void processCardAsWild(){
        this.currentState = this.currentState.getNext();
    }

    public boolean isGameOver() {
        return playersCards.values().stream().anyMatch(List::isEmpty);
    }

    public void drawCard(String player) {
        Card card = deck.removeFirst();
        playersCards.get(player).add(card);
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
            currentState.setNext(nextState);
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

}