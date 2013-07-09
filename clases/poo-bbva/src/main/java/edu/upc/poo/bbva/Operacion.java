package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 * Todo movimiento realizado con el boveda se registra mediante una operacion.
 * @author gian.corzo
 */
public class Operacion {

    private TipoOperacion operacion;
    private double monto;
    private Cliente cliente;
    
    public Operacion(TipoOperacion operacion, Cliente cliente) {
        this.operacion = operacion;
        this.cliente = cliente;
    }

    public Operacion(TipoOperacion operacion, double monto, Cliente cliente) {
        this.operacion = operacion;
        this.monto = monto;
        this.cliente = cliente;
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
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
