package uno;

import org.junit.jupiter.api.Test;
import java.util.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UnoTest {
    private UnoGame game;
    private Card RedOn(int n){ return new CardNumber("red", n); }
    private Card BlueOn(int n){ return new CardNumber("blue", n); }
    private Card RedSkip(){ return new CardSkip("red"); }
    private Card BlueSkip(){ return new CardSkip("blue"); }
    private Card RedDrawTwo(){ return new CardDrawTwo("red"); }
    private Card BlueDrawTwo(){ return new CardDrawTwo("blue"); }
    private Card RedReverse(){ return new CardReverse("red"); }
    private Card BlueReverse(){ return new CardReverse("blue"); }
    private Card Wild(){ return new CardWild(); }

    private Card redZeroCard = RedOn(0);
    private Card redOneCard = RedOn(1);
    private Card redTwoCard = RedOn(2);
    private Card redThreeCard = RedOn(3);
    private Card redFourCard = RedOn(4);
    private Card redFiveCard = RedOn(5);
    private Card redSixCard = RedOn(6);
    private Card redSevenCard = RedOn(7);
    private Card redEightCard = RedOn(8);
    private Card redSkipCard = RedSkip();
    private Card redDrawTwoCard = RedDrawTwo();
    private Card redReverseCard = RedReverse();

    private Card blueZeroCard = BlueOn(0);
    private Card blueOneCard = BlueOn(1);
    private Card blueTwoCard = BlueOn(2);
    private Card blueThreeCard = BlueOn(3);
    private Card blueFourCard = BlueOn(4);
    private Card blueFiveCard = BlueOn(5);
    private Card blueSixCard = BlueOn(6);
    private Card blueSevenCard = BlueOn(7);
    private Card blueEightCard = BlueOn(8);
    private Card blueNineCard = BlueOn(9);
    private Card blueSkipCard = BlueSkip();
    private Card blueDrawTwoCard = BlueDrawTwo();
    private Card blueReverseCard = BlueReverse();

    private Card wildCard = Wild();

    @Test public void testGameInitialization() {assertEquals(simpleGame().getTopCard(), redZeroCard);}


    @Test public void testNotEnoughCardsInDeckToStart(){
        assertThrowsLike(() -> new UnoGame(shortDeck, Arrays.asList("a", "b"), 3),
                "Not enough cards in the deck to deal initial hands");
    }

    @Test public void testPlayCardItsInvalid() {
        assertThrowsLike(() -> simpleGame().playCard(blueFourCard, "a"),
                "Card cannot be played on top card");
    }

    @Test public void testPlayerDoesNotHaveCard() {
        assertThrowsLike(() -> simpleGame().playCard(redTwoCard, "a"),
                "Player does not have this card");
    }

    @Test public void testItsNotYourTurn(){
        UnoGame game = simpleGame();
        game.playCard(blueZeroCard, "a");
        assertThrowsLike(() -> game.playCard(blueFourCard, "a"),
                "It's not your turn");
    }

    @Test public void testPlayCardItsValidBecauseItsColor() {
        UnoGame game = simpleGame();
        game.playCard(redOneCard, "a");
        assertEquals(game.getTopCard(), redOneCard);
    }

    @Test public void testPlayCardItsValidBecauseItsNumber() {
        UnoGame game = simpleGame();
        game.playCard(blueZeroCard, "a");
        assertEquals(game.getTopCard(), blueZeroCard);
    }

    @Test public void testTwoPlayersPlay(){
        UnoGame game = simpleGame();
        game.playCard(blueZeroCard, "a");
        game.playCard(blueOneCard, "b");
        assertEquals(game.getTopCard(), blueOneCard);
    }

    @Test public void testPlayerWins(){
        UnoGame game = simpleGame();
        game.playCard(redOneCard, "a");
        game.playCard(blueOneCard, "b");
        game.playCard(blueZeroCard.gritoUno(), "a");
        game.playCard(blueThreeCard.gritoUno(), "b");
        game.playCard( blueFourCard, "a");
        assertTrue(game.isGameOver());
    }

    @Test public void InvalidPlayAfterGameIsOver(){
        UnoGame game = simpleGame();
        game.playCard(redOneCard, "a");
        game.playCard(blueOneCard, "b");
        game.playCard(blueZeroCard.gritoUno(), "a");
        game.playCard(blueThreeCard.gritoUno(), "b");
        game.playCard( blueFourCard, "a");
        assertThrowsLike(() -> game.playCard(blueFiveCard, "b"),
                "Game is over");
    }

    @Test public void PlayerDoesNotSayUno() {
        UnoGame game = simpleGame();
        game.playCard(redOneCard, "a");
        game.playCard(blueOneCard, "b");
        game.playCard(blueZeroCard, "a");
        game.playCard(blueThreeCard.gritoUno(), "b");
        game.playCard( blueFourCard, "a");
        assertFalse(game.isGameOver());

    }

    @Test public void TestWildCard(){
        UnoGame game = GameWithWildCard();
        assertEquals(game.getTopCard(), blueFiveCard);
        game.playCard(wildCard.gritoUno().chooseColor("red"), "a");
        game.playCard(redFourCard.gritoUno(), "b");
        assertEquals(game.getTopCard(), redFourCard);
    }

    @Test public void NothingHappendsWhenACardThatIsntWildChooseColor(){
        UnoGame game = simpleGame();
        game.playCard(redOneCard.chooseColor("blue"), "a");
        assertThrowsLike(() -> game.playCard(blueThreeCard, "b"),
                "Card cannot be played on top card");
    }

    @Test public void testSkipCard(){
        UnoGame game = GameWithSkipCard();
        game.playCard(redSkipCard.gritoUno(), "a");
        assertThrowsLike(() -> game.playCard(redTwoCard.gritoUno(), "b"),
                "It's not your turn");
    }

    @Test public void SkipCardCanGetOnTopOfSkipCard(){
        UnoGame game = GameWithSkipCard();
        game.playCard(redSkipCard.gritoUno(), "a");
        game.playCard(blueSkipCard.gritoUno(), "c");
        assertEquals(game.getTopCard(), blueSkipCard);
    }

    @Test public void testDrawTwoCardSkipsPlayer(){
        UnoGame game = GameWithDrawTwoCard();
        game.playCard(redOneCard.gritoUno(), "a");
        game.playCard(redDrawTwoCard, "b");
        assertThrowsLike(() -> game.playCard(redTwoCard, "a"),
                "It's not your turn");
    }

    @Test public void testDrawTwoCardDrawsTwoCards(){
        UnoGame game = GameWithDrawTwoCard();
        game.playCard(redOneCard.gritoUno(), "a");
        game.playCard(redDrawTwoCard, "b");
        game.playCard(redThreeCard, "b");
        game.playCard(redTwoCard, "a");
        game.playCard(redFiveCard.gritoUno(), "b");
        game.playCard(redSevenCard.gritoUno(), "a");
        game.playCard(redSixCard, "b");
        assertTrue(game.isGameOver());
    }

    @Test public void DrawCardCanGetOnTopOfDrawCard() {
        UnoGame game = GameWIthTwoDrawTwoCards();
        game.playCard(redDrawTwoCard.gritoUno(), "a");
        game.playCard(blueDrawTwoCard.gritoUno(), "c");
        assertEquals(game.getTopCard(), blueDrawTwoCard);
    }

    @Test public void ReverseCardSwitchesGameDirectionThreePlayers(){
        UnoGame game = GameWithReverseCard();
        game.playCard(redReverseCard.gritoUno(), "a");
        game.playCard(redFourCard.gritoUno(), "c");
        game.playCard(redThreeCard.gritoUno(), "b");
        assertEquals(game.getTopCard(), redThreeCard);
    }

    @Test public void ReverseCardCanGetOnReverseCard() {
        UnoGame game = GameWithReverseCard();
        game.playCard(redReverseCard.gritoUno(), "a");
        game.playCard(blueReverseCard.gritoUno(), "c");
        assertEquals(game.getTopCard(), blueReverseCard);
    }

    @Test public void ReverseCardReversedEqualsSameDirection(){
        UnoGame game = GameWithReverseCard();
        game.playCard(redReverseCard.gritoUno(), "a");
        game.playCard(blueReverseCard.gritoUno(), "c");
        game.playCard(blueFiveCard, "a");
        assertTrue(game.isGameOver());
    }

    private UnoGame simpleGame() {
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redOneCard,
                blueZeroCard,
                blueFourCard,
                blueOneCard,
                blueThreeCard,
                blueFiveCard,
                redZeroCard,
                blueTwoCard,
                blueSixCard,
                blueSevenCard,
                blueEightCard,
                blueNineCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 3);
    }

    private UnoGame GameWithWildCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                wildCard,
                redTwoCard,
                redThreeCard,
                redFourCard,
                blueFiveCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 2);

    }

    private UnoGame GameWithSkipCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redSkipCard,
                redOneCard,
                redTwoCard,
                blueOneCard,
                redFourCard,
                blueSkipCard,
                redFiveCard
        ));
        List<String> players = Arrays.asList("a", "b", "c");
        return new UnoGame(deck, players, 2);
    }

    private UnoGame GameWithDrawTwoCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redOneCard,
                redTwoCard,
                redDrawTwoCard,
                redThreeCard,
                redFourCard,
                redFiveCard,
                redSixCard,
                redSevenCard,
                redEightCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 2);
    }

    private UnoGame GameWithReverseCard(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redReverseCard,
                blueFiveCard,
                blueReverseCard,
                redThreeCard,
                redFourCard,
                blueReverseCard,
                redFiveCard
        ));
        List<String> players = Arrays.asList("a", "b", "c");
        return new UnoGame(deck, players, 2);
    }

    private List<Card> shortDeck = new ArrayList<>(Arrays.asList(
            redFiveCard,
            redOneCard,
            blueSevenCard
    ));

    private UnoGame GameWIthTwoDrawTwoCards(){
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redDrawTwoCard,
                redZeroCard,
                redOneCard,
                redTwoCard,
                blueDrawTwoCard,
                redThreeCard,
                redFourCard,
                redFiveCard,
                redSixCard,
                redSevenCard,
                redEightCard
        ));
        List<String> players = Arrays.asList("a", "b", "c");
        return new UnoGame(deck, players, 2);
    }

    private void assertThrowsLike(Executable executable, String msg) {
        assertEquals(
                assertThrows(Exception.class, executable)
                        .getMessage(), msg);
    }



}