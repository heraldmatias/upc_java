/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

/**
 *
 * Implementacion de un tablero grafico
 * @author heraldo
 */
public class BoardGraphic extends AbstractBoard {

    public static final float INITIAL_X_POS = 30;
    public static final float INITIAL_Y_POS = 50;
    public static final int AREA = 100;
    private Graphics graphics;    

    @Override
    protected boolean is_graphic() {
        return true;
    }

    public Point getBoardPositionAtPoint(Point point) {
        float x1 = INITIAL_X_POS;
        float y1;
        float x2 = x1 + AREA;
        float y2;
        for (int x = 1; x <= MAX_COLS; x++) {
            y1 = INITIAL_Y_POS;
            y2 = y1 + AREA;
            for (int y = 1; y <= MAX_ROWS; y++) {
                if ((point.getX() >= x1 & point.getX() <= x2) && (point.getY() >= y1 & point.getY() <= y2)) {
                    return new Point(x, y);
                }
                y1 = y2;
                y2 = y1 + AREA;
            }
            x1 = x2;
            x2 = x1 + AREA;
        }
        return null;
    }

    @Override
    protected void basedrawBoard(Symbol[][] slots) {
        if (this.getGraphics() != null) {
            Graphics2D g2d = (Graphics2D) this.getGraphics();
            g2d.setPaint(Color.RED);
            float xpos = INITIAL_X_POS;
            float ypos = INITIAL_Y_POS;
            double height = AREA * MAX_COLS + INITIAL_Y_POS;
            /**
             * ************DIBUJA EL TABLERO**************
             */
            for (int x = 0; x <= MAX_COLS; x++) {
                g2d.draw(new Line2D.Double(xpos, INITIAL_Y_POS, xpos, height));
                xpos += AREA;
            }
            for (int y = 0; y <= MAX_ROWS; y++) {
                g2d.draw(new Line2D.Double(INITIAL_X_POS, ypos, xpos - AREA, ypos));
                ypos += AREA;
            }
            /**
             * ********************************************
             */
            /**
             * ************DIBUJA LOS SIMBOLOS EN EL TABLERO**************
             */
            g2d.setFont(new Font("arial", Font.BOLD, AREA));
            xpos = (float) (INITIAL_X_POS * 1.5);
            ypos = (float) (INITIAL_Y_POS * 2.7);
            for (int x = 0; x < MAX_COLS; x++) {
                for (int y = 0; y < MAX_ROWS; y++) {
                    Symbol symbol = slots[x][y];
                    g2d.drawString((symbol == null) ? " " : symbol.getSymbol().toString(), xpos, ypos);
                    ypos += AREA;
                }
                xpos += AREA;
                ypos = (float) (INITIAL_Y_POS * 2.7);
            }
        }
    }

    public Graphics getGraphics() {
        return this.graphics;
    }

    public void setGraphics(Graphics graphics) {
        if (graphics != null) {
            this.graphics = graphics;
        }
    }
}
