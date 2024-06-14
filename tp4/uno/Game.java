package uno;

import java.util.*;

public class Game {
    private Map<String, List<Card>> playersCards;
    private List<Card> deck;
    private Card topCard;
    private GameStatus gameStatus = new StatePlayer1Playing();

    public Game(List<Card> deck, List<String> players, int initialHandSize) {
        this.deck = deck;
        this.playersCards = new HashMap<>();

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
        if (player.equals("a")) {
            this.gameStatus = this.gameStatus.playPlayer1At(this, card);
        } else if (player.equals("b")) {
            this.gameStatus = this.gameStatus.playPlayer2At(this, card);
        } else {
            throw new RuntimeException("Invalid player");
        }
    }

    public Game playCard(Card card) {
        if (card.canBePlayedOn(this.topCard)) {
            this.topCard = card;
            if (card instanceof CardReverse) {
                //reverse the order of play
                this.gameStatus = this.gameStatus.nextStatus();
            } else if (card instanceof CardSkip) {
                //skip the next player
                this.gameStatus = this.gameStatus.nextStatus().nextStatus();
            }

            //remove card from player's hand
            for (List<Card> hand : playersCards.values()) {
                if (hand.remove(card)) {
                    break;
                }
            }
            return this;
        } else {
            throw new RuntimeException("Card cannot be played on the current top card");
        }
    }

    public boolean checkWin() {
        for (List<Card> hand : playersCards.values()) {
            if (hand.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public Card getTopCard() {
        return topCard;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }
}