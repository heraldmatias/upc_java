package edu.upc.poo.bbva;

import java.util.ArrayList;
import java.util.List;

/**
 * Agencia BBVA
 *
 */
public class Agencia 
{   
    private static int NUM_CAJEROS = 4;
    
    
    private List<Cajero> cajeros = new ArrayList<Cajero>();
    private int turno = 0;

    public Agencia() {
        for (int i = 0; i < NUM_CAJEROS; i++) {
            cajeros.add(new Cajero());
        }
    }

    public Cajero obtenerCajero() {
        Cajero c = cajeros.get(turno);
        turno++;
        if (turno > NUM_CAJEROS) { turno = 0; }
        return c;
    }  
    
    public static void main( String[] args )
    {
        //Pruebas
        Agencia agencia = new Agencia();        
        agencia.obtenerCajero().hacerDeposito(1000.0);
    }
}
