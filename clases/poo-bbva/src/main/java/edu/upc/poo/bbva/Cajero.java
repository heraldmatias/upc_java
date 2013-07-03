package edu.upc.poo.bbva;

/**
 * El cajero de encarga de realizar deposito, retirar dinero y realizar algunas
 * operaciones simples
 * 
 * @author gian.corzo
 */
public class Cajero {

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
}
