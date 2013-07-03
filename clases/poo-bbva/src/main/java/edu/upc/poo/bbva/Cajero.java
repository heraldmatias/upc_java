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
   
    public void hacerDeposito(double monto) {
        boveda.deposito(monto);        
    }
    
    public double hacerRetiro(double monto) {        
        double aRetornar = boveda.retiro(monto);
        return aRetornar;
    }

    @Override
    public boolean autorizar(TipoOperacion tipo,Cliente cliente) {
        return false;
    }

    @Override
    public boolean autorizar(TipoOperacion tipo, Cliente cliente, double monto) {
        switch(tipo){
            case RETIRO:{
                return monto>=1 && monto<=1000;
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
