/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva;

/**
 *
 * @author alumno
 */
public abstract class Empleado {
    
    private String nombre;
    private String dni;

    public Empleado() {
    }

    public Empleado(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }    
    
    public abstract boolean autorizar(Operacion operacion);    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
}
