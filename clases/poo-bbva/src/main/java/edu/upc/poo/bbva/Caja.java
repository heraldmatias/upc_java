/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 *
 * @author heraldo
 */
public class Caja {

    Boveda boveda;
    private Cajero cajero;
    private Cliente cliente;

    public Caja() {
        boveda = Boveda.getInstance();
        this.cajero = new Cajero();
    }    

    public boolean hacerDeposito(double monto) {
        Operacion ope = new Operacion(TipoOperacion.DEPOSITO, monto, cliente);
        if (this.cajero.autorizar(ope)) {
            boveda.deposito(ope);
            return true;
        }
        return false;
    }

    public double hacerRetiro(double monto) {
        Operacion ope = new Operacion(TipoOperacion.RETIRO, monto, cliente);
        double aRetornar = 0;
        if (this.cajero.autorizar(ope)) {
            aRetornar = boveda.retiro(ope);
        }
        return aRetornar;
    }
    
    public boolean hacerDesembolso(double monto) {
        Operacion ope = new Operacion(TipoOperacion.DESEMBOLSO, monto, cliente);
        double aRetornar = 0;
        if (this.cajero.autorizar(ope)) {
            aRetornar = boveda.retiro(ope);
        }
        return aRetornar != -1;
    }
    
    public boolean pagarServicio(double monto) {
        Operacion ope = new Operacion(TipoOperacion.PAGO_SERVICIO, monto, cliente);        
        if (this.cajero.autorizar(ope)) {
            boveda.deposito(ope);
            return true;
        }
        return false;
    }

    public Cajero getCajero() {
        return cajero;
    }

    public void setCajero(Cajero cajero) {
        this.cajero = cajero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
