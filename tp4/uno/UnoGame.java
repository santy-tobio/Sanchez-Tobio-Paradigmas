package uno;

import java.util.*;

public class UnoGame {

    private Map<String, List<Card>> playersCards;
    private List<Card> deck;
    private Card topCard;
    private StatusUno gameStatus = new StatePlayer1Playing(this);

    public UnoGame(List<Card> deck, List<String> players, int initialHandSize) {
        this.deck = deck;
        this.playersCards = new HashMap<>();

        //metemos jugadores con sus manos en el hash map
        for (String player : players) {
            List<Card> hand = new ArrayList<>();
            for (int i = 0; i < initialHandSize; i++) {
                hand.add(deck.remove(0));
            }
            this.playersCards.put(player, hand);
        }

        this.topCard = deck.remove(0);
    }

    public void play(String player, Card card) {
        //juega alguien
    }

    public UnoGame playCard(Card card) {

        if (card.canBePlayedOn(this.topCard)) {
            this.topCard = card;
        } else {
            throw new RuntimeException("Card cannot be played on the current top card");
        }
        return this;
    }

    public void playPlayer1At(Card card) {
        gameStatus.playPlayer1At(this, card);
    }

    public void playPlayer2At(Card card) {
        gameStatus.playPlayer2At(this, card);
    }


    public Card getTopCard() {
        return topCard;
    }

    public StatusUno getGameStatus() {
        return gameStatus;
    }

    public boolean checkWin() {
        return playersCards.values().stream().anyMatch(List::isEmpty);
    }

    public boolean isPlayingPlayer1() {
        return gameStatus.isPlayingPlayer1();
    }

    public boolean isPlayingPlayer2() {
        return gameStatus.isPlayingPlayer2();
    }

    public boolean isGameFinished() {
        return gameStatus.isGameFinished();
    }

    public void modifyState (StatusUno newState){
        this.gameStatus = newState;
    }
}