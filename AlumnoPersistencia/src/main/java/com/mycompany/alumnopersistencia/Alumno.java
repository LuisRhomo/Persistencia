
package com.mycompany.alumnopersistencia;

import java.io.Serializable;


public class Alumno implements Serializable{
    private int matricula;
    private String nombre;
    private String email;

    public Alumno(int matricula, String nombre, String email) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.email = email;
    }

    public int getMatricula() {
        return matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "matricula=" + matricula + ", nombre=" + nombre + ", email=" + email + '}';
    }
    
    
}
