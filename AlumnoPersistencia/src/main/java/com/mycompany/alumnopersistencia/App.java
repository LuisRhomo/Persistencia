/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alumnopersistencia;

import java.util.Scanner;

/**
 *
 * @author Administrador
 */
public class App {

    public static void main(String[] args) {
        AlumnoController ac = new AlumnoController();
        while (true) {
            System.out.println("Sistema Persistente de alumnos");
            System.out.println("------------------------------");
            System.out.println("1. Capturar");
            System.out.println("2. Ver lista");
            System.out.println("3. Actualizar alumnos");
            System.out.println("4. Eliminar alumno");
            System.out.println("Eliga la opcion:");
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    ac.iniciarCaptura();
                    break;
                case 2:
                    ac.verLista();
                    break;
                case 3:
                    ac.actualizarAlumno();
                    break;
                case 4:
                    ac.eliminarAlumno();
                    break;
                default:
                    System.out.println("Numero incorrecto");
            }
        }
    }
}
