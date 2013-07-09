package edu.upc.poo.bbva;

import static edu.upc.poo.bbva.enums.TipoOperacion.DEPOSITO;
import static edu.upc.poo.bbva.enums.TipoOperacion.RETIRO;

/**
 *
 * @author gian.corzo
 */
public class Subgerente extends Empleado{


    @Override
    public boolean autorizar(Operacion operacion) {
        switch(operacion.getOperacion()){
            case RETIRO:{
                return operacion.getMonto()>=1 && operacion.getMonto()<=20000;
            }
            case DEPOSITO:{
                return true;
            }
            default:{
                return false;
            }
        }
    }
    
}
