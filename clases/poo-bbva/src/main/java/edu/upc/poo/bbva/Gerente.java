package edu.upc.poo.bbva;

/**
 *
 * @author gian.corzo
 */
public class Gerente extends Empleado{
   
    @Override
    public boolean autorizar(Operacion operacion) {
        switch(operacion.getOperacion()){
            case APERTURA_CUENTA:{
                return true;
            }
            case CANCELACION_CUENTA:{
                return true;
            }
            default:{
                return false;
            }
        }
    }
    
}
