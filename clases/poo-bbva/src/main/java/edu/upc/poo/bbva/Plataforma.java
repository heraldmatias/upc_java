package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoCuenta;
import edu.upc.poo.bbva.enums.TipoOperacion;

/**
 *
 * @author gian.corzo
 */
public class Plataforma {

    Boveda boveda;
    private Gerente gerente;
    private Subgerente subgerente;
    private Cliente cliente;
    private Archivador archivador;

    public Plataforma() {
        archivador = Archivador.getInstance();
        boveda = Boveda.getInstance();
        this.gerente = new Gerente();
        this.subgerente = new Subgerente();
    }

    public String aperturarCuenta(TipoCuenta cuenta) {
        if (archivador.validarDocumentos(cliente)) {
            Operacion ope = new Operacion(TipoOperacion.APERTURA_CUENTA, cliente);
            if (this.gerente.autorizar(ope)) {
                switch (cuenta) {
                    case CREDITO: {
                        return this.entregaTarjeta(cuenta);
                    }
                    case DEBITO: {
                        return this.entregaTarjeta(cuenta);
                    }
                }
            }
        }
        return null;
    }

    public boolean cancelarCuenta(TipoCuenta cuenta) {
        if (archivador.validarDocumentos(cliente)) {
            Operacion ope = new Operacion(TipoOperacion.CANCELACION_CUENTA, cliente);
            if (this.gerente.autorizar(ope)) {
                switch (cuenta) {
                    case CREDITO: {
                        return true;
                    }
                    case DEBITO: {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean aprobarCredito(double monto) {
        if (archivador.validarDocumentos(cliente)) {
            Operacion ope = new Operacion(TipoOperacion.CREDITO, monto, cliente);
            return this.gerente.autorizar(ope);
        }
        return false;
    }

    public double hacerDesembolso(double monto) {
        Operacion ope = new Operacion(TipoOperacion.DESEMBOLSO, monto, cliente);
        double aRetornar = 0;
        aRetornar = boveda.retiro(ope);
        return aRetornar;
    }

    private String entregaTarjeta(TipoCuenta cuenta) {
        String numero = "";
        for (int i = 0; i < 10; i++) {
            numero += (int) (Math.random() * 10);
        }
        return cuenta.getLabel() + ": " + numero;
    }

    public void tramitarPrestamo() {
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Subgerente getSubgerente() {
        return subgerente;
    }

    public void setSubgerente(Subgerente subgerente) {
        this.subgerente = subgerente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
