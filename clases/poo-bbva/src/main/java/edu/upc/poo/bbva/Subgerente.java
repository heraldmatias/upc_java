package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;
import static edu.upc.poo.bbva.enums.TipoOperacion.DEPOSITO;
import static edu.upc.poo.bbva.enums.TipoOperacion.RETIRO;

/**
 *
 * @author gian.corzo
 */
public class Subgerente extends Empleado{

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
                return monto>=1 && monto<=20000;
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
