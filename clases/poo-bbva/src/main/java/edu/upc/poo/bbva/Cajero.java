package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 * El cajero de encarga de realizar deposito, retirar dinero y realizar algunas
 * operaciones simples
 * 
 * @author gian.corzo
 */
public class Cajero extends Empleado{

    Boveda boveda;    
    
    public Cajero() {
        boveda = Boveda.getInstance();
    }
    
    @Override
    public boolean autorizar(Operacion operacion) {
        switch(operacion.getOperacion()){
            case RETIRO:{
                return operacion.getMonto()>=1 && operacion.getMonto()<=1000;
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
