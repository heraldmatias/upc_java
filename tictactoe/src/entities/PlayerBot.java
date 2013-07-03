package entities;
/*
 * Implementacion de un jugador automatico
 */
import java.util.Random;

public class PlayerBot extends AbstractPlayer {

    public PlayerBot(Symbol symbol) {
        super(symbol);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean is_boot() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public Symbol do_movement() {
        // TODO Auto-generated method stub
        Random random = new Random();
        int x = random.nextInt(AbstractBoard.MAX_COLS) + 1;
        int y = random.nextInt(AbstractBoard.MAX_ROWS) + 1;
        return super.do_movement(x, y);
    }
}
