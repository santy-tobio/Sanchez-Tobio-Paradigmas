package uno;

public abstract class GameStatus {
    public abstract GameStatus playPlayer1At(Game game, Card card);
    public abstract GameStatus playPlayer2At(Game game, Card card);
    public abstract boolean finished();
    public abstract GameStatus nextStatus();
}