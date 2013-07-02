/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.ejerr;

/**
 *
 * @author heraldo
 */
public class CancionCerveza {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int numeroCervezas = 99;
        String palabra = "botellas";

        while (numeroCervezas > 0) {
            if (numeroCervezas == 1) {
                palabra = "botella"; //singular, nos queda una sola :O(
            }

            System.out.println(numeroCervezas + " " + palabra + " de cerveza en la caja");
            System.out.println(numeroCervezas + " " + palabra + " de cerveza");
            System.out.println("destapemos una");
            System.out.println("Pasemosla a todos");
            numeroCervezas = numeroCervezas - 1;

            if (numeroCervezas > 0) {
                System.out.println(numeroCervezas + " " + palabra
                        + "de cerveza en la caja");
            } else {
                System.out.println("No hay mas botellas de cerveza en la caja");
            }//fin del else
        } // fin del while

    } // fin del main
} // fin de la clase