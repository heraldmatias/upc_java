package logic;

import entities.AbstractBoard;
import entities.AbstractPlayer;
import entities.Symbol;
import java.awt.Point;

public abstract class Game {

    public final static int GAME_BOT_VS_BOT = 1;
    public final static int GAME_BOT_VS_HUMAN = 2;
    public final static int GAME_HUMAN_VS_BOT = 3;
    public final static int GAME_HUMAN_VS_HUMAN = 4;
    private int gameType;
    protected AbstractBoard board;
    protected AbstractPlayer player1;
    protected AbstractPlayer player2;
    protected AbstractPlayer currentPlayer;
    private Point currentPosition;

    public Game(AbstractBoard board, AbstractPlayer player1, AbstractPlayer player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
        this.board.setUsableSymbols(new char[]{player1.getSymbol(), player2.getSymbol()});
        this.currentPlayer = player1;
        if (player1.is_boot() && player2.is_boot()) {
            this.gameType = GAME_BOT_VS_BOT;
        } else if (player1.is_boot() && !player2.is_boot()) {
            this.gameType = GAME_BOT_VS_HUMAN;
        } else if (!player1.is_boot() && player2.is_boot()) {
            this.gameType = GAME_HUMAN_VS_BOT;
        } else {
            this.gameType = GAME_HUMAN_VS_HUMAN;
        }
    }

    public void start() {
        this.board.drawBoard();
        this.process();
    }

    public void restart() {
        this.board.restart();
        this.board.drawBoard();
        this.currentPosition = null;
        this.currentPlayer = player1;
        this.process();
    }

    public int getGameType() {
        return gameType;
    }

    public void pause(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
        }
    }

    public boolean isFinished() {
        return this.board.isFinished();
    }

    public boolean register_movement(AbstractPlayer player, int x, int y) {
        boolean done = this.board.make_movement(player.do_movement(x, y));
        if (done) {
            this.board.drawBoard();
            this.currentPlayer = player;
        }
        return done;
    }

    public boolean register_movement(AbstractPlayer player) {
        if (player.is_boot()) {
            Symbol move = player.do_movement();
            if (!this.board.isFinished()) {
                while (!this.board.isValidMovement(move.getX(), move.getY())) {
                    move = player.do_movement();
                }
                return register_movement(player, move.getX(), move.getY());
            }
        }
        return false;
    }

    public AbstractPlayer getWinner() {
        if (this.board.getWinner() != null) {
            if (this.board.getWinner() == this.player1.getSymbol()) {
                return this.player1;
            }
            if (this.board.getWinner() == this.player2.getSymbol()) {
                return this.player2;
            }
        }
        return null;
    }

    public boolean isValidMovement(int x, int y) {
        return this.board.isValidMovement(x, y);
    }

    public Point getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(Point currentPosition) {
        this.currentPosition = currentPosition;
    }

    public abstract void process();
}
