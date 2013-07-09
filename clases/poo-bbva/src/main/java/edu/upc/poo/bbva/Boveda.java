package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoOperacion;
import java.util.ArrayList;
import java.util.List;

/**
 * Sigue el patron singleton y del cual sólo se puede obtener un unico objeto.
 * Sirve para que no necesitemos instanciar más de un objeto a la vez
 *
 * @author gian.corzo
 */
public class Boveda {

    private static Boveda instance = null;
    private double saldoEnBoveda;
    private List<Operacion> operaciones = new ArrayList<Operacion>();

    private Boveda() {
    }

    private static void createInstance() {
        if (instance == null) {
            // Sólo se accede a la zona sincronizada cuando la instancia no está creada
            synchronized (Boveda.class) {
                // En la zona sincronizada sería necesario volver a comprobar que no se ha creado la instancia
                if (instance == null) {
                    instance = new Boveda();
                }
            }
        }
    }

    public static Boveda getInstance() {
        createInstance();
        return instance;
    }

    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void deposito(Operacion operacion) {
        if (operacion.getOperacion() == TipoOperacion.DEPOSITO && operacion.getMonto() > 0) {
            saldoEnBoveda += operacion.getMonto();
            operaciones.add(operacion);
        }
        //operaciones.add(new Operacion(TipoOperacion.DEPOSITO,monto));
    }

    public double retiro(Operacion operacion) {
        if (operacion.getOperacion() == TipoOperacion.RETIRO && operacion.getMonto() > 0) {
            if (saldoEnBoveda > 0 && saldoEnBoveda >= operacion.getMonto()) {
                saldoEnBoveda -= operacion.getMonto();
                return operacion.getMonto();
            }
        }
        return -1; // cuando la boveda retorna -1 entonces es error
    }

    public double getSaldoEnBoveda() {
        return saldoEnBoveda;
    }

    public void setSaldoEnBoveda(double saldoEnBoveda) {
        this.saldoEnBoveda = saldoEnBoveda;
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void setOperaciones(List<Operacion> operaciones) {
        this.operaciones = operaciones;
    }
}
