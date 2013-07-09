/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Archivador {
    
    private static Archivador instance = null;
    private List<Documento> documentos = new ArrayList<Documento>();
    
    private static void createInstance() {
        if (instance == null) {
            // Sólo se accede a la zona sincronizada cuando la instancia no está creada
            synchronized(Archivador.class) {
                // En la zona sincronizada sería necesario volver a comprobar que no se ha creado la instancia
                if (instance == null) { 
                    instance = new Archivador();
                }
            }
        }
    }    
    
    /**
     *
     * @return
     */
    public static Archivador getInstance() {
        createInstance();
        return instance;
    }
    
    //El método "clone" es sobreescrito por el siguiente que arroja una excepción:
    @Override
    public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException(); 
    }
    
    public boolean validarDocumentos(Cliente cliente) {
        for (Iterator<Documento> it = this.documentos.iterator(); it.hasNext();) {
            Documento documento = it.next();
            return true;
        }
        return false;
    }    
}
