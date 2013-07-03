package ejemplos;

/**
 *
 * @author alumno
 */
public class Hermano extends Padre {
   

    @Override
    public void unMetodo() {        
        super.unMetodo();
        System.out.println("Clase Hermano - un metodo");
    }    

    @Override
    public void otroMetodo() {
        System.out.println("Clase hermano - metodo abstracto");
    }
}
