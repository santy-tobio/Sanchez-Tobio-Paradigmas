package uno;

public class GameState {

    private UnoGame game;
    private String player;
    private GameState right;
    private GameState left;
    private GameState next;

    public GameState(UnoGame game, String player) {
        this.game = game;
        this.player = player;
        this.right = this;
        this.left = this;
        this.next = this.right;
    }

    public void setRight(GameState right) {
        this.right = right;
    }

    public void setLeft(GameState left) {
        this.left = left;
    }

    public void setNext(GameState next) {
        this.next = next;
    }

    public GameState getRight() {
        return right;
    }

    public GameState getLeft() {
        return left;
    }

    public GameState getNext() {
        return next;
    }

    public void playCard(Card card, String player) {
        if (!this.player.equals(player)) {
            throw new RuntimeException("It's not your turn");
        }
        card.nextState(this);
    }
}