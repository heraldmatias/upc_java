package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;
import static edu.upc.poo.bbva.enums.TipoOperacion.DEPOSITO;
import static edu.upc.poo.bbva.enums.TipoOperacion.RETIRO;

/**
 *
 * @author gian.corzo
 */
public class Gerente extends Empleado{
   

    @Override
    public boolean autorizar(TipoOperacion tipo, Cliente cliente) {
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

    @Override
    public boolean autorizar(TipoOperacion tipo, Cliente cliente, double monto) {
        switch(tipo){
            case RETIRO:{
                return true;
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
