/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alumnopersistencia;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class AlumnoController {

    private Scanner scanner = new Scanner(System.in);
    private AlumnoDAO alumnoDAO = new AlumnoDAOImplXML();

    //Iniciar la captura de alumnos
    public void iniciarCaptura() {
        System.out.println("No de alumnos a capturar");
        int cantidadAlumnos = scanner.nextInt();
        for (int i = 0; i < cantidadAlumnos; i++) {
            capturarAlumno();
        }
    }
    
    //Metodo para capturar
    public void capturarAlumno() {
        System.out.println("Matricula:");
        int matricula = scanner.nextInt();
        scanner.skip("\n");
        System.out.println("Nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        alumnoDAO.agregarAlumno(new Alumno(matricula, nombre, email));
    }

    //Metodo para listar
    public void verLista() {
        List<Alumno> lista = alumnoDAO.recuperarAlumnos();
        System.out.println("Lista de alumnos");
        for (Alumno alumno : lista) {
            System.out.println(alumno);
        }
    }

    //Metodo para actualizar
    public void actualizarAlumno() {
        System.out.println("Matricula a modificar");
        int matricula = scanner.nextInt();
        scanner.skip("\n");
        Alumno alumno = alumnoDAO.recuperarAlumno(matricula);
        if (alumno != null) {
            System.out.println(alumno);
            System.out.println("Nuevo Nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Email:");
            String email = scanner.nextLine();
            alumnoDAO.actualizarAlumno(new Alumno(matricula,nombre,email));
        }
    }
    
    //Metodo para eliminar
    public void eliminarAlumno(){
        System.out.println("Matricula a eliminar:");
        int matricula = scanner.nextInt();
        Alumno alumno = alumnoDAO.recuperarAlumno(matricula);
        if(alumno != null){
            System.out.println("Eliminando: " + alumno);
            alumnoDAO.eliminarAlumno(matricula);     
        }
    }

}
