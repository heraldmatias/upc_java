/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva.enums;

/**
 *
 * @author alumno
 */
public enum TipoCuenta {
    
    DEBITO (1, "Cuenta debito"),
    CREDITO (2, "Cuenta credito");
    
    Integer id;
    String label; 
    
    TipoCuenta(Integer id, String label) {
        this.id = id;
        this.label = label;        
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
    
    
}
