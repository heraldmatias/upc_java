/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplos;

/**
 *
 * @author alumno
 */
public class Ejemplos {

    public static void main(String[] args) {
        Padre ref = new Hijo();
        ref.unMetodo();
        ref = new Hijo();
        ref.unMetodo();
        ref.otroMetodo();
        ref = new Hermano();
        ref.unMetodo();
        ref.otroMetodo();
    }
}
