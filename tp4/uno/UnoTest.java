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

    @Test public void testPlayerWins(){
        UnoGame game = simpleGame();
        game.playCard(yellowThreeCard, "a");
        game.playCard(redThreeCard, "b");
        game.playCard(redFiveCard.gritoUno(), "a");
        game.playCard(blueFiveCard.gritoUno(), "b");
        assertThrowsLike(() -> game.playCard(blueSevenCard, "a"),
                "a has won!");
    }

    @Test public void testItsNotYourTurn(){
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.playCard(greenFiveCard, "b"),
                "It's not your turn");
    }

    @Test public void testDrawTwoCard(){
        UnoGame game = gameWithDrawTwoCard();
        game.playCard(redOneCard, "a");
        game.playCard(redFourCard, "b");
        game.playCard(redTwoCard.gritoUno(), "a");
        game.playCard(redDrawTwoCard.gritoUno(), "b");
        game.playCard(redThreeCard, "a");
        assertThrowsLike(() -> game.playCard(redFiveCard, "b"),
                "b has won!");
    }

    @Test public void testSkipCard(){
        UnoGame game = gameWithSkipCard();
        game.playCard(blueSkipCard, "a");
        game.playCard(blueFiveCard, "a");
        assertEquals(game.getTopCard(), blueFiveCard);
    }

    @Test public void testReverseCard(){
        UnoGame game = gameWithReverseCard();
        game.playCard(redOneCard, "a");
        game.playCard(redReverseCard, "b");
        game.playCard(redTwoCard, "a");
        game.playCard(redEightCard, "c");
    }


    private void assertThrowsLike(Executable executable, String msg) {
        assertEquals(
                assertThrows(Exception.class, executable)
                        .getMessage(), msg);
    }

    private Card redZeroCard = new CardNumber("red", 0);
    private Card redOneCard = new CardNumber("red", 1);
    private Card redTwoCard = new CardNumber("red", 2);
    private Card redThreeCard = new CardNumber("red", 3);
    private Card redFourCard = new CardNumber("red", 4);
    private Card redFiveCard = new CardNumber("red", 5);
    private Card redSixCard = new CardNumber("red", 6);
    private Card redSevenCard = new CardNumber("red", 7);
    private Card redEightCard = new CardNumber("red", 8);
    private Card redNineCard = new CardNumber("red", 9);
    private Card redSkipCard = new CardSkip("red");

    private Card redDrawTwoCard = new CardDrawTwo("red");
    private Card redReverseCard = new CardReverse("red");
    private Card blueFiveCard = new CardNumber("blue", 5);

    private Card blueSevenCard = new CardNumber("blue", 7);
    private Card blueReverseCard = new CardReverse("blue");
    private Card blueDrawTwoCard = new CardDrawTwo("blue");
    private Card blueSkipCard = new CardSkip("blue");
    private Card yellowFiveCard = new CardNumber("yellow", 5);

    private Card yellowThreeCard = new CardNumber("yellow", 3);
    private Card greenFiveCard = new CardNumber("green", 5);

    private Card wildCard = new CardWild();

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



    private UnoGame gameWithReverseCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redTwoCard,
                redThreeCard,
                redOneCard,
                redReverseCard,
                redFiveCard,
                redFourCard,
                redSixCard,
                redSevenCard,
                redEightCard,
                redNineCard
        ));
        List<String> players = Arrays.asList("a", "b", "c");
        return new UnoGame(deck, players, 3);
    }

    private UnoGame gameWithDrawTwoCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redOneCard,
                redTwoCard,
                redThreeCard,
                redFourCard,
                redFiveCard,
                redDrawTwoCard,
                redSixCard,
                redSevenCard,
                redEightCard,
                redNineCard,
                redZeroCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 3);
    }

    private UnoGame gameWithSkipCard(){
        //queremos testear funcionalidades de skip, reverse, draw two y wild
        List<Card> deck = new ArrayList<>(Arrays.asList(
               blueDrawTwoCard,
                blueSkipCard,
                blueFiveCard,
                wildCard,
                redSkipCard,
                redDrawTwoCard,
                blueSevenCard,
                greenFiveCard,
                yellowFiveCard
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