package uno;

public class GameState {

    private UnoGame game;
    private String player;
    private GameState right;
    private GameState previous;
    private GameState next;

    public GameState(UnoGame game, String player) {
        this.game = game;
        this.player = player;
        this.previous = this;
        this.next = this;
    }

    public void setPrevious(GameState previous) {
        this.previous = previous;
    }

    public void setNext(GameState next) {
        this.next = next;
    }

    public GameState getNext() {
        return next;
    }

    public String getPlayer() {
        return player;
    }

    public GameState getPrevious() {
        return previous;
    }

    public GameState SwitchNextAndPrevious() {
        GameState temp = this.previous;
        this.previous = this.next;
        this.next = temp;
        return this;
    }

    public void playCard(Card card, String player) {
        if (!this.player.equals(player)) {
            throw new RuntimeException("It's not your turn");
        }
        card.processCard(game);
    }
}