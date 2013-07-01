package app;

import logic.Game;
import logic.ConsoleGame;
import logic.GraphicGame;
import entities.*;

public class TicTacToe {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TicTacToe.initGraphicGame();
    }
    
    public static void initGraphicGame(){
        BoardGraphic board = new BoardGraphic();
        AbstractPlayer player1 = new PlayerBot( new Symbol('X') );
        AbstractPlayer player2 = new Player( new Symbol('O') );
        Game tictactoe = new GraphicGame(board, player1, player2);
        tictactoe.start();
    }
    
    public static void initConsoleGame(){        
        Board board = new Board();
        AbstractPlayer player1 = new Player( new Symbol('X') );
        AbstractPlayer player2 = new PlayerBot( new Symbol('O') );
        Game tictactoe = new ConsoleGame(board, player1, player2);
        tictactoe.start();
    }
}
