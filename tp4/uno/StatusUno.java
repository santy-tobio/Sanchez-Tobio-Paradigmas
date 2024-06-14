package uno;
import java.util.ArrayList;
import java.util.List;

public abstract class StatusUno {
    protected UnoGame currentGame;

    public StatusUno(UnoGame currentGame) {
        this.currentGame = currentGame;
    }

    public abstract void playPlayer1At(UnoGame game, Card card);
    public abstract void playPlayer2At(UnoGame game, Card card);
    public abstract boolean isValid();


    public boolean isPlayingPlayer1(){
        return false;
    }

    public boolean isPlayingPlayer2(){
        return false;
    }

    public boolean isGameFinished(){
        return false;
    }

    public StatusUno selectStatus (){
        ArrayList<StatusUno> states = new ArrayList<StatusUno>(List.of(
                new StatePlayer1Playing(currentGame), new StatePlayer2Playing(currentGame),
                new StateFinished(currentGame)));

        return states.stream().filter(state -> state.isValid()).findFirst().get();
    }
}