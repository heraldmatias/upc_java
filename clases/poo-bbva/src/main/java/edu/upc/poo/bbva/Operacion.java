package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 * Todo movimiento realizado con el boveda se registra mediante una operacion.
 * @author gian.corzo
 */
public class Operacion {

    private TipoOperacion operacion;
    private double monto;
    
    public Operacion() {
    }

    public Operacion(TipoOperacion operacion, double monto) {
        this.operacion = operacion;
        this.monto = monto;
    }

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }    
}
