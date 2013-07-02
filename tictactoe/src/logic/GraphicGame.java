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
                procesar_movimiento();
                this.pause(1000);
            }
        } else if (this.getGameType() == GAME_BOT_VS_HUMAN) {
            procesar_movimiento();
        } else if (this.getGameType() == GAME_HUMAN_VS_BOT) {
            procesar_movimiento();
        } else if (this.getGameType() == GAME_HUMAN_VS_HUMAN) {
            procesar_movimiento();
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
                    setCurrentPosition(new int[]{p.x, p.y});
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
