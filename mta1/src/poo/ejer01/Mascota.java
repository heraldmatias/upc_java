/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package poo.ejer01;

/**
 * Desarrollar una clase mascota que tenga los atributos correctos desde el
 * punto de vista de una veterinaria. Deberá tener un método llamado
 * estaVacunado() que indique si la mascota está vacunada o no. Deberá devolver
 * true si está vacunado y false si no está vacunado.
 *
 * @author heraldo
 */
public class Mascota {

    private boolean vacunado;
    private String nombre;
    private String propietario;
    private String especie;
    private int edad;
    private String raza;

    public boolean estaVacunado() {
        return vacunado;
    }

    public void setVacunado(boolean vacunado) {
        this.vacunado = vacunado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }
}
