package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoCuenta;

/**
 *
 * @author gian.corzo
 */
public class Plataforma {
        
    public void aperturarCuenta(TipoCuenta cuenta){
        System.out.println(cuenta.getLabel()+" aperturada con exito");
    }
    
    public void cancelarCuenta(TipoCuenta cuenta){
        System.out.println(cuenta.getLabel()+" cancelada con exito");
    }
    
    public String entregaTarjeta(TipoCuenta cuenta){
        return "";
    }
    
    public void tramitarPrestamo(){
        
    }
    
}
