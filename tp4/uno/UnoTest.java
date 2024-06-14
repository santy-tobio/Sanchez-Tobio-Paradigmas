package uno;

import org.junit.jupiter.api.Test;
import java.util.*;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class UnoTest {
    @Test
    public void testPlayer1PlaysValidCard() {
        UnoGame game = simpleGame();
        game.play("a", redFiveCard);
        assertEquals(game.getTopCard(), redFiveCard);
    }

    @Test
    public void testPlayer1PlaysInvalidCard() {
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.play("a", blueSevenCard), "Card cannot be played on the current top card");
    }

    @Test
    public void testPlayer2PlaysOnPlayer1Turn() {
        UnoGame game = simpleGame();
        assertThrowsLike(() -> game.play("b", blueSevenCard), "It is not player 2's turn");
    }

    @Test
    public void testPlayer2PlaysValidCard() {
        UnoGame game = simpleGame();
        game.play("a", redFiveCard);
        game.play("b", blueFiveCard);
        assertEquals(game.getTopCard(), blueFiveCard);
    }

    @Test
    public void testPlayer1Wins() {
        UnoGame game = simpleGame();
        game.play("a", redFiveCard);
        game.play("b", blueFiveCard);
        game.play("a", blueSevenCard);
        assertTrue(game.getGameStatus().finished());
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

    private UnoGame simpleGame() {
        List<Card> deck = new ArrayList<>(Arrays.asList(
                redFiveCard,
                blueSevenCard,
                redThreeCard,
                greenFiveCard,
                yellowFiveCard
        ));
        List<String> players = Arrays.asList("a", "b");
        return new UnoGame(deck, players, 2);
    }
}