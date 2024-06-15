package uno;

import org.junit.jupiter.api.Test;
import java.util.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UnoTest {

    @Test public void testGameInitialization() {
        UnoGame game = simpleGame();
        assertEquals(game.getTopCard(), yellowFiveCard);
    }

    @Test public void testNotEnoughCardsInDeckToStart(){
        List<String> players = Arrays.asList("a", "b");
        assertThrowsLike(() -> new UnoGame(shortDeck, players, 3),
                "Not enough cards in the deck to deal initial hands");
    }

    @Test public void testPlayCardItsValidBecauseItsColor() {
        UnoGame game = simpleGame();
        game.playCard(yellowThreeCard, "a");
        assertEquals(game.getTopCard(), yellowThreeCard);
    }

    @Test public void testPlayCardItsValidBecauseItsNumber() {
        UnoGame game = simpleGame();
        game.playCard(redFiveCard, "a");
        assertEquals(game.getTopCard(), redFiveCard);
    }

    @Test public void testPlayCardItsInvalid() {
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.playCard(blueSevenCard, "a"),
                "Card cannot be played on top card");
    }

    @Test public void testPlayerDoesNotHaveCard() {
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.playCard(redThreeCard, "a"),
                "Player does not have this card");
    }

    @Test public void testTwoPlayersPlay(){
        UnoGame game = simpleGame();
        game.playCard(yellowThreeCard, "a");
        game.playCard(redThreeCard, "b");
        assertEquals(game.getTopCard(), redThreeCard);
    }

    @Test public void testItsNotYourTurn(){
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.playCard(greenFiveCard, "b"),
                "It's not your turn");
    }




    private void assertThrowsLike(Executable executable, String msg) {
        assertEquals(
                assertThrows(Exception.class, executable)
                        .getMessage(), msg);
    }

    private Card redFiveCard = new CardNumber("red", 5);
    private Card greenFiveCard = new CardNumber("green", 5);
    private Card blueFiveCard = new CardNumber("blue", 5);
    private Card blueSevenCard = new CardNumber("blue", 7);
    private Card redThreeCard = new CardNumber("red", 3);
    private Card yellowFiveCard = new CardNumber("yellow", 5);
    private Card yellowThreeCard = new CardNumber("yellow", 3);
    private Card wildCard = new CardWild();
    private Card redSkipCard = new CardSkip("red");
    private Card blueSkipCard = new CardSkip("blue");
    private Card redDrawTwoCard = new CardDrawTwo("red");
    private Card blueDrawTwoCard = new CardDrawTwo("blue");
    private Card redReverseCard = new CardReverse("red");
    private Card blueReverseCard = new CardReverse("blue");

    private UnoGame simpleGame() {
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redFiveCard,
                yellowThreeCard,
                blueSevenCard,
                redThreeCard,
                greenFiveCard,
                blueFiveCard,
                yellowFiveCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 3);
    }

    private UnoGame ComplexGame(){
        //queremos testear funcionalidades de skip, reverse, draw two y wild
        List<Card> deck = new ArrayList<>(Arrays.asList(
               blueDrawTwoCard,
                redReverseCard,
                redFiveCard,
                wildCard,
                blueSkipCard,
                blueDrawTwoCard,
                blueSevenCard,
                greenFiveCard,
                blueFiveCard,
                yellowFiveCard,
                redThreeCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 3);
    }

    private List<Card> shortDeck = new ArrayList<>(Arrays.asList(
            redFiveCard,
            yellowThreeCard,
            blueSevenCard
    ));
}