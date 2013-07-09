/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.poo.bbva;

/**
 *
 * @author alumno
 */
public class Cliente {
    
    private String nombre;
    private int edad;

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Cliente() {
        this("Sin nombre", (int)Math.random()*50+18);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    
}
