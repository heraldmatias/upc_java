/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.ejer02;
import java.util.Random;
/**
 * Desarrollar una clase llamada Dado
 * que permita lanzar un dado que de forma aleatoria
 * me devolverá un número entre el 1 al 6.
 * El atributo principal será el valor actual
 * y un método generará el número aleatorio.
 * El sistema deberá mostrar el número resultado del dado. 
 * @author heraldo
 */
public class Dado {
    
    private int valor;
    private Random random = new Random();

    public int getValor() {
        return valor;
    }

    public void lanzar(){        
        this.valor = random.nextInt(6) + 1;
    }
    
    public static void main(String[] args) {
        Dado dado = new Dado();
        dado.lanzar();
        System.out.println(dado.getValor());
    }
    
}
