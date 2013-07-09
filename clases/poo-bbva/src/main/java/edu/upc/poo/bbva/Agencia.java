package edu.upc.poo.bbva;

import edu.upc.poo.bbva.enums.TipoCuenta;
import java.util.ArrayList;
import java.util.List;

/**
 * Agencia BBVA
 *
 */
public class Agencia 
{   
    private static int NUM_CAJAS = 4;
    private static int NUM_PLATAFORMAS = 3;    
    
    private List<Caja> cajas = new ArrayList<Caja>();
    private List<Plataforma> plataformas = new ArrayList<Plataforma>();
    private int turno = 0;
    private int turnop = 0;

    public Agencia() {
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas.add(new Caja());
        }
        for (int i = 0; i < NUM_PLATAFORMAS; i++) {
            plataformas.add(new Plataforma());
        }
    }

    public Caja obtenerCaja() {
        Caja c = cajas.get(turno);
        turno++;
        if (turno > NUM_CAJAS) { turno = 0; }
        return c;
    }
    
    public Plataforma obtenerPlataforma() {
        Plataforma p = plataformas.get(turnop);
        turnop++;
        if (turnop > NUM_PLATAFORMAS) { turnop = 0; }
        return p;
    }
    
    public static void main( String[] args )
    {
        //Pruebas
        Agencia agencia = new Agencia();
        Cliente cliente = new Cliente("Juan",18);
        //ATENCION A CLIENTE
        Caja caja = agencia.obtenerCaja();
        Plataforma plataforma = agencia.obtenerPlataforma();        
        //SE ATENDERA AL CLIENTE
        caja.setCliente(cliente);        
        plataforma.setCliente(cliente);
        
        if(caja.hacerDeposito(2000)){
            System.out.println("Deposito con exito");
        }else{
            System.out.println("Deposito no valido");
        }
        if(caja.hacerRetiro(500) != -1){
            System.out.println("Retiro con exito");
        }else{
            System.out.println("Retiro no valido");
        }
        
        if(plataforma.aprobarCredito(5000)){
            System.out.println("Credito aprobado con exito");
        }else{
            System.out.println("Retiro no valido");
        }
        String cuenta = plataforma.aperturarCuenta(TipoCuenta.DEBITO);
        if(cuenta != null){
            System.out.println(cuenta);
        }else{
            System.out.println("No se aperturo la cuenta");
        }
        
        cuenta = plataforma.aperturarCuenta(TipoCuenta.CREDITO);
        if(cuenta != null){
            System.out.println(cuenta);
        }else{
            System.out.println("No se aperturo la cuenta");
        }
    }
}
