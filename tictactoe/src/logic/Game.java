package logic;

import entities.AbstractBoard;
import entities.AbstractPlayer;
import entities.Symbol;
/*
 * Implementacion del juego tictactoe
 */
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
    private int[] currentPosition;
    
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

    public void procesar_movimiento() {
        Symbol move;
        if (this.currentPlayer.is_boot()) {
            move = this.currentPlayer.do_movement();
            if (!this.board.isFinished()) {
                while (!this.board.isValidMovement(move.getX(), move.getY())) {
                    move = this.currentPlayer.do_movement();
                }
                boolean done = this.board.make_movement(move);
                if (done) {
                    if (this.currentPlayer.equals(player1)) {
                        this.currentPlayer = player2;
                    } else {
                        this.currentPlayer = player1;
                    }
                    this.board.drawBoard();
                }
            }
        } else {
            int[] p = this.getCurrentPosition();
            AbstractPlayer _player;
            if (p != null) {
                boolean done = this.board.make_movement(this.currentPlayer.do_movement(p[0], p[1]));
                if (done) {
                    if (this.currentPlayer.equals(player1)) {
                        _player = player2;
                    } else {
                        _player = player1;
                    }
                    if (_player.is_boot()) {
                        move = _player.do_movement();
                        if (!this.board.isFinished()) {
                            while (!this.board.isValidMovement(move.getX(), move.getY())) {
                                move = _player.do_movement();
                            }
                            this.board.make_movement(move);
                        }
                    }else{
                        this.currentPlayer=_player;
                    }
                    this.board.drawBoard();
                }
            }
        }
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

    public int[] getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int[] currentPosition) {
        this.currentPosition = currentPosition;
    }

    public abstract void process();
}
