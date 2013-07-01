/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.AbstractPlayer;
import entities.BoardGraphic;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author heraldo
 */
public class GraphicGame extends Game {

    private boolean first_draw = false;

    public GraphicGame(BoardGraphic board, AbstractPlayer player1, AbstractPlayer player2) {
        super(board, player1, player2);
    }

    @Override
    public void start() {
        WindowGame app = new WindowGame();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void process() {
        if (this.getGameType() == GAME_BOT_VS_BOT) {
            while (!this.isFinished()) {
                if (this.player1.is_boot()) {
                    this.register_movement(player1);
                    this.pause(1000);
                }
                if (player2.is_boot()) {
                    this.register_movement(player2);
                    this.pause(1000);
                }
            }
        } else if (this.getGameType() == GAME_BOT_VS_HUMAN) {
            Point p = this.getCurrentPosition();
            if (p != null) {
                do_movements(p.x, p.y);
            }
            this.do_movements(0, 0);
        } else if (this.getGameType() == GAME_HUMAN_VS_BOT) {
            Point p = this.getCurrentPosition();
            if (p != null) {
                do_movements(p.x, p.y);
            }
            do_movements(0, 0);
        }else if (this.getGameType() ==  GAME_HUMAN_VS_HUMAN){
            Point p = this.getCurrentPosition();
            if (p != null) {
                do_movements(p.x, p.y);
            }
        }
    }

    public void do_movements(int x, int y) {
        boolean done;
        if (this.currentPlayer.is_boot()) {
            done = this.register_movement(this.currentPlayer);
        } else {
            done = this.register_movement(this.currentPlayer, x, y);
        }
        if (done) {
            if (this.currentPlayer.equals(player1)) {
                this.currentPlayer = player2;
            } else {
                this.currentPlayer = player1;
            }
        }
    }

    class WindowGame extends JFrame {

        public WindowGame() {
            super("Tic Tac Toe");
            this.addMouseListener(new MouseEvents());
            setSize(360, 400);
            setVisible(true);
            setResizable(false);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g); //To change body of generated methods, choose Tools | Templates.
            ((BoardGraphic) board).setGraphics(g);
            board.drawBoard();
            if (first_draw == false) {
                process();
                first_draw = true;
            }
        }

        class MouseEvents extends MouseAdapter {

            @Override
            public void mouseClicked(MouseEvent me) {
                Point p = ((BoardGraphic) board).getBoardPositionAtPoint(me.getPoint());
                if (p != null) {
                    setCurrentPosition(p);
                    process();
                    repaint();
                    if (isFinished()) {
                        if (getWinner() != null) {
                            JOptionPane.showMessageDialog(null,
                                    "El ganador es " + getWinner().getSymbol(), "Tres en raya",
                                    JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Hay un empate", "Tres en raya",
                                    JOptionPane.INFORMATION_MESSAGE);
                        }
                        restart();
                        repaint();
                    }
                }
            }
        }
    }
}
