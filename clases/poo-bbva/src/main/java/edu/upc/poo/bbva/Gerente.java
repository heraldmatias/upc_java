package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 *
 * @author gian.corzo
 */
public class Gerente extends Empleado{
   

    @Override
    public boolean autorizar(TipoOperacion tipo) {
        switch(tipo){
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
