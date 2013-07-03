/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumno
 */
public class Cliente {
    
    private List<Documento> documentos = new ArrayList<Documento>();
    private String nombre;
    private int edad;

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
    
}
