/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entities.AbstractPlayer;
import entities.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/**
 *
 * Implementacion del juego tictactoe en consola
 * @author heraldo
 */
public class ConsoleGame extends Game {

    public ConsoleGame(Board board, AbstractPlayer player1, AbstractPlayer player2) {
        super(board, player1, player2);
    }

    @Override
    public void process() {
        while (!this.isFinished()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String xy = null;
            int x, y;
            if (this.player1.is_boot()) {
                this.procesar_movimiento();
                this.pause(1000);
            } else {
                //PEDIR INPUTS				
                do {
                    x = -1;
                    y = -1;
                    try {
                        System.out.print("Ingrese posición ej.(x,y): ");
                        xy = br.readLine();
                        x = Integer.parseInt(xy.substring(0, xy.indexOf(",")));
                        y = Integer.parseInt(xy.substring(xy.indexOf(",") + 1));
                        this.setCurrentPosition(new int[]{x, y});
                    } catch (IOException | NumberFormatException | StringIndexOutOfBoundsException e) {
                    }
                } while (!Pattern.matches("[0-9],[0-9]", xy) | !this.isValidMovement(x, y));
                this.procesar_movimiento();
            }
            if (player2.is_boot()) {
                this.procesar_movimiento();
                this.pause(1000);
            } else {
                //PEDIR INPUTS
                do {
                    x = -1;
                    y = -1;
                    try {
                        System.out.print("Ingrese posición ej.(x,y): ");
                        xy = br.readLine();
                        x = Integer.parseInt(xy.substring(0, xy.indexOf(",")));
                        y = Integer.parseInt(xy.substring(xy.indexOf(",") + 1));
                        this.setCurrentPosition(new int[]{x, y});
                    } catch (IOException | NumberFormatException | StringIndexOutOfBoundsException e) {
                    }
                } while (!Pattern.matches("[0-9],[0-9]", xy) | !this.isValidMovement(x, y));
                this.procesar_movimiento();
            }
        }
        if (this.getWinner() != null) {
            System.out.println(this.getWinner().getSymbol());
        } else {
            System.out.println("Draw game");
        }
    }
}
